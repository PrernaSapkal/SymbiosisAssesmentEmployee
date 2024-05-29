package com.test.EmpMgmt.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.transaction.Transactional;
@Controller
@Transactional
public class DashboardController {
	
		@GetMapping("/getdashboard")
		public String getDashboard() {
			return "dashboard";
			
		}
}
