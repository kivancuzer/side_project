package com.side.ws.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.side.ws.entities.Device;
import com.side.ws.repositories.DeviceRepository;
import com.side.ws.services.IDeviceService;

import com.side.ws.services.IUserService;

@Service
public class DeviceManager implements IDeviceService {

	@Autowired
	private DeviceRepository deviceRepository;

	Logger logger = LoggerFactory.getLogger(DeviceManager.class);

	@Autowired
	private IUserService userService;

	@Override
	public List<Device> findAll() {
		return this.deviceRepository.findAll();
	}

	@Override
	public List<Device> findByUserId(Long userId) {
		return this.deviceRepository.findByUser(userService.findById(userId));
	}

	@Override
	public Device findById(String deviceId) {
		return this.deviceRepository.findByDeviceId(deviceId);
	}

	@Override
	public void save(Device device) {
		this.deviceRepository.save(device);

	}

	@Override
	public void delete(String deviceId) {
		Device device = findById(deviceId);
		device.setActive(false);
		save(device);

	}

}
