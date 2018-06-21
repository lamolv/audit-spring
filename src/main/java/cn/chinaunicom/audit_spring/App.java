package cn.chinaunicom.audit_spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.chinaunicom.audit_spring.service.AsyncService;
import cn.chinaunicom.audit_spring.service.ListService;
import cn.chinaunicom.spring.config.SpringConfig;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SpringConfig.class);
		
		ListService service = context.getBean(ListService.class);
		
		System.out.println(service.showListCmd());
		
//		AsyncService service = context.getBean(AsyncService.class);
		
//		service.sayHello();
//		service.add();
//		service.outputResource();
		
		/*for(int i=0; i< 10; i++){
			service.doAsyncMethod(i);
			service.doAsyncAddMethod(i);
		}*/
//		service.doAsyncAddMethod(3);
		
//		context.close();
	
	}
}
