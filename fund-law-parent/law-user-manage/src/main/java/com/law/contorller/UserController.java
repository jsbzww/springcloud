package com.law.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.law.entity.User;
import com.law.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;

	@GetMapping("/register")
	public User postUser(@RequestParam("username") String username, @RequestParam("password") String password) {

		return userService.insertUser(username,password);
	}

	@GetMapping("/login")
	public User login(@RequestParam("username") String username, @RequestParam("password") String password) {

		return userService.login(username,password);
	}
	
	
}
