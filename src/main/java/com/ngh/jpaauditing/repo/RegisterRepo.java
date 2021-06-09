package com.ngh.jpaauditing.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngh.jpaauditing.entity.Applicants;

@Repository
public interface RegisterRepo extends JpaRepository<Applicants, Integer> {

}
