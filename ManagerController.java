package TaskManagement_Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BusManagement.Bus.Driver;

import TaskManagement_Repository.ManagerRepository;
import TaskManagement_Service.Employee;
import TaskManagement_ServiceImplementation.EmployeeServiceImplementaton;
import TaskManagement_ServiceImplementation.ManagerService;


@CrossOrigin(origins = "http://localhost:4200")  
@RestController
@RequestMapping("/Driver")
public  class ManagerController {
	
	@Autowired
	private EmployeeServiceImplementaton service;
	
	@Autowired
	private ManagerRepository managerrepository;
	
	public ManagerService managerService;
	
	@PostMapping("emp/saveEmp")
	public ResponseEntity <Employee> saveBusDetails(@RequestBody Employee employee){
		try {
		return new ResponseEntity<Employee>(service.saveEmployee(employee), HttpStatus.CREATED);
	  }
		catch(Exception exception) {
   			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@DeleteMapping("delete/{id}")	
	public ResponseEntity<String> deleteTaskById(@PathVariable("id")  int empId)
	{
		Optional<Employee> empdata=managerService.getDetailsById(empId);

		try {
			if(empdata.isPresent())
			{
				managerService.deleteTaskById(empId);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}	
   }

	
	@PutMapping("update/{empId}")
	public ResponseEntity<Employee> updateTaskById(@PathVariable int empId, @RequestBody Employee employee){
		
		Optional<Employee> empdata=managerService.getDetailsById(empId);

		if(empdata.isPresent())
		{

			managerService.updateTaskById(empdata, employee);
		return new ResponseEntity<>(managerService.updateTaskById(empId,employee ),HttpStatus.OK);

	}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
}
