package com.example.new_application.controller;

import com.CrudBoot.CrudBoot.Entity.Customer;
import com.example.new_application.entity.Employee;
import com.example.new_application.exception.CustomException;
import com.example.new_application.pojo.EmployeeResponse;
import com.example.new_application.pojo.PracticePojo;
import com.example.new_application.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class EmployeeController {
	@Autowired
	
	EmployeeService service;

	@GetMapping("/employee")
	public List<EmployeeResponse> employee() {
		List<EmployeeResponse> employeeList = service.getAllEmployee();
		return employeeList;
	}

	@GetMapping("/employee/{emp_id}")
	public Employee getEmployeeByID(@PathVariable("emp_id") Long emp_id) throws CustomException {
		Employee employee = service.findById(emp_id);
		return employee;
	}

	@GetMapping("/name/{first_name}")
	public Employee getByName(@PathVariable String first_name) {
		Employee findByName = service.findByName(first_name);
		return findByName;
	}
//	@GetMapping("/name/{last_name}")
//	public Employee getNameEmployee(@PathVariable String last_name)
//	{
//		Employee byLastName = service.getByLastName(last_name);
//		
//		return byLastName;
//	}

	@PostMapping("/save")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) {
		Employee employee1 = service.save_employee1(employee);
		return ResponseEntity.ok().body("successfully saved");
	}

	@PutMapping("/update/{emp_id}")
	public ResponseEntity<String> update(@RequestBody Employee employee, @PathVariable("emp_id") Long emp_id)
			throws CustomException {
		String message = service.update(employee, emp_id);
		return ResponseEntity.ok().body(message);
	}

	@DeleteMapping("/delete/{emp_id}")
	ResponseEntity<String> delete(@PathVariable("emp_id") Long emp_id) throws CustomException {
		Employee employee = service.findById(emp_id);
		service.deleteEmployee(employee);
		return ResponseEntity.ok().body("Successfully deleted...");
	}

	@DeleteMapping("/deleteAll")
	public ResponseEntity<String> deleteAllEmployee() {
		service.deleteAllEmp();
		return ResponseEntity.ok().body("Successfully deleted...");
	}
	
	/// use of restTemplate
	
//	ResponseEntity<DepartmentDto> responseEntity = restTemplate
//            .getForEntity("http://localhost:8080/api/departments/" + user.getDepartmentId(),
//            DepartmentDto.class);
	
	@Autowired
	RestTemplate restTemplate;
	@GetMapping("/map")
	PracticePojo  getData()
	{
		ResponseEntity<PracticePojo> responseEntity = restTemplate.getForEntity("http://localhost:8080/pra", PracticePojo.class);
	PracticePojo  p = responseEntity.getBody();
		return p;
}
}
