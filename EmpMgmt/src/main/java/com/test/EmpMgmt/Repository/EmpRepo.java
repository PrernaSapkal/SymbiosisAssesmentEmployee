package com.test.EmpMgmt.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.EmpMgmt.Entities.Employee;
@Repository
public interface EmpRepo extends JpaRepository<Employee, Long> {

	
}
