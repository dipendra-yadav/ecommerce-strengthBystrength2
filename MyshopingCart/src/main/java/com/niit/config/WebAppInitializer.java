package com.niit.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { WebAppConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebAppConfig.class };
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		super.onStartup(servletContext);
		// activating Profile
		servletContext.setInitParameter("spring.profiles.active", "production");
		System.out.println("production profile activated!!");
	}

}
