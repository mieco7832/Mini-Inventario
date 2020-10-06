package com.miec.utils;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// Inicialización del Servidor Con Soporte
public class Initial extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses(){
		return new Class[] {Configs.class};
	}
	
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {Webs.class};
	}
	
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
}
