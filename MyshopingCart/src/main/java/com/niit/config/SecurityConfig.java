package com.niit.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig   extends WebSecurityConfigurerAdapter {

@Autowired
DataSource  datasource;
	
	

//<security:http>
@Override
protected void configure(HttpSecurity http) throws Exception {
	System.out.println("configure called******");
	
	http
	.authorizeRequests()
	.antMatchers("/").access("permitAll")
	.antMatchers("/home").access("permitAll")
	
	.and()
	.requiresChannel()
	.antMatchers("/login").requiresSecure();//brings https //channel enforcement
	
	http
	.authorizeRequests()
	.antMatchers("/login").access("permitAll")
	
	.antMatchers("/get**").access("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	.antMatchers("/adminHome").access("hasRole('ROLE_ADMIN')")//SPEL expression could be used
	.antMatchers("/manage_product_**").access("hasRole('ROLE_ADMIN')")
	.antMatchers("/manage_supplier_**").access("hasRole('ROLE_ADMIN')")
	.antMatchers("/manage_category_**").access("hasRole('ROLE_ADMIN')")
	
	.and()
	.formLogin().loginPage("/login")
	.loginProcessingUrl("/j_spring_security_check")
	.usernameParameter("j_username")
	.passwordParameter("j_password")
	.defaultSuccessUrl("/home")
	.failureUrl("/login?error")
	
	.and()
	.logout()
	.logoutUrl("/j_spring_security_logout")
	.logoutSuccessUrl("/login?logout")
	.invalidateHttpSession(true)
	
	
	.and()
	.csrf()
	.and()
	.exceptionHandling().accessDeniedPage("/invalid-access");
	
	
}

//<security:authentication-manager>
//<security:authentication-provider>
/*
public  void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("configureGlobal called*******");
		auth.jdbcAuthentication().dataSource(datasource)
		.usersByUsernameQuery("select name,password,enabled,from user where name=?")
		.authoritiesByUsernameQuery("select name,role from user where name=?");
}	*/
	

@Autowired
public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
	 System.out.println("configAuthentication called****");
  auth.jdbcAuthentication().dataSource(datasource).usersByUsernameQuery(
		"select name,password, enabled from user where name=?")
	.authoritiesByUsernameQuery(
		"select name, role from user where name=?");
}

}
	
	
	
	
	
	
	
	
	
	
	

