package com.mohamed.app.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		
		auth.jdbcAuthentication()
	      .dataSource(dataSource);
		
//		UserBuilder users = User.withDefaultPasswordEncoder();
//
//		auth.inMemoryAuthentication().withUser(users.username("john").password("test123").roles("EMPLOYEE"))
//				.withUser(users.username("mary").password("test123").roles("EMPLOYEE", "MANAGER"))
//				.withUser(users.username("susan").password("test123").roles("EMPLOYEE", "ADMIN"));
		
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET,    "/api/student").hasRole("EMPLOYEE")
		.antMatchers(HttpMethod.GET,    "/api/student/**").hasRole("EMPLOYEE")
		.antMatchers(HttpMethod.POST,   "/api/student/**").hasAnyRole("MANAGER", "ADMIN")
		.antMatchers(HttpMethod.DELETE, "/api/student/**").hasAnyRole("MANAGER", "ADMIN")
		.antMatchers(HttpMethod.PUT,    "/api/student/**").hasAnyRole("MANAGER", "ADMIN")
		
		.antMatchers(HttpMethod.GET,    "/api/instructor").hasRole("EMPLOYEE")
		.antMatchers(HttpMethod.GET,    "/api/instructor/**").hasRole("EMPLOYEE")
		.antMatchers(HttpMethod.POST,   "/api/instructor/**").hasAnyRole("MANAGER", "ADMIN")
		
		.antMatchers(HttpMethod.GET,    "/api/courses").hasRole("EMPLOYEE")
		.antMatchers(HttpMethod.GET,    "/api/courses/**").hasRole("EMPLOYEE")
		.antMatchers(HttpMethod.POST,   "/api/courses/**").hasAnyRole("MANAGER", "ADMIN")
		.antMatchers(HttpMethod.DELETE, "/api/student/**").hasAnyRole("MANAGER", "ADMIN")
		.antMatchers(HttpMethod.PUT,    "/api/student/**").hasAnyRole("MANAGER", "ADMIN")
		.and()
		.httpBasic()
		.and()
		.csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		
		
		
	}
	
}
