package com.side.ws.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.side.ws.entities.Device;
import com.side.ws.entities.User;

public interface DeviceRepository extends JpaRepository<Device,Long> {

	Device findByDeviceId(String deviceId);
	
	List<Device> findByUser(User user);
	
}
