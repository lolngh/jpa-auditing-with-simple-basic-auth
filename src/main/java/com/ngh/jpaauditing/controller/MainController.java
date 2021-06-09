package com.ngh.jpaauditing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngh.jpaauditing.entity.Applicants;
import com.ngh.jpaauditing.entity.Users;
import com.ngh.jpaauditing.service.UserService;

@RestController
@RequestMapping("/ngh")
public class MainController {

	@Autowired
	UserService service;
	
	@Autowired
	PasswordEncoder encoder;
	
	@PostMapping("/addUser") //while creating user set authorization to - No Auth
	public Users addUser(@RequestBody Users user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return service.save(user);
	}
	
	//for other secured operations set authorization to - Basic Auth
	
	@PostMapping("/addApplicant")
	public Applicants addApplicant(@RequestBody Applicants applicant) {
		return service.registerApplicants(applicant);
	}
	
	@GetMapping("/getApplicants")
	public List<Applicants> getApplicants(){
		return service.listAllApplicants();
	}
	
	@PutMapping("/updateApplicant/{id}")
	public Applicants updateApplicant(@PathVariable int id, @RequestBody Applicants app) {
		return service.updateApplicant(id, app);
	}
	
//	@GetMapping("/logout")
//	public String loggedOut() {
//		return "User logged out";
//	}
}
