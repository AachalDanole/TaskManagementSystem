package TaskManagement_Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import TaskManagement_Repository.EmployeeRepository;
import TaskManagement_Service.Employee;
import TaskManagement_ServiceImplementation.EmployeeServiceImplementaton;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

	private EmployeeServiceImplementaton service;
	
	
	public EmployeeController(EmployeeServiceImplementaton service) {
		this.service = service;
	}
	
	@PostMapping("/saveEmp")
	public ResponseEntity <Employee> saveEmployee(@RequestBody Employee employee){
		try {
		return new ResponseEntity<Employee>(service.saveEmployee(employee), HttpStatus.CREATED);
	  }
		catch(Exception exception) {
   			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/readEmp/{id}")
	public ResponseEntity<Employee>  getTaskById(@PathVariable("id")  int empId){
		System.out.println(empId); 
		Optional<Employee> emp = service.getTaskById(empId);
		
		if(emp.isPresent()) {
		return new ResponseEntity<>(emp.get(), HttpStatus.OK);
	        }
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	

}
