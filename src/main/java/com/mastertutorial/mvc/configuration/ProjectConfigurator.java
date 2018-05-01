/**
 * 
 */
package com.mastertutorial.mvc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * @author Yashwanth
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.mastertutorial.mvc")
public class ProjectConfigurator {
	public ProjectConfigurator() {

	}
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setViewClass(JstlView.class);
		internalResourceViewResolver.setSuffix(".jsp");
		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
		return internalResourceViewResolver;
	}
	
	/*@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/client/**").addResourceLocations("/client/**");
	}*/
}
