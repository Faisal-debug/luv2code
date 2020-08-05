package com.luv2code.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.entity.Employee;
import com.luv2code.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	
	
		//add mapping for /list
		@GetMapping("/list")
		public String listEmployees(Model theModel)
		{
			//get employee from database
			List<Employee> theEmployees=empService.findAll();
		//add the spring model
		theModel.addAttribute("employees",theEmployees);
		System.out.print("For testing Jenkins");
		System.out.print("For testing Jenkins2");
		return "employees/list-employees";
		}
		
		@GetMapping("/showFormForAdd")
		public String showFormForAdd(Model theModel) {
			
			//create model attribute to bind form data
			Employee theEmployee= new Employee();
			theModel.addAttribute("employee",theEmployee);
			 
			
			return "employees/employee-form";
			
		}
		
		
		@GetMapping("/showFormForUpdate")
		public String showFormForUpdate(@RequestParam("employeeId") int theId,Model theModel) {
			//get the employee from the service
			Employee theEmployee=empService.findbyId(theId);
			
			//set employee as a model attribute to pre-populate the form
			theModel.addAttribute("employee",theEmployee);
			
          
			//send over to our form
			return "employees/employee-form";
		}
		
		
		@PostMapping("/save")
		public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
			//save the employee
			empService.addEmployee(theEmployee);
			
			//use a redirect to prevent duplicate submission
			return "redirect:/employees/list";
		}
		
		@GetMapping("/delete")
		public String delete(@RequestParam("employeeId") int theId) {
			
			//delete the employee
			empService.deleteById(theId);
			
			//redirect to /employees/list
			return "redirect:/employees/list";
		}

		@GetMapping("/search")
		public String delete(@RequestParam("employeeName")String theName,Model theModel) {
			
			//delete the employee
			List<Employee> theEmployee=empService.searchBy(theName);
			
			//add to the spring model
			theModel.addAttribute("employee",theEmployee);
			
			//send to /employees/list
			return "/employees/list-employees";
		}
	}

