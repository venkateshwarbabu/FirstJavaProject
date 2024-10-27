package com.emp.service;

import java.util.List;

import com.emp.binding.EmployeeRequest;
import com.emp.binding.EmployeeResponse;


public interface EmployeeService {
	//employeeRequest and employeeResponse classes have same fields as employeEntity class
	//take all request from request class and gave response to the response class
	//so instead of using entity class fields we use request and response class fields to performs jpa operations
	//from user through apis we implements different methods on data.
	//request and response between these 2 clases we hve entity class to convert binding clases to entity class we use
	//BeanUtils.copyProperties()-method..
	public boolean saveEmployeeData(EmployeeRequest employeeRequest);
	
	public EmployeeResponse getEmployeeDataById(Integer employeeId); //we give one id in result we'll get employee data
	
	public List<EmployeeResponse> getEmployeeDataByName(String employeeName);

	public List<EmployeeResponse> getAllEmployees();
	
	public List<EmployeeResponse> getEmployeeDataByAddress(String employeeAddress);
	
	public EmployeeResponse updateEmployeeData(EmployeeRequest employeeRequest,Integer employeeId);
	
	public boolean deleteEmloyeData(Integer employeeId);
}
