package com.side.ws.converters;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.side.ws.dto.RoleDto;
import com.side.ws.entities.Role;


@Component
public class RoleConverter {

	@Transactional
	public RoleDto entityToDto(Role role) {
		RoleDto roleDto = new RoleDto();
		roleDto.setName(role.getName());
		roleDto.setRoleId(role.getRoleId());
		return roleDto;
	}
	
	@Transactional
	public List<RoleDto> entityToDto(List<Role> roles) {
		return roles.stream().map(this::entityToDto).collect(Collectors.toList());
	}
	
	@Transactional
	public Role dtoToEntity(RoleDto dto) {
		Role role = new Role();
		role.setRoleId(dto.getRoleId());
		role.setName(dto.getName());
		return role;
	}
	
	@Transactional
	public List<Role> dtoToEntity(List<RoleDto> dtos) {
		return dtos.stream().map(this::dtoToEntity).collect(Collectors.toList());
	}
}
