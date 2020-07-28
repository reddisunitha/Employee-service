package org.cg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Department")
public class Department {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="department_id", updatable = false)
 private int departmentId;
 private String departmentName;
 private String location;
 
public Department() {
	super();
}
public Department(int departmentId, String departmentName, String location) {
	super();
	this.departmentId = departmentId;
	this.departmentName = departmentName;
	this.location = location;
}
@Override
public String toString() {
	return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", location=" + location
			+ "]";
}
public int getDepartmentId() {
	return departmentId;
}
public void setDepartmentId(int departmentId) {
	this.departmentId = departmentId;
}
public String getDepartmentName() {
	return departmentName;
}
public void setDepartmentName(String departmentName) {
	this.departmentName = departmentName;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
 
}
