
package com.mastertutorial.mvc.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @author Yashwanth
 *
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
	
private static final String   Resource_ID="my_rest_api";

public void configure(ResourceServerSecurityConfigurer resource) {
	resource.resourceId(Resource_ID).stateless(false);
}


public void configure(HttpSecurity http) throws Exception{
	 /*http.
     anonymous().disable()
     .requestMatchers().antMatchers("/user/**")
     .and().authorizeRequests()
     .antMatchers("/user/**").access("hasRole('ADMIN')")
     .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());*/
 }

}
