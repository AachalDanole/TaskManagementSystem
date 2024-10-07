package Task_managementService_interface;

import java.util.List;
import java.util.Optional;


import TaskManagement_Service.Employee;



public interface ManagerService {
	
	

	
	Employee saveempDetails(Employee emp);
	
    Optional<Employee> getDetailsById(int empIde);

	
	
	
	// Method to update an existing Bus entity in the database based on its ID
	ManagerService updateTaskById( Optional<Employee> empDet,Employee EmpDetails);
	
	// Method to delete a specific Bus entity from the database based on its ID
	void deleteTaskById(int empId);
	
	

}
