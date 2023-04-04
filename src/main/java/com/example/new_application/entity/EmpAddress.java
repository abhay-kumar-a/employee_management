package com.example.new_application.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class EmpAddress {

	@Id
	Long add_id;
	String Address;
	Integer pincode;
	@JsonIgnore
	@OneToOne(mappedBy = "address")
	Employee employee;
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Long getAdd_id() {
		return add_id;
	}
	public void setAdd_id(Long add_id) {
		this.add_id = add_id;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "EmpAddress [Address=" + Address + ", pincode=" + pincode + "]";
	}
	
	
	
}
	
	
