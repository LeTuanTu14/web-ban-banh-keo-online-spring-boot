package com.se.iuh.web_candy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/registration/**","/css/*.css", "/js/*.js", "/img/**","/fonts/**","/sass/**").permitAll()
			.antMatchers("/shop")
			.permitAll()
			.antMatchers("/home")
			.permitAll()
			.antMatchers("/contact")
			.permitAll()
			.antMatchers("/giohang/**")
			.permitAll()
			.antMatchers("/api/**")
			.permitAll()
			.antMatchers("/dathang")
			.hasAnyAuthority("USER","ADMIN")
			.antMatchers("/admin/**")
			.hasAuthority("ADMIN")
			.anyRequest()
			.authenticated()
			.and()
			.formLogin()
            .loginPage("/login")
            .permitAll()
            .and().exceptionHandling().accessDeniedPage("/403")
			.and().logout().permitAll();
	}
}
