package com.ngh.jpaauditing.config;

import java.util.Date;
import java.util.Optional;
import java.util.TimeZone;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider") //will enable the Spring Data JPA Auditing features for the application. Jyst for @createddate,@modifieddate
//auditorAwareRef - Configures the {@link AuditorAware} bean to be used to lookup the current principal. Mapping the bean name of AuditorAware
public class AuditConfig {

	@Bean
	public AuditorAware<String> auditorProvider(){ //will take care of @createdby,@modifiedby -> logged in users
		//return ()-> Optional.ofNullable("NGH"); 
	      return ()->Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication().getName());
	}
	
}
