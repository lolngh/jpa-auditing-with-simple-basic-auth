package com.ngh.jpaauditing.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Users {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userID;
	
	@Column(unique=true)
	private String name;
	
	private String emailId;
	
//	@JsonIgnore
	private String password;
	
}
