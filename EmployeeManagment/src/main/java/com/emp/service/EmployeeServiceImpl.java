package com.emp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.binding.EmployeeRequest;
import com.emp.binding.EmployeeResponse;
import com.emp.repository.EmployeeEntity;
import com.emp.repository.EmployeeRepo;

@Service // object will be created automatically after giving this annotation.
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public boolean saveEmployeeData(EmployeeRequest employeeRequest) {
		if (employeeRequest != null) { // checks weather the employee request is null r not
			EmployeeEntity entity = new EmployeeEntity(); // create object for the employee entity class
			BeanUtils.copyProperties(employeeRequest, entity); // take the employee request(data from postman) to store
																// that into employee entity using this method
			EmployeeEntity entityResnseData = employeeRepo.save(entity); // save that data as entity in db using save();
			if (entityResnseData != null) { // after converts checks the entity is null or not
				return true;
			}
		}
		return false;
	}

	@Override
	public EmployeeResponse getEmployeeDataById(Integer employeeId) {
		Optional<EmployeeEntity> optionalEntity = employeeRepo.findById(employeeId); // we get the employee entity based
																						// on id., and that entity
																						// stores in (OPTIONAL CLASS)
		EmployeeResponse employeeResponse = new EmployeeResponse(); // we not directly send it to the user so we create
																	// the response object

		if (optionalEntity.isPresent()) { // checks optional class contains any data
			EmployeeEntity employeeEntity = optionalEntity.get(); // if contains we'llget the data to call .get() method
																	// and store it in the employee entity object

			BeanUtils.copyProperties(employeeEntity, employeeResponse); // there is no way to send direct entity to the
																		// user so we have to convert that into any
																		// format using this[
																		// beanUtils.copyProperties()] method.
		}
		return employeeResponse; // after copy the entity object as entity response we will return to it
	}

	@Override
	public List<EmployeeResponse> getEmployeeDataByName(String employeeName) {
		List<EmployeeEntity> listOfEmployeeEntities = employeeRepo.findByEmployeeName(employeeName); // we create the
																										// method and
																										// call here
		EmployeeResponse Response = new EmployeeResponse(); // response entity object

		List<EmployeeResponse> listOfEmployeeResponses = new ArrayList<>(); // create list of entity response object
																			// with arraylist() object
		for (EmployeeEntity entity : listOfEmployeeEntities) { // iterate the list of employee entities
			BeanUtils.copyProperties(entity, Response); // convert them into the response object using
														// beanutils.copyproperties() because can't access the entity
														// directly we need to convert them into the response
			listOfEmployeeResponses.add(Response); // store the response object data into the list of response entities

		}
		return listOfEmployeeResponses;
	}

	@Override
	public List<EmployeeResponse> getEmployeeDataByAddress(String employeeAddress) {
		List<EmployeeEntity> listOfAddress = employeeRepo.findByEmployeeAddress(employeeAddress);

		List<EmployeeResponse> listOfEmployeeResponses = new ArrayList<>();
		for (EmployeeEntity entity : listOfAddress) {
			EmployeeResponse response = new EmployeeResponse();

			BeanUtils.copyProperties(entity, response);
			listOfEmployeeResponses.add(response);
		}
		return listOfEmployeeResponses;
	}
	
	@Override
	public List<EmployeeResponse> getAllEmployees(){
		List<EmployeeEntity> listOfEntites = employeeRepo.findAll();
		
		List<EmployeeResponse> listOfEmployeeResponses = new ArrayList<>();
		for(EmployeeEntity entity: listOfEntites) {
			EmployeeResponse response=new EmployeeResponse();
			
			BeanUtils.copyProperties(entity, response);
			listOfEmployeeResponses.add(response);
		}
		return listOfEmployeeResponses;
		
	}

	@Override
	public EmployeeResponse updateEmployeeData(EmployeeRequest employeeRequest, Integer employeeId) { 
																								
																				
		Optional<EmployeeEntity> optional = employeeRepo.findById(employeeId);

		EmployeeResponse response = new EmployeeResponse();
		if (optional.isPresent()) {
			EmployeeEntity employeeEntity = optional.get();
			if (employeeRequest.getEmployeeName() != null) {
				employeeEntity.setEmployeeName(employeeRequest.getEmployeeName());
			}
			if (employeeRequest.getEmployeeAddress() != null) {
				employeeEntity.setEmployeeAddress(employeeRequest.getEmployeeAddress());
			}
			if (employeeRequest.getEmployeeOrganization() != null) {
				employeeEntity.setEmployeeOrganization(employeeRequest.getEmployeeOrganization());
			}
			if (employeeRequest.getEmployeeSalary() != null) {
				employeeEntity.setEmployeeSalary(employeeRequest.getEmployeeSalary());
			}
			if (employeeRequest.getEmployeeDesignation() != null) {
				employeeEntity.setEmployeeDesignation(employeeRequest.getEmployeeDesignation());
			}
			EmployeeEntity entity = employeeRepo.save(employeeEntity);
			BeanUtils.copyProperties(entity, response);
		}
		return response;
	}

	@Override
	public boolean deleteEmloyeData(Integer employeeId) {
		Optional<EmployeeEntity> optional = employeeRepo.findById(employeeId);
		if (optional.isPresent()) {

			employeeRepo.deleteById(employeeId);
			return true;
		}

		return false;
	}

}
