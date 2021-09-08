package com.side.ws.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RoleDto {

	@Min(value = 1)
	private Long roleId;
	
	@NotNull(message = "name cannot be null")
	@NotEmpty(message = "name may not be empty")
	@NotBlank(message = "name may not be blank")
	private String name;
	
}
