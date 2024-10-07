package TaskManagement_Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.BusManagement.Bus.Admin;

import Task_managementService_interface.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager ,Integer>{
	
	@Query(value = "SELECT * FROM manager u WHERE u.manager_mail = ?1 AND u.manager_password = ?2 ",nativeQuery = true  )

	public Optional<Manager> findByadminEmailAndPassword(String email, String Password);


}
