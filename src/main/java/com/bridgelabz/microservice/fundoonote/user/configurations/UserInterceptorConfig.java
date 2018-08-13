package com.bridgelabz.microservice.fundoonote.user.configurations;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.bridgelabz.microservice.fundoonote.user.interceptors.LoggerInterceptor;
import com.bridgelabz.microservice.fundoonote.user.interceptors.RequestProcessingTimeInterceptor;

public class UserInterceptorConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoggerInterceptor()).addPathPatterns("/**");
		registry.addInterceptor(new RequestProcessingTimeInterceptor()).addPathPatterns("/**");

	}
}
