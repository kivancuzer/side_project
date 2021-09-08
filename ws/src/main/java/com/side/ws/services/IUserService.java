package com.side.ws.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.side.ws.entities.User;

@Component
public interface IUserService {

	List<User> findAll();
	
	User findById(Long userId);
	
	User findByEmail(String email);
	
	void update(User user);
	
	void delete(Long userId);
	
	void register(User user);
	
}
