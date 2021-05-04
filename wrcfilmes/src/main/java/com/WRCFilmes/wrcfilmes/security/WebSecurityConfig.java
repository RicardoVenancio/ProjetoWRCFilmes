package com.WRCFilmes.wrcfilmes.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private ImplementsUserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{

		http.csrf().disable().authorizeRequests()
		.antMatchers(HttpMethod.GET, "/").permitAll()
		.antMatchers(HttpMethod.GET, "/pessoas/listar").hasRole("ADMIN")
		.antMatchers(HttpMethod.POST, "/pessoas/listar").hasRole("ADMIN")
		.antMatchers("/h2-console/**").permitAll()
		.anyRequest().authenticated()
		.and().formLogin().permitAll()
		.and().headers().frameOptions().sameOrigin()
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		http.csrf().disable(); //liberar acesso ao H2
		http.headers().frameOptions().disable(); //liberar acesso ao H2
	}
	
	        
	 @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService)
	        .passwordEncoder(new BCryptPasswordEncoder());
	  }

	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/materialize/**", "/style/**");
	}
}
