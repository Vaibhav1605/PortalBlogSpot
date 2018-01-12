package com.portal.portalmiddle.initializer;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.portal.portalmiddle.config.WebAppConfig;
import com.portal.portalmiddle.filter.CORSFilter;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{WebAppConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	
	@Override
	protected Filter[] getServletFilters() {
		// TODO Auto-generated method stub
		return new Filter[]{new CORSFilter()};
	}

}
