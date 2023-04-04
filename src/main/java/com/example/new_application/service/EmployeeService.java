package com.example.new_application.service;

import com.example.new_application.entity.Employee;
import com.example.new_application.exception.CustomException;
import com.example.new_application.pojo.EmpAddressResponse;
import com.example.new_application.pojo.EmployeeResponse;
import com.example.new_application.pojo.ProjectResponse;
import com.example.new_application.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepo repo;

	public List<EmployeeResponse> getAllEmployee() {
		List<Employee> employees = repo.findAll();
		// for(Employee emp : employees)
		List<EmployeeResponse> resp = new ArrayList<>();
		employees.stream().forEach(a -> {
			EmployeeResponse employeeRepo = new EmployeeResponse();

			employeeRepo.setFirst_name(a.getFirst_name());
			employeeRepo.setLast_name(a.getLast_name());
			employeeRepo.setEmail(a.getEmail());

			EmpAddressResponse address = new EmpAddressResponse();

			address.setAddress(a.getAddress().getAddress());
			address.setPincode(a.getAddress().getPincode());
			employeeRepo.setAddress(address);

//			ProjectResponse response = new ProjectResponse();
//			
//			List<ProjectResponse> emp = new ArrayList<>();
//			a.getProjects().stream().forEach(pr ->{
//				response.setProject_id(pr.getProject_id());
//				response.setProject_name(pr.getProject_name());
//				response.setProject_description(pr.getDescription());
//				emp.add(response);
//				
//				// logger 
//				System.out.println(response.toString());
//			});
			// one to many
			employeeRepo.setProjects(a.getProjects());
			// many to one
			employeeRepo.setProject(a.getProject());

			// ManyToMany
			employeeRepo.setProjectSet(a.getProjectSet());
			resp.add(employeeRepo);
		});

		// employeeRepo.setFirst_name();
		return resp;
	}

	public Employee findById(Long emp_id) throws CustomException {

		Employee employee = repo.findById(emp_id)
				.orElseThrow(() -> new CustomException("Employee Not found : " + emp_id));
		return employee;
	}

	public Employee findByName(String first_name) {
		Employee employee = repo.getEmpByName(first_name);
		return employee;
	}

//	public Employee getByLastName(String last_name) {
//		Employee byLastName = repo.getByLastName(last_name);
//		return byLastName;
//	}
//
//	{
//
//	}

	public Boolean save_employee(Employee employee) {
		return repo.save(employee).equals(true);
	}

	public Employee save_employee1(Employee employee) {
		Employee employee1 = repo.save(employee);
		return employee1;
	}

	public String update(Employee employee, Long id) throws CustomException {
		Employee employee1 = findById(id);
		employee1.setFirst_name(employee.getFirst_name());
		employee1.setLast_name(employee.getLast_name());
		employee1.setEmail(employee.getEmail());

		Employee updated_employee = save_employee1(employee1);
		return "Update Successfully";
	}

	public void deleteEmployee(Employee employee) {
		repo.delete(employee);
	}

	public void deleteAllEmp() {
		repo.deleteAll();
	}
}
