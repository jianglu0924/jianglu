package com.baidu.myexception;


public class CustumException extends Exception {

	//�쳣��Ϣ
	private  String message ;
	
	public CustumException(String message){
		
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
