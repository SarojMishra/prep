package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.EmployeeList;

@Controller
public class EmployeeController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/employees")
	private String getAllEmployees(Model model) throws Exception {

		EmployeeList employees = restTemplate.getForObject("http://dummy.restapiexample.com/api/v1/employees",
				EmployeeList.class);

		model.addAttribute("employees", employees.getEmployees());

		return "welcome";
	}
}
