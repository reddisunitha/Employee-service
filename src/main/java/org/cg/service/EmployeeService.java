package org.cg.service;

import java.util.List;
import java.util.Optional;

import org.cg.model.Address;
import org.cg.model.Employee;
import org.cg.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> findAll() {
		List<Employee> emps = (List<Employee>) employeeRepository.findAll();
		return emps;
	}
	public Employee getEmployee(long id){
		return employeeRepository.findOne(id);
	}
	public void addEmployee(Employee e) {
		for(Address address : e.getAddress()) {
			address.setEmployee(e);
		}
		employeeRepository.save(e);
	}
	public void updateEmployee(Employee emp, int id){
		if(id == emp.getEmployeeId()) {
			employeeRepository.save(emp);
		}
	}
	public void deleteAllEmployees(){
		employeeRepository.deleteAll();
	}
	public void deleteEmployeeByID(long id){
		employeeRepository.deleteById(id);
	}
	public void patchEmployee(Employee emp, int id) {
		if(id == emp.getEmployeeId()) {
			employeeRepository.save(emp);
		}
	}
	
}