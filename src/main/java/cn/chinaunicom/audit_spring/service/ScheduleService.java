package cn.chinaunicom.audit_spring.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

//@Service
public class ScheduleService {

	@Scheduled(cron="*/3 * * ? * *")
	public void schedule(){
		System.out.println("schedule定时任务执行");
	}
	
	@Scheduled(fixedDelay=3000L)
	public void fixRate(){
		System.out.println("fixRate定时任务执行");
	}
}
