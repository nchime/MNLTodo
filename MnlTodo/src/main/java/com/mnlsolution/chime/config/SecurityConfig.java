package com.mnlsolution.chime.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.mnlsolution.chime.handler.CustomerAuthenticationFailureHandler;
import com.mnlsolution.chime.handler.CustomerAuthenticationSuccessHandler;
import com.mnlsolution.chime.handler.CustomerLogoutSuccessHandler;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	CustomerAuthenticationFailureHandler authenticationFailureHandler;
	
	@Autowired
	CustomerAuthenticationSuccessHandler successHandler;
	
	@Autowired
	CustomerLogoutSuccessHandler logoutSuccessHandler; 
	
	
	@Autowired
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication().withUser("chime").password("1234").roles("ADMIN")
		.and().withUser("test").password("1234").roles("USER");
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.authorizeRequests()
				.antMatchers("/main/**").hasRole("ADMIN")
				.antMatchers("/**").permitAll()
				.and()
			.formLogin()
				.loginPage("/login")
//				.defaultSuccessUrl("/main/todolist")
//				.failureUrl("/login?error")
				.usernameParameter("loginid")
				.passwordParameter("password")
				.successHandler(successHandler)
				.failureHandler(authenticationFailureHandler)
				.permitAll()
				.and()
			.logout()
				.logoutUrl("/logout")
				.logoutSuccessHandler(logoutSuccessHandler)
//				.logoutSuccessUrl("/login")
				.invalidateHttpSession(true);    
		
	}
	
	
	@Bean
	CustomerAuthenticationFailureHandler authenticationHandler() {
	    return new CustomerAuthenticationFailureHandler();
	}

	@Bean
	CustomerAuthenticationSuccessHandler successHandler() {
	    return new CustomerAuthenticationSuccessHandler();
	}

	@Bean
	CustomerLogoutSuccessHandler logoutSuccessHandler() {
	    return new CustomerLogoutSuccessHandler();
	}


}
