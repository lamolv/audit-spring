package cn.chinaunicom.audit_spring.service;

import org.springframework.stereotype.Service;

public class LinuxListService implements ListService {

	@Override
	public String showListCmd() {
		return "dir";
	}

}
