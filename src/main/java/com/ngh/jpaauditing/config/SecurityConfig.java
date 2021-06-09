package com.ngh.jpaauditing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ngh.jpaauditing.service.DomainUserDetailsService;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import org.springframework.beans.factory.annotation.Autowired;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	 @Autowired
	    private DomainUserDetailsService userDetailsService;


	  @Override
	    protected void configure(HttpSecurity httpSecurity) throws Exception {
	        httpSecurity.cors().and().csrf().disable()
	                .authorizeRequests()
	                .antMatchers("/ngh/addUser").permitAll()
	                .anyRequest().authenticated().and()
//	                .formLogin()      //basic form page in browser to login
//                    .and()
	                .httpBasic().and() //login popup appears,enabled for postman support
//	                .logout().logoutUrl("/logout").and()
	                .sessionManagement().sessionCreationPolicy(STATELESS);
	    }

	    @Override
	    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
	        //configure users
	        authenticationManagerBuilder
	                .userDetailsService(this.userDetailsService)
	                .passwordEncoder(bcryptPasswordEncoder());
	    }

	    @Bean
	    public PasswordEncoder bcryptPasswordEncoder(){
	        return new BCryptPasswordEncoder();
	    }

}
