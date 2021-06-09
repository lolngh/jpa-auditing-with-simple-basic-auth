package com.ngh.jpaauditing.entity;

import java.sql.Timestamp;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@MappedSuperclass //similar to embeddable mapping to entities which extend them except tht it maps to particular entity class.
@EntityListeners(AuditingEntityListener.class)//JPA entity listener class, consists of callbcak methods-prepersist, preupdate. listens for event of entities
public class AuditData<U> {  //U is taken as String in entities
	
	 @CreatedDate
	  private Timestamp createdDate;

	  @LastModifiedDate
	  private Timestamp modifiedDate;

	  @CreatedBy
	  private U createdBy;

	  @LastModifiedBy
	  private U modifiedBy;
}
