package com.law.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.law.entity.User;



public interface UserDao extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
