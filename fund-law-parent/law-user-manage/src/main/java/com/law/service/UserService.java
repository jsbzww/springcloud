package com.law.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.law.dao.UserDao;
import com.law.entity.User;
import com.law.exception.UserLoginException;
import com.law.util.BPwdEncoderUtil;


@Service
public class UserService {

	@Autowired
	private UserDao userRepository;
	
	
	public User loadUserByUsername(String username)  {
		return userRepository.findByUsername(username);
	}
	
	public User insertUser(String username, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(BPwdEncoderUtil.BCryptPassword(password));
		return userRepository.save(user);
	}
	
	public User login(String username, String password) {
		User user = userRepository.findByUsername(username);
		if(null == null) {
			throw new UserLoginException("error username");
		}
		
		if(!BPwdEncoderUtil.matches(password, user.getPassword())) {
			throw new UserLoginException("error password");
		}
		
		
		return user;
	}
	
	

}
