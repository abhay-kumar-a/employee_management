package com.example.new_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.new_application.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
	
	@Query(value="select e from Employee  as e where email =:email")
	Employee getEmpByName(@Param("email") String email);
	
	//Employee getByLastName(String last_name);
	
}

 