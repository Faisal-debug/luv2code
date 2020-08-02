package com.luv2code.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luv2code.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	//add amethod to sort by last name
	public List<Employee> findAllByOrderByLastNameAsc();
	
	//search by name
	public List<Employee> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String name,String lName);

}
