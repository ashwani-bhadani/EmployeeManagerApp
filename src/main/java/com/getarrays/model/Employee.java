package com.getarrays.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;


@Entity
public class Employee implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="empId_generator")
	@SequenceGenerator(name = "empId_generator", initialValue = 41, allocationSize = 3, sequenceName = "empId_seq")
	@Column(nullable = false, updatable = false)
	private Long id;
	
	@Size(min = 5, max = 100, message = "Full Name must be between 10 and 100 characters")
	private String name;
	
	@Column(unique=true)
	@Email(message = "enter valid email !")
	private String email;
	
	
	private String jobTitle;
	
	private String phone; 
	
	@Column(length = 1000)
	private String iamgeUrl;
	
	@Column(nullable = false, updatable = false, unique=true)
	private String employeeCode;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Long id, String name, String email, String jobTitle, String phone, String iamgeUrl,
			String employeeCode) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.jobTitle = jobTitle;
		this.phone = phone;
		this.iamgeUrl = iamgeUrl;
		this.employeeCode = employeeCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIamgeUrl() {
		return iamgeUrl;
	}

	public void setIamgeUrl(String iamgeUrl) {
		this.iamgeUrl = iamgeUrl;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [id=").append(id).append(", name=").append(name).append(", email=").append(email)
				.append(", jobTitle=").append(jobTitle).append(", phone=").append(phone).append(", iamgeUrl=")
				.append(iamgeUrl).append(", employeeCode=").append(employeeCode).append("]");
		return builder.toString();
	}
	
	
}
