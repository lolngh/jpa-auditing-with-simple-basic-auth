package com.ngh.jpaauditing.service;

import org.springframework.stereotype.Service;

import com.ngh.jpaauditing.entity.DomainUserDetails;
import com.ngh.jpaauditing.entity.Users;
import com.ngh.jpaauditing.repo.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class DomainUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userRepo.findByName(username);
		return new DomainUserDetails(user);
	}
}
