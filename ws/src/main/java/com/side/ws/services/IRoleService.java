package com.side.ws.services;

import java.util.List;

import com.side.ws.dto.RoleDto;
import com.side.ws.entities.Role;

public interface IRoleService {

	void save(RoleDto roleDto);
	
	void delete(Long roleId);
	
	Role findById(Long roleId);
	
	Role findByName(String name);
	
	List<Role> findAll();
	
	boolean existsByName(String name);
	
}
