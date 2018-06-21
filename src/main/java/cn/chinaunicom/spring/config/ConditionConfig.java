package cn.chinaunicom.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import cn.chinaunicom.audit_spring.service.ListService;
import cn.chinaunicom.audit_spring.service.WindowsListService;
import cn.chinaunicom.spring.condition.LinuxCondition;
import cn.chinaunicom.spring.condition.WindowsCondition;

@Configuration
public class ConditionConfig {

	@Bean
	@Conditional(WindowsCondition.class)
	public ListService windowListService(){
		return new WindowsListService();
	}
	
	@Bean
	@Conditional(LinuxCondition.class)
	public ListService linuxListService(){
		return new WindowsListService();
	}
}
