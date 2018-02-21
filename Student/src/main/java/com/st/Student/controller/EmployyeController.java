package com.st.Student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.st.Student.model.Employee;
import com.st.Student.service.EmployeeService;


@RestController
public class EmployyeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	/*This method used to save an employee into the database
	Input param : employee details object
	output : response entity with success ot error message*/
	@PostMapping("/addemployee")
	 public ResponseEntity<?> addEmployye(@RequestBody Employee employee) throws JsonProcessingException {
	      long id = employeeService.addEmployye(employee);
	    String outputJson=  objectMapper.writeValueAsString(employee);
	      return ResponseEntity.ok().body(outputJson);
	   }
	
	
	/*This method used to get Employee by id into the database
	 * Input param : Employee id
	 * output : response entity with employee */
	@GetMapping("/getemployee/{id}")
	 public ResponseEntity<Employee> getEmployee(@PathVariable("id") long id) {
	      Employee employee = (Employee) employeeService.getEmployee(id);	
	      return ResponseEntity.ok().body(employee);
	   }
	
	
	/*This method used to get AllEmployees into the database
	 * Input param : 
	 * output : response entity with all employees */
	@GetMapping("/employee")
	 public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> employees = employeeService.getAllEmployees();
		return ResponseEntity.ok().body(employees);
	  }
	
	/* --This method used to Update the Employees into the database
	 * Input param : details
	 * Output : Response Entity by update --*/
	 @PutMapping("/updateEmployee/{id}")
	  public ResponseEntity<?> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) throws JsonProcessingException{
		employeeService.updateEmployee(employee);
		 String outputJson=  objectMapper.writeValueAsString(employee);
		return ResponseEntity.ok().body(outputJson);
	  }
	
	/* This method used to delete the employee from the database
	 * Input Param : integer
	 * OutPut : response with delete the employee --*/
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id")long id) {
		employeeService.deleteEmployee(id);
		return ResponseEntity.ok().body("Employee Has been deleted");
		
	}
	
	 @GetMapping("/")
	   public ModelAndView index(Model model) {

	      // Get authenticated user name from SecurityContext
	      SecurityContext context = SecurityContextHolder.getContext();
	      
	      model.addAttribute("message", "You are logged in as " 
	                     + context.getAuthentication().getName());
	      ModelAndView mav=new ModelAndView("index");
	      mav.addObject(model);
	      return mav;
	   }
}
