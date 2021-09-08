package com.side.ws.services.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.side.ws.entities.Role;
import com.side.ws.entities.User;
import com.side.ws.exceptions.NotFoundException;
import com.side.ws.repositories.UserRepository;
import com.side.ws.services.IRoleService;
import com.side.ws.services.IUserService;

@Service
public class UserManager implements IUserService, UserDetailsService {

	Logger logger = LoggerFactory.getLogger(UserManager.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private IRoleService roleService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		return this.userRepository.findAll();
	}

	@Override
	public User findById(Long userId) {
		return this.userRepository.findById(userId)
				.orElseThrow(() -> new NotFoundException("User not found with userId:" + userId));
	}

	@Override
	public User findByEmail(String email) {
		return this.userRepository.findByEmail(email);
	}

	@Override
	public void update(User user) {
		this.userRepository.save(user);

	}

	@Override
	public void delete(Long userId) {
		User user = findById(userId);
		user.setActive(false);
		update(user);
	}

	@Override
	public void register(User user) {
		// Encode User's password
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		this.userRepository.save(user);
	}

	@Transactional
	public Set<SimpleGrantedAuthority> getAuthority(User user) throws InterruptedException, ExecutionException {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		Role role = roleService.findById(user.getRole().getRoleId());
		authorities.add(new SimpleGrantedAuthority(role.getName()));
		return authorities;
	}

}
