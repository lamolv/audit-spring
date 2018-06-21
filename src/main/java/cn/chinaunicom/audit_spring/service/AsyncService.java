package cn.chinaunicom.audit_spring.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import cn.chinaunicom.spring.annotation.Action;

@Service
public class AsyncService {

	@Async
	@Action(name = "doAsyncMethod")
	public void doAsyncMethod(int obj){
		System.out.println("异步任务:" +obj);
	}
	
	@Async
	public void doAsyncAddMethod(int obj){
		Long.valueOf("ss");
		System.out.println("异步任务+1:" + obj++);
	}
}
