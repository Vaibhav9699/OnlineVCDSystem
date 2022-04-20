package com.vcd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Created table directly in the database
@Entity
@Table(name="Users_details")
public class User {
  
	//Set the Id as a primary key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name="id")
	private int id;
	@Column(name="Requirement_id")
	private String requirementId;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="Priority")
	private String priority;

	public String getRequirementId() {
		return requirementId;
	}

	public void setRequirementId(String requirementId) {
		this.requirementId = requirementId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public User(int id,String requirementId, String description, String priority) {
		super();
		this.requirementId = requirementId;
		this.description = description;
		this.priority = priority;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	//Default Constructor to address the class
	
}

