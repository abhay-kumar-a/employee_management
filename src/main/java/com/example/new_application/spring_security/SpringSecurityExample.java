package com.example.new_application.spring_security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration
public class SpringSecurityExample extends WebSecurityConfigurerAdapter {

	// User Authentication
		@Bean
		@Override
		protected UserDetailsService userDetailsService() {

			List<UserDetails> users = new ArrayList<>();
			users.add(User.withDefaultPasswordEncoder().username("abhay")
					.password("abhay123").roles("USER").build());
			users.add(User.withDefaultPasswordEncoder().username("praneet").password("babu")
					.roles("USER1").build());
			return new InMemoryUserDetailsManager(users);
		}

		// Authorization
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
					.csrf().disable()
					.authorizeRequests()
					.antMatchers("/auth/**")
					.access("hasRole('ROLE_USER')")
					.and()
					.httpBasic();

			http
					.csrf().disable()
					.authorizeRequests()
					.antMatchers("/h/**")
					.access("hasRole('ROLE_USER1')")
					.and()
					.httpBasic();


		}
}
