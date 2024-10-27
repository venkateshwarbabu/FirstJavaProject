package com.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.binding.EmployeeRequest;
import com.emp.binding.EmployeeResponse;
import com.emp.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	public ResponseEntity<String> saveNewEmployeeData(@RequestBody EmployeeRequest employeeRequest) {

		// @RequestBody is take the request from body in postman

		Boolean result = employeeService.saveEmployeeData(employeeRequest);
		if (result == true) {
			return new ResponseEntity<String>("Data Inserted Successsfully", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Data not inserted", HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/id/{employeeId}")
	public ResponseEntity<EmployeeResponse> getDataFromDataById(@PathVariable Integer employeeId) {
		EmployeeResponse response = employeeService.getEmployeeDataById(employeeId);
		if (response != null) {
			return new ResponseEntity<EmployeeResponse>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<EmployeeResponse>(response, HttpStatus.BAD_REQUEST);

		}

	}

	@GetMapping("/name/{Name}")
	public ResponseEntity<List<EmployeeResponse>> getEmployeeDataByname(@PathVariable String Name) {
		List<EmployeeResponse> response = employeeService.getEmployeeDataByName(Name);
		if (response != null) {
			return new ResponseEntity<List<EmployeeResponse>>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<EmployeeResponse>>(response, HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/address/{employeeAddress}")
	public ResponseEntity<List<EmployeeResponse>> getEmployeeDataByAddress(@PathVariable String employeeAddress) {
		List<EmployeeResponse> response = employeeService.getEmployeeDataByAddress(employeeAddress);
		if (response != null) {
			return new ResponseEntity<List<EmployeeResponse>>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<EmployeeResponse>>(response, HttpStatus.BAD_REQUEST);
		}

	}
	
	@GetMapping("/allEmployees")
	public ResponseEntity<List<EmployeeResponse>> getAllEmployees(){
		List<EmployeeResponse> response=employeeService.getAllEmployees();
		if(response != null) {
			return new ResponseEntity<List<EmployeeResponse>>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<EmployeeResponse>>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<EmployeeResponse> updateEmployeeData(@RequestBody EmployeeRequest employeeRequest,@PathVariable Integer id) {
		EmployeeResponse response = employeeService.updateEmployeeData(employeeRequest, id);
		if (response != null) {
			return new ResponseEntity<EmployeeResponse>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<EmployeeResponse>(response, HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployeeDataFromDatabase(@PathVariable Integer id) {
		boolean result = employeeService.deleteEmloyeData(id);
		if (result == true) {
			return new ResponseEntity<String>("data deleted successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("data not deleted", HttpStatus.BAD_REQUEST);
		}
	}

}
