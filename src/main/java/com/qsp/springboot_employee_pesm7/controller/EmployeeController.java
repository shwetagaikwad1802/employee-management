package com.qsp.springboot_employee_pesm7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.springboot_employee_pesm7.dao.EmployeeDao;
import com.qsp.springboot_employee_pesm7.dto.Employee;
import com.qsp.springboot_employee_pesm7.service.Services;
import com.qsp.springboot_employee_pesm7.util.ResponseStructure;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeDao dao;

	@Autowired
	private Services services;

	@PostMapping("/save")
	public ResponseStructure<Employee> saveEmployee(@RequestBody Employee employee) {
		return services.saveEmployee(employee);
	}

	@GetMapping("/fetch")
	public Employee getEmployee(@RequestParam int id) {
		return dao.getEmployee(id);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseStructure<Employee> deleteEmployee(@PathVariable int id) {
		return services.deletEmployee(id);
	}

	@GetMapping("/email")
	public ResponseStructure<Employee> getEmployeeByEmail(@RequestParam String email) {
		return services.getEMployeeByemail(email);
	}

	@GetMapping("/getByPhone/{phone}")
	public ResponseStructure<Employee> getEmployeeByPhone(@PathVariable long phone) {
		return services.getEmployeeByPhone(phone);
	}

	@PutMapping("/update")
	public ResponseStructure<Employee> updateEmployee(@RequestParam int id, @RequestParam Employee employee) {
		return services.UpdateEmployee(id, employee);
	}

	@GetMapping("/findBySal")
	public List<Employee> findBysal(@RequestParam double salary) {
		return services.findBysal(salary);
	}

}
