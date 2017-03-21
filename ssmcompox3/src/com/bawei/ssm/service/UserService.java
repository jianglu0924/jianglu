package com.bawei.ssm.service;

import java.util.HashMap;
import java.util.List;

import com.bawei.ssm.dto.Company;
import com.bawei.ssm.dto.Emp;
import com.bawei.ssm.dto.Position;
import com.bawei.ssm.dto.User;

public interface UserService {

	Integer count(User user);

	List<User> list(HashMap<String, Object> map);

	List<Company> findCompany();

	List<Position> findPosition();

	void add(User user);

	User findUserById(User user);

	void update(User user);

	void delete(User user);

	Emp login(Emp emp);

}
