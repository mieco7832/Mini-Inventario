package com.miec.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.miec"})
public class Webs implements WebMvcConfigurer{
	
	// Path de appweb
	@Bean
	public InternalResourceViewResolver vew() {
		InternalResourceViewResolver r = new InternalResourceViewResolver();
		r.setPrefix("/");
		r.setSuffix(".jsp");
		return r;
	}
	
	// Carpeta desiganda para recursos
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry r) {
		r.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
}