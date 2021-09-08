package com.side.ws.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.side.ws.converters.RoleConverter;
import com.side.ws.dto.RoleDto;
import com.side.ws.entities.Role;
import com.side.ws.exceptions.NotFoundException;
import com.side.ws.repositories.RoleRepository;
import com.side.ws.services.IRoleService;

@Service
public class RoleManager implements IRoleService {

	Logger logger = LoggerFactory.getLogger(RoleManager.class);

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private RoleConverter roleConverter;
	
	@Override
	public void save(RoleDto roleDto) {
		System.out.println(roleConverter.dtoToEntity(roleDto).toString());
		this.roleRepository.save(roleConverter.dtoToEntity(roleDto));
	}

	@Override
	public void delete(Long roleId) {
		Role role = findById(roleId);
		role.setActive(false);
		this.roleRepository.save(role);
	}

	@Override
	public Role findById(Long roleId) {
		return this.roleRepository.findById(roleId).orElseThrow(() -> new NotFoundException("Role not found with roleId:" + roleId));
	}

	@Override
	public Role findByName(String name) {
		return this.roleRepository.findByName(name);
	}

	@Override
	public List<Role> findAll() {
		return this.roleRepository.findAll();
	}

	@Override
	public boolean existsByName(String name) {
		return this.roleRepository.existsByName(name);
	}

}
