package com.test.EmpMgmt.Controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.EmpMgmt.Entities.Employee;
import com.test.EmpMgmt.Services.EmpService;

import jakarta.validation.Valid;
@Controller
public class EmployeeController {
	@Autowired
	private EmpService empService;
	
	
	@GetMapping("/getEmp")
	public String addEmployee(Model model)
	{
	model.addAttribute("employee",new Employee());
		return "newEmp";
		
	}
	@PostMapping("/empaction")
	public String getNewEmp(@Valid @ModelAttribute("employee") Employee bk, BindingResult br, Model model) {
		if(br.hasErrors()) {
			return "newEmp";
		}
		empService.save(bk);
		model.addAttribute("msg", "employee added successfully!!!");
		return "newEmp";
}

@GetMapping("/existingEmp")
public String getExistingEmp(Model model) {
	List<Employee> existingEmp = empService.getList();
	model.addAttribute("employees", existingEmp);
	return "existingEmp";
}
@PostMapping("/employee/delete")
public String deleteBook(@RequestParam("id") Long id) {
    empService.deleteEmp(id);
    return "redirect:/existingEmp";    
}
@GetMapping("/employee/update")
public String updateEmp(@RequestParam("id") Long id, Model model) {
    Employee employee = empService.getById(id);
    model.addAttribute("employee", employee);
    return "updateEmp";
}

@PostMapping("/employee/upedit")
public String getEmpUpdate(@Valid @ModelAttribute("employee") Employee employee, BindingResult br, Model model) {
    if (br.hasErrors()) {
        return "updateEmp";
    }
    empService.save(employee);
    return "redirect:/existingEmp";
}
}
