package cn.chinaunicom.spring.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import cn.chinaunicom.spring.annotation.Action;

@Aspect
@Component
public class ActionAspect {

	@After("@annotation(cn.chinaunicom.spring.annotation.Action)")
	public void after(JoinPoint jp){
		
		Method method = ((MethodSignature) jp.getSignature()).getMethod();
		Action action = method.getAnnotation(Action.class);
		
		System.out.println("注解式拦截After：" + action.name());
		
	}
	
//	@Before("execution(* cn.chinaunicom.audit_spring.service.FunctionService.*(..))")
	public void before(JoinPoint jp){
		Method method = ((MethodSignature) jp.getSignature()).getMethod();
		
		System.out.println("方法名规则式拦截Before：" + method.getName());
	}
	
//	@Around("execution(* cn.chinaunicom.audit_spring.service.FunctionService.*(..))")
	public Object around(ProceedingJoinPoint pjp){
		
		Method method = ((MethodSignature) pjp.getSignature()).getMethod();
		
		try {
			System.out.println("方法前拦截Around：" + method.getName());
			Object obj = pjp.proceed();
			System.out.println("方法后拦截Around：" + method.getName());
			
			return obj;
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
