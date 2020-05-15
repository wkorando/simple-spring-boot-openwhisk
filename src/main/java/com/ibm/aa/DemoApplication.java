package com.ibm.aa;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	/**
	 * OpenWhisk requires a the content-length header to be supplied with an
	 * accurate count. By default Spring does not supply this header for performance
	 * reasons. Adding the org.springframework.web.filter.ShallowEtagHeaderFilter
	 * automatically adds content-length.
	 * 
	 * There is a performance cost to this as covered here:
	 * https://github.com/spring-projects/spring-framework/issues/21263
	 * 
	 * @return FilterRegistrationBean
	 */
	@Bean
	public FilterRegistrationBean<ShallowEtagHeaderFilter> filterRegistrationBean() {
		FilterRegistrationBean<ShallowEtagHeaderFilter> filterBean = new FilterRegistrationBean<ShallowEtagHeaderFilter>();
		filterBean.setFilter(new ShallowEtagHeaderFilter());
		filterBean.setUrlPatterns(Arrays.asList("/run"));
		return filterBean;
	}
}