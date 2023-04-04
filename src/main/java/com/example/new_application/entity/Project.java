package com.example.new_application.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Project {
@Id
Long project_id;	
String project_name;
String description ;

@JsonIgnore
@OneToMany(cascade = CascadeType.ALL , mappedBy = "project")
List<Employee> employeeList;

@JsonIgnore
@ManyToMany(cascade = CascadeType.ALL ,  mappedBy = "projectSet")
Set<Employee> employeeSet;

public Set<Employee> getEmployeeSet() {
	return employeeSet;
}
public void setEmployeeSet(Set<Employee> employeeSet) {
	this.employeeSet = employeeSet;
}
public List<Employee> getEmployeeList() {
	return employeeList;
}
public void setEmployeeList(List<Employee> employeeList) {
	this.employeeList = employeeList;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Long getProject_id() {
	return project_id;
}
public void setProject_id(Long project_id) {
	this.project_id = project_id;
}
public String getProject_name() {
	return project_name;
}
public void setProject_name(String project_name) {
	this.project_name = project_name;
}

}
