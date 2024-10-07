package Task_managementService_interface;

import java.util.Optional;

import org.springframework.stereotype.Service;


@Service
public interface Employee {


	Employee saveEmployee(Employee employee);
	
	Optional<Employee> getTaskById(int empId);

	
	

	

}




