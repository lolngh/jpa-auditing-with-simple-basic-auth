package com.ngh.jpaauditing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngh.jpaauditing.entity.Applicants;
import com.ngh.jpaauditing.entity.Users;
import com.ngh.jpaauditing.repo.RegisterRepo;
import com.ngh.jpaauditing.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepo repo;
	
	@Autowired
	RegisterRepo applicantRepo;
	
	@Override
	public Users save(Users user) {
		return repo.save(user);
	}

	@Override
	public List<Users> getUsers() {
		return repo.findAll();
	}

	@Override
	public Applicants registerApplicants(Applicants applicant) {
		return applicantRepo.save(applicant);
	}

	@Override
	public List<Applicants> listAllApplicants() {
		return applicantRepo.findAll();
	}

	@Override
	public Applicants updateApplicant(int id, Applicants app) {
		Applicants applicant = applicantRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("Id not found"));
		applicant.setAddress(app.getAddress());
		return applicantRepo.save(applicant);
	}

}
