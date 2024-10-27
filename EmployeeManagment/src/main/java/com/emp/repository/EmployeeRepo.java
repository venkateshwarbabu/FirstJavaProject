package com.emp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



public interface EmployeeRepo extends JpaRepository<EmployeeEntity,Integer> {
	
	public List<EmployeeEntity> findByEmployeeName(String employeeName);
	public List<EmployeeEntity> findByEmployeeAddress(String employeeAddress);

}
