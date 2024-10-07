package Task_managementService_interface;

import java.util.Optional;

import org.springframework.stereotype.Service;


@Service
public interface EmployeeService {


	EmployeeService saveEmployee(EmployeeService employee);
	
	Optional<EmployeeService> getTaskById(int empId);

	
	

	

}




