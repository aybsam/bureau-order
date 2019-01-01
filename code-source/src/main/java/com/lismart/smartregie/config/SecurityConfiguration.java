package com.lismart.smartregie.config;

import com.lismart.smartregie.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().httpBasic().and().authorizeRequests().antMatchers("/javax.faces.resource/**").permitAll()
				.antMatchers("/resources/images/logo.jpg").permitAll()
				.antMatchers("/users/**", "/config**", "/taxes/**", "/tarifs/**", "/penalites/**").hasRole("ADMIN")
				.antMatchers("/h2-console/**").permitAll()
				.anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll()
				.failureUrl("/login?error=true").defaultSuccessUrl("/courriers/list.xhtml", true).and()
				.logout().deleteCookies("JSESSIONID").logoutSuccessUrl("/login").and().rememberMe()
				.key("uniqueAndSecret").rememberMeParameter("remember-me_input").userDetailsService(userDetailsService);

		// h2-console
		http.headers().frameOptions().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(authenticationProvider());
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
