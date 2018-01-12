package com.portal.portalmiddle.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.portal")
@EnableWebMvc
public class WebAppConfig extends AnnotationConfigApplicationContext {
	@Bean
	public InternalResourceViewResolver getViewResolver(){
		return new InternalResourceViewResolver("/WEB-INF/views/",".jsp");
	}

}
