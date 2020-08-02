package com.luv2code.service;

import com.luv2code.repository.EmployeeRepository;
import com.luv2code.entity.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepo;
	
	public void addEmployee(Employee emp)
	{
		empRepo.save(emp);
	}
	
	public List<Employee> findAll(){
		return empRepo.findAllByOrderByLastNameAsc();
	}
 
	public Employee findbyId(int id) {
		Optional<Employee>result=empRepo.findById(id);
		Employee theEmployee=null;
		
		if(result.isPresent())
		{
			theEmployee=result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + id);
		}
		return theEmployee;
	}
	
	public void deleteById(int theId) {
		empRepo.deleteById(theId);
	}

		public List<Employee> searchBy(String theName){
			
			List<Employee> results=null;
			if(theName!=null &&(theName.trim().length()>0))
			{
				results=empRepo.findByFirstNameContainsOrLastNameContainsAllIgnoreCase(theName, theName);
			}
			else {
				results=findAll();
			}
			return results;
		}
		
	}

