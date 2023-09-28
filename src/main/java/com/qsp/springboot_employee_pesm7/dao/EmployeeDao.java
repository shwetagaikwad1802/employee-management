package com.qsp.springboot_employee_pesm7.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springboot_employee_pesm7.dto.Employee;
import com.qsp.springboot_employee_pesm7.repo.EmployeeRepo;
import com.qsp.springboot_employee_pesm7.util.ResponseStructure;

@Repository
public class EmployeeDao {
	@Autowired
	private EmployeeRepo repo;

	public Employee saveEmployee(Employee employee) {
		return repo.save(employee);
	}

	public Employee getEmployee(int id) {

		return repo.findById(id).get();
	}

	public Employee updatEmployee(Employee employee, int id) {
		Optional<Employee> optional = repo.findById(id);
		if (optional.isPresent()) {
			employee.setId(id);
			repo.save(employee);
		}
		return null;

	}

	public Employee deleteEmployee(int id) {
		Optional<Employee> optional = repo.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		repo.deleteById(id);
		return optional.get();
	}

	public Employee getEmployeeByemail(String email) {

		return repo.findByemail(email);

	}

	public Employee getEmployeeByphone(long phone) {

		return repo.findByPhone(phone);
	}

	public List<Employee> findBySal(double salary) {
		
		return repo.findBySalary(salary);
	}

}
