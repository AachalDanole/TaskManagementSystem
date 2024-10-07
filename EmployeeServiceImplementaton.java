package TaskManagement_ServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import TaskManagement_Repository.EmployeeRepository;
import Task_managementService_interface.Employee;

@Service

public class EmployeeServiceImplementaton implements Employee{

	
	@Autowired
	public EmployeeRepository employeeRepository;
	

	public EmployeeServiceImplementaton(EmployeeRepository employeeRepository) {
		
		this.employeeRepository = employeeRepository;
	}
	
	
	
	@Override
	public Employee saveEmployee(Employee employee) {

		return employeeRepository.save(employee);
	}

	@Override
	public Optional<Employee> getTaskById(int empId) {
		Optional <Employee> emp = employeeRepository.findById(empId);
		return emp;
	}
	
	

}
