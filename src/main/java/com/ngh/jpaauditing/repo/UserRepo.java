package com.ngh.jpaauditing.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngh.jpaauditing.entity.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {

	Users findByName(String name);
}
