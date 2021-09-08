package com.side.ws.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.side.ws.entities.Device;

@Component
public interface IDeviceService {

	void save(Device device);
	
	void delete(String deviceId);
	
	List<Device> findAll();
	
	List<Device> findByUserId(Long userId);
	
	Device findById(String deviceId);
	
}
