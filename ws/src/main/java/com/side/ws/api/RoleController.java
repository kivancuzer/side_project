package com.side.ws.api;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.side.ws.dto.RoleDto;
import com.side.ws.entities.Role;
import com.side.ws.responses.GenericResponse;
import com.side.ws.services.IRoleService;

@RestController
@RequestMapping("/api")
public class RoleController {

	Logger logger = LoggerFactory.getLogger(RoleController.class);

	@Autowired
	private IRoleService roleService;

	@PostMapping("/0.1/roles/save")
	public ResponseEntity<GenericResponse> save(@RequestBody @Valid RoleDto roleDto) {
		if (!roleService.existsByName(roleDto.getName())) {
			this.roleService.save(roleDto);
			return ResponseEntity.ok(new GenericResponse("role saved successfully"));
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GenericResponse("Role already exists"));
		}

	}

	@GetMapping("/0.1/roles/findAll")
	public List<Role> findAll() {
		return this.roleService.findAll();
	}

}
