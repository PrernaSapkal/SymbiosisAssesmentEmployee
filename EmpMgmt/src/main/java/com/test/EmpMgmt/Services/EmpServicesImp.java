package com.test.EmpMgmt.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.EmpMgmt.Entities.Employee;
import com.test.EmpMgmt.Repository.EmpRepo;
@Service
public class EmpServicesImp implements EmpService {
	@Autowired
private EmpRepo empRepo;

	@Override
	public List<Employee> getList() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}

	@Override
	public Employee getById(Long id) {
		Optional<Employee> findByid = empRepo.findById(id);
		Employee emps = findByid.get();
		return emps;
	}

	@Override
	public Employee save(Employee emp) {
		// TODO Auto-generated method stub
		return empRepo.save(emp);
	}

	@Override
	public void deleteEmp(Long id) {
		empRepo.deleteById(id);
		
	}

	@Override
	public void updateEmp(Employee emp) {
		 empRepo.save(emp);
		
	}

	

	
	

}
