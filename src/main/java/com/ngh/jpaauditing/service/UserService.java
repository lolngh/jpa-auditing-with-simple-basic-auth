package com.ngh.jpaauditing.service;

import java.util.List;

import com.ngh.jpaauditing.entity.Applicants;
import com.ngh.jpaauditing.entity.Users;

public interface UserService {
	
	public Users save(Users user);
	public List<Users> getUsers();
	public Applicants registerApplicants(Applicants applicant);
	public List<Applicants> listAllApplicants();
    public Applicants updateApplicant(int id,Applicants app);
	
}
