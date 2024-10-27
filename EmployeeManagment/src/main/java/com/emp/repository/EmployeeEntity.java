package com.emp.repository;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="EMPLOYEE_DATA")
public class EmployeeEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer employeeId;
	
	private String employeeName;
	
	private String employeeAddress;
	
	private Double employeeSalary;
	 
	private String employeeDesignation;
	
	private String employeeOrganization;
	
	//audit columns
	private String createdBy;
	
	private String updatedBy;  
	
	@CreationTimestamp
	@Column(name="CREATED_DATE", updatable=false)
	private LocalDateTime createdDate;
	
	@UpdateTimestamp
	@Column(name="UPDATED_DATE", insertable=false)
	private LocalDateTime udatedDate;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public Double getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(Double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public String getEmployeeDesignation() {
		return employeeDesignation;
	}

	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}

	public String getEmployeeOrganization() {
		return employeeOrganization;
	}

	public void setEmployeeOrganization(String employeeOrganization) {
		this.employeeOrganization = employeeOrganization;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUdatedDate() {
		return udatedDate;
	}

	public void setUdatedDate(LocalDateTime udatedDate) {
		this.udatedDate = udatedDate;
	}
	
	

}
