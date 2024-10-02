package org.cg.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Map<String, Object> calculateTaxDeductions(String employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow();
        double yearlySalary = employee.getSalary() * (12 - calculateMonthsUntilNow(employee.getDoj()));
        
        double taxAmount = calculateTax(yearlySalary);
        double cessAmount = (yearlySalary > 2500000) ? (yearlySalary - 2500000) * 0.02 : 0;

        return Map.of(
                "employeeId", employee.getEmployeeId(),
                "firstName", employee.getFirstName(),
                "lastName", employee.getLastName(),
                "yearlySalary", yearlySalary,
                "taxAmount", taxAmount,
                "cessAmount", cessAmount
        );
    }

    private long calculateMonthsUntilNow(LocalDate doj) {
        return ChronoUnit.MONTHS.between(doj, LocalDate.now());
    }

    private double calculateTax(double salary) {
        if (salary <= 250000) return 0;
        else if (salary <= 500000) return (salary - 250000) * 0.05;
        else if (salary <= 1000000) return 12500 + (salary - 500000) * 0.1;
        else return 37500 + (salary - 1000000) * 0.2;
    }
}
