package com.example.new_application.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
//@Table(uniqueConstraints= {@UniqueConstraint(columnNames = {"first_name"})})
public class Employee {
    @Id
    Long id;
    String first_name;
    String last_name;
    String email;
    
    @OneToOne(cascade =CascadeType.ALL  , fetch = FetchType.EAGER)
    @JoinColumn(name="address" , referencedColumnName = "add_id")
    EmpAddress address;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_fk" , referencedColumnName = "id", nullable = true)
    List<Project> projects;
   
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="project_fk" , referencedColumnName = "project_id", nullable = true)
    Project project;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_project" ,joinColumns  = @JoinColumn(name="id") , inverseJoinColumns = @JoinColumn(name="project_id"))
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

	public EmpAddress getAddress() {
		return address;
	}

	public void setAddress(EmpAddress address) {
		this.address = address;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

	@Override
	public String toString() {
		return "Employee [first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", address=" + address + "]";
	}

    
}
