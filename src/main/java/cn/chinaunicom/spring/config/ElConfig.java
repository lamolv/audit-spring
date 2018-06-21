package cn.chinaunicom.spring.config;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

@Configuration
@PropertySource("classpath:el.properties")
public class ElConfig {
	
	static{
		Properties properties = new Properties();
		properties.put("key", "key");
	}

	@Value("normal_Str")
	private String normal;
	
	// StandardEnvironment systemProperties
	@Value("#{systemProperties['os.name']}")
	private String osName;
	
	@Value("#{systemProperties['java.version']}")
	private String systemProperty;
	
	// StandardEnvironment systemEnvironment 
	@Value("#{systemEnvironment['JAVA_HOME']}")
	private String envProperty;
	
	@Value("#{ T(java.lang.Math).random() * 100.0 }")
	private double randomNumber;
	
	@Value("#{functionService.functionName}")
	private String fromAnother;
	
	@Value("classpath:el.txt")
	private Resource testFile;
	
	@Value("http://www.baidu.com")
	private Resource testUrl;
	
	@Value("${book.author}")
	private String propertiesName;

	@Autowired
	private Environment enviroment;
	
//	@Autowired
//	private SystemEnvironmentPropertySource systemSource;
//	
	public void outputResource(){
		
		try {
			/*Properties p = System.getProperties();
			
			for(Map.Entry<Object,Object> entry : p.entrySet()){
				System.out.println(entry.getKey() + ": " + entry.getValue());
			}
			System.out.println("----------------------");
			Map<String,String> map = System.getenv();
			
			for(Map.Entry<String,String> entry : map.entrySet()){
				System.out.println(entry.getKey() + ": " + entry.getValue());
			}*/
			
			
			System.out.println(normal);
			System.out.println(osName);
			System.out.println(systemProperty);
			System.out.println(envProperty);
			System.out.println(randomNumber);
			System.out.println(fromAnother);
		
			System.out.println(IOUtils.toString(testFile.getInputStream(),Charset.forName("UTF-8")));
			System.out.println(IOUtils.toString(testUrl.getInputStream(), "UTF-8"));
			System.out.println(propertiesName);
			System.out.println(enviroment.getProperty("book.name"));

//			System.out.println(systemSource.getProperty("os.name"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
