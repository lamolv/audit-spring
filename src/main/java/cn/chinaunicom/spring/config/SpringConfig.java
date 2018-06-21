package cn.chinaunicom.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages={"cn.chinaunicom"})
public class SpringConfig {

	/*@Bean
	public PropertySourcesPlaceholderConfigurer propertyConfig(){
		return new PropertySourcesPlaceholderConfigurer();
	}*/
}
