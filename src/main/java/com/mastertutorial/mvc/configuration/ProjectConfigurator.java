/**
 * 
 */
package com.mastertutorial.mvc.configuration;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import net.sf.ehcache.CacheManager;

/**
 * @author Yashwanth
 *
 */
@Configuration
@EnableWebMvc
@EnableCaching
@ComponentScan(basePackages="com.mastertutorial.mvc")
public class ProjectConfigurator extends WebMvcConfigurerAdapter{
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
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/client/**").addResourceLocations("/client/**");
	}
	
	@Bean
	public org.springframework.cache.CacheManager cacheManager() {
		
		return new EhCacheCacheManager(ehCacheCacheManager().getObject());
	}
	
	@Bean
	public EhCacheManagerFactoryBean ehCacheCacheManager() {
		EhCacheManagerFactoryBean factory = new EhCacheManagerFactoryBean();
		factory.setConfigLocation(new ClassPathResource("ehcache.xml"));
		factory.setShared(true);
		return factory;
	}
}
