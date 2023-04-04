package com.example.new_application.pojo;

import java.util.List;
import java.util.Set;

import com.example.new_application.entity.Project;

public class EmployeeResponse {

	String first_name ;
	String last_name ;
	String email;
	EmpAddressResponse address;
	
	List<Project> projects;
	
	Project project;
	
	Set<Project> projectSet;
	
	public Set<Project> getProjectSet() {
		return projectSet;
	}
	public void setProjectSet(Set<Project> projectSet) {
		this.projectSet = projectSet;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	public EmpAddressResponse getAddress() {
		return address;
	}
	public void setAddress(EmpAddressResponse address) {
		this.address = address;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
