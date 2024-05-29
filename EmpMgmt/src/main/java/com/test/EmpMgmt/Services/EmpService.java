package com.test.EmpMgmt.Services;

import java.util.List;

import com.test.EmpMgmt.Entities.Employee;

public interface EmpService {
	public List<Employee> getList();
	public Employee getById(Long id);
	public Employee save(Employee emp);
	public void deleteEmp(Long id);
	public void updateEmp(Employee emp);
}
