package com.bawei.ssm.service.Impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bawei.ssm.dto.Company;
import com.bawei.ssm.dto.Emp;
import com.bawei.ssm.dto.Position;
import com.bawei.ssm.dto.User;
import com.bawei.ssm.mapper.UserMapper;
import com.bawei.ssm.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;

	
	
	
	
	//***************************************
	
	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public Integer count(User user) {
		// TODO Auto-generated method stub
		return userMapper.count(user);
	}

	@Override
	public List<User> list(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return userMapper.list(map);
	}

	@Override
	public List<Company> findCompany() {
		// TODO Auto-generated method stub
		return userMapper.findCompany();
	}

	@Override
	public List<Position> findPosition() {
		// TODO Auto-generated method stub
		return userMapper.findPosition();
	}

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		userMapper.add(user);
	}

	@Override
	public User findUserById(User user) {
		// TODO Auto-generated method stub
		return userMapper.findUserById(user);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		userMapper.update(user);
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		userMapper.delete(user);
	}

	@Override
	public Emp login(Emp emp) {
		// TODO Auto-generated method stub
		return userMapper.login(emp);
	}
	
	
	

}
