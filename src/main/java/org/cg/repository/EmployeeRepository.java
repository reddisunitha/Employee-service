package org.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employee.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    boolean existsByEmployeeId(String employeeId);
}
