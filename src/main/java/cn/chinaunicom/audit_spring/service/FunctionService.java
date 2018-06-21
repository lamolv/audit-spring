package cn.chinaunicom.audit_spring.service;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import cn.chinaunicom.spring.annotation.Action;

@Service
public class FunctionService implements ResourceLoaderAware{

	@Value("functionName")
	private String functionName;
	
	private ResourceLoader loader;
	
	@Action(name="annotation action")
	public void sayHello(){
		System.out.println("sayHello()...");
		
		Resource resource = loader.getResource("classpath:el.properties");
		
		try {
			System.out.println(IOUtils.toString(resource.getInputStream(),"UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void add(){
		System.out.println("add()...");
	}

	public String getFunctionName() {
		return functionName;
	}
	
	public void init(){
		System.out.println("初始化...");
	}
	
	public void destroy(){
		System.out.println("销毁...");
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		loader = resourceLoader;
	}
	
}
