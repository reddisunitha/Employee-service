package org.cg.controller;
import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> storeEmployee(@Valid @RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping("/{employeeId}/tax-deductions")
    public ResponseEntity<Map<String, Object>> getTaxDeductions(@PathVariable String employeeId) {
        return ResponseEntity.ok(employeeService.calculateTaxDeductions(employeeId));
    }
}
