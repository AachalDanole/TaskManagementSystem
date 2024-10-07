package TaskManagement_ServiceImplementation;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;
import TaskManagement_Repository.ManagerRepository;
import TaskManagement_Service.Employee;
import Task_managementService_interface.Manager;



@Service
public class ManagerService implements Manager  {
	
	
	@Autowired
	private ManagerRepository managerRepository;

	
	 @Autowired
		public ManagerService(ManagerRepository managerRepository) {
			this.managerRepository = managerRepository;
		}
	 


	@Override
	public Employee saveempDetails(Employee emp) {
		// TODO Auto-generated method stub
		return managerRepository.save(emp) ;
	}

	
	

	@Override
	public void deleteTaskById(int empId) {
		// TODO Auto-generated method stub
		managerRepository.deleteById(empId);
		
	}





	@Override
	public Optional<Employee> getDetailsById(int empId) {
		// TODO Auto-generated method stub
		Optional<Manager> manager = managerRepository.findById(empId);  

		return manager;
	}



	@Override
	public Manager updateTaskById(Optional<Employee> empDet, Employee EmpDetails) {
		Employee employee=empDet.get();
		employee.setTask(EmpDetails.getTask());
		return managerRepository.save(EmpDetails);
	}



	
	
	



}
