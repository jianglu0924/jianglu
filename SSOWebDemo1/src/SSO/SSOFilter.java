package SSO;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import com.sun.corba.se.spi.protocol.RequestDispatcherRegistry;

public class SSOFilter implements Filter
{
  private FilterConfig filterConfig = null;
  private String cookieName = "SSOID";
  private String SSOServiceURL = "http://127.0.0.1:8080/SSOAuth/SSOAuth";
  private String SSOLoginPage = "http://127.0.0.1:8080/SSOAuth/login.jsp";
  private static final boolean debug = true;

  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
    throws IOException, ServletException
  {
    log("��֤������������");
    
    HttpServletRequest request = (HttpServletRequest)req;
    HttpServletResponse response = (HttpServletResponse)res;
    String result = "failed";
    
    //��ȡ��ǰ��Ŀ������·��(��������ת��Auth�󣬷���ԭ��Ŀ)
    String url = request.getRequestURL().toString();
    String qstring = request.getQueryString();
    if (qstring == null) qstring = "";
    String cookieValue = request.getParameter("cookie");
    if(cookieValue!=null&&!cookieValue.equals("")){
    	result = SSOService(cookieValue);
    }
    //���url��ַ�ϴ��ݹ�����CookieΪ�գ�����Ҫ���е�¼������
    if (qstring.indexOf("logout") > -1) {
    	Cookie[] cookies = request.getCookies();
    	for (Cookie cookie : cookies) {
			if(cookie.getName().equals("SSOID")&&!cookie.getValue().equals("undefined")){
				cookieValue = cookie.getValue();
			}
		}
        log("logout action!");
        logoutService(cookieValue);
        response.sendRedirect(this.SSOLoginPage + "?goto=" + url);
    } else if (result.equals("failed")) {
      response.sendRedirect(this.SSOLoginPage + "?goto=" + url);
    } else {
      request.setAttribute("SSOUser", result);
      Throwable problem = null;
      try {
        chain.doFilter(req, res);
      } catch (Throwable t) {
        problem = t;
        t.printStackTrace();
      }
      if (problem != null) {
        if ((problem instanceof ServletException)) throw ((ServletException)problem);
        if ((problem instanceof IOException)) throw ((IOException)problem);
        sendProcessingError(problem, res);
      }
    }
  }

  public FilterConfig getFilterConfig()
  {
    return this.filterConfig;
  }

  public void setFilterConfig(FilterConfig filterConfig)
  {
    this.filterConfig = filterConfig;
  }

  public void destroy()
  {
  }

  public void init(FilterConfig filterConfig)
  {
    this.filterConfig = filterConfig;
    if (filterConfig != null)
    {
      log("��֤��������ʼ��");
    }

    this.cookieName = filterConfig.getInitParameter("cookieName");
    this.SSOServiceURL = filterConfig.getInitParameter("SSOServiceURL");
    this.SSOLoginPage = filterConfig.getInitParameter("SSOLoginPage");
  }

  public String toString()
  {
    if (this.filterConfig == null) return "SSOFilter()";
    StringBuffer sb = new StringBuffer("SSOFilter(");
    sb.append(this.filterConfig);
    sb.append(")");
    return sb.toString();
  }

  private void sendProcessingError(Throwable t, ServletResponse response)
  {
    String stackTrace = getStackTrace(t);

    if ((stackTrace != null) && (!stackTrace.equals("")))
    {
      try
      {
        response.setContentType("text/html");
        PrintStream ps = new PrintStream(response.getOutputStream());
        PrintWriter pw = new PrintWriter(ps);
        pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n");

        pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");
        pw.print(stackTrace);
        pw.print("</pre></body>\n</html>");
        pw.close();
        ps.close();
        response.getOutputStream().close();
      }
      catch (Exception ex) {
      }
    }
    else try {
        PrintStream ps = new PrintStream(response.getOutputStream());
        t.printStackTrace(ps);
        ps.close();
        response.getOutputStream().close();
      }
      catch (Exception ex)
      {
      } 
  }

  public static String getStackTrace(Throwable t) {
    String stackTrace = null;
    try
    {
      StringWriter sw = new StringWriter();
      PrintWriter pw = new PrintWriter(sw);
      t.printStackTrace(pw);
      pw.close();
      sw.close();
      stackTrace = sw.getBuffer().toString(); } catch (Exception ex) {
    }
    return stackTrace;
  }

  private String SSOService(String cookievalue) throws IOException
  {
    String authAction = "?action=authcookie&cookiename=";
    HttpClient httpclient = new HttpClient();
    GetMethod httpget = new GetMethod(this.SSOServiceURL + authAction + cookievalue);
    try
    {
      httpclient.executeMethod(httpget);
      String result = httpget.getResponseBodyAsString();
      String str1 = result;
      return str1;
    }
    finally
    {
      httpget.releaseConnection();
    }
    //throw new LocalTransactionException();
  }

  private void logoutService(String cookievalue) throws IOException {
    String authAction = "?action=logout&cookiename=";
    HttpClient httpclient = new HttpClient();
    GetMethod httpget = new GetMethod(this.SSOServiceURL + authAction + cookievalue);
    try {
      httpclient.executeMethod(httpget);
      httpget.getResponseBodyAsString();
    } finally {
      httpget.releaseConnection();
    }
  }

  public void log(String msg)
  {
    this.filterConfig.getServletContext().log(msg);
    
  }
}