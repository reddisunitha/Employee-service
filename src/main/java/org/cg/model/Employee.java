package org.cg.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="Employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long employeeId;
	private String firstName;
	private String lastName;
	private double salary;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date DateOfJoining;
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "deptartment_id")
	private Department department;
	@OneToMany(mappedBy = "Employee", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Address> address;
	
	public Employee() {
		super();
	}
	public Employee(long employeeId, String firstName, String lastName, double salary, Date dateOfJoining,
			Department department, Address address) {
		super();
		this.employeeId =employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		DateOfJoining = dateOfJoining;
		this.department = department;
		this.address = (List<Address>) address;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", salary=" + salary + ", DateOfJoining=" + DateOfJoining + ", department=" + department
				+ ", address=" + address + "]";
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Date getDateOfJoining() {
		return DateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		DateOfJoining = dateOfJoining;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Address getAddress() {
		return (Address) address;
	}
	public void setAddress(Address address) {
		this.address = (List<Address>) address;
	}
	

}
