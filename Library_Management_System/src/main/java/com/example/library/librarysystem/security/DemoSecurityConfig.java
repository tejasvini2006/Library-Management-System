package com.example.library.librarysystem.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

	// add support for JDBC ... no more hardcoded users :-)

	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {

		return new JdbcUserDetailsManager(dataSource);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(configurer -> 
		configurer
				
				
				//for student
				.requestMatchers(HttpMethod.GET, "/students").hasAnyRole("STUDENT","HEAD","ADMIN")
				.requestMatchers(HttpMethod.GET, "/students/search/{id}").hasAnyRole("STUDENT","ADMIN","HEAD")
				.requestMatchers(HttpMethod.POST,"/students/add").hasAnyRole("STUDENT")
				.requestMatchers(HttpMethod.PUT, "/students/update").hasAnyRole("STUDENT")
				.requestMatchers(HttpMethod.DELETE,"/students/delete/{id}").hasAnyRole("STUDENT")
				
				
				//for books
				.requestMatchers(HttpMethod.GET, "/books").hasAnyRole("STUDENT","HEAD","ADMIN")
				.requestMatchers(HttpMethod.GET,"/books/search/{id}").hasAnyRole("STUDENT","HEAD","ADMIN")
				.requestMatchers(HttpMethod.POST,"/books/add").hasAnyRole("STUDENT")
				.requestMatchers(HttpMethod.PUT, "/books/update").hasAnyRole("HEAD","ADMIN")
				.requestMatchers(HttpMethod.DELETE,"/books/delete/{id}").hasAnyRole("HEAD","ADMIN")
				
				
				
				//for transactions
				.requestMatchers(HttpMethod.GET, "/transactions").hasAnyRole("HEAD")
				.requestMatchers(HttpMethod.POST,"/transactions/**").hasAnyRole("HEAD")
				.requestMatchers(HttpMethod.PUT, "/transactions/**").hasAnyRole("HEAD")
				.requestMatchers(HttpMethod.DELETE,"/transactions/**").hasAnyRole("HEAD")
				
							
				
				);
		
		
		

		// use HTTP Basic authentication
		http.httpBasic(Customizer.withDefaults());

		// disable Cross Site Request Forgery (CSRF)
		// in general, not required for stateless REST APIs that use POST, PUT, DELETE
		// and/or PATCH
		 http.csrf(csrf -> csrf.disable());

		return http.build();
	}
}