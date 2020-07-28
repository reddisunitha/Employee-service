package org.cg.controller;

import java.util.List;

import org.cg.model.Employee;
import org.cg.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployee(){
		return  (employeeService).getAllEmployees();
	}

	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable int id){
		return employeeService.getEmployee(id);
	}
	
	@PostMapping("/employees")
	public String addEmployees(@RequestBody Employee employee){
		
		System.out.println(employee.getAddress());
		
		employeeService.addEmployee(employee);
		
		return "Employee Saved to Database";
	}

	@PutMapping("/employees/{id}")
	public String updateEmployee(@RequestBody Employee e, @PathVariable int id){
		employeeService.updateEmployee(e, id);
		return "Employee has been updated";
	}
	
	@DeleteMapping("/employees")
	public String deleteAllEmployees(){
		employeeService.deleteAllEmployees();
		return "All employee records deleted";
	}

	@DeleteMapping("employees/{id}")
	public String deleteEmployeeByID(@RequestBody Employee e, @PathVariable long id){
		employeeService.deleteEmployeeByID(id);
		return "Employee of id "+e.getEmployeeId()+" deleted";
	}

	@PatchMapping("employees/{id}")
	public String patchEmployeeByID(@RequestBody Employee e, @PathVariable int id) {
		employeeService.patchEmployee(e, id);
		return "Patch update successful";
	}
}
