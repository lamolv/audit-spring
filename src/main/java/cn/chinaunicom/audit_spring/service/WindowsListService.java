package cn.chinaunicom.audit_spring.service;

import org.springframework.stereotype.Service;

public class WindowsListService implements ListService {

	@Override
	public String showListCmd() {
		return "dir";
	}

}
