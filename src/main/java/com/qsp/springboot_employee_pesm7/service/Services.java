package com.qsp.springboot_employee_pesm7.service;

import java.util.List;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.qsp.springboot_employee_pesm7.dao.EmployeeDao;
import com.qsp.springboot_employee_pesm7.dto.Employee;
import com.qsp.springboot_employee_pesm7.util.ResponseStructure;

@Service
public class Services {
	@Autowired
	private EmployeeDao dao;
	ResponseStructure<Employee> responseStructure = new ResponseStructure<>();

	public ResponseStructure<Employee> saveEmployee(Employee employee) {
		if (employee.getSalary() > 0 && employee.getSalary() <= 10000) {
			employee.setGrade('D');
		} else if (employee.getSalary() > 10000 && employee.getSalary() <= 20000) {
			employee.setGrade('C');
		} else if (employee.getSalary() > 20000 && employee.getSalary() <= 40000) {
			employee.setGrade('B');
		} else {
			employee.setGrade('A');
		}
		responseStructure.setMessage("Saved successfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(dao.saveEmployee(employee));
		return responseStructure;
		// return dao.saveEmployee(employee);
	}

	public ResponseStructure<Employee> deletEmployee(int id) {
		responseStructure.setMessage("deleted successfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(dao.deleteEmployee(id));
		return responseStructure;
		// return dao.deleteEmployee(id);
	}

	public ResponseStructure<Employee> getEMployeeByemail(String email) {
		responseStructure.setMessage("fetched successfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(dao.getEmployeeByemail(email));
		return responseStructure;
		// return dao.getEmployeeByemail(email);
	}

	public ResponseStructure<Employee> getEmployeeByPhone(long phone) {
		responseStructure.setMessage("fetched successfully by phone");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(dao.getEmployeeByphone(phone));
		return responseStructure;
		// return dao.getEmployeeByemail(phone);
	}

	public ResponseStructure<Employee> UpdateEmployee(int id, Employee employee) {
		responseStructure.setMessage("updated successfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(dao.updatEmployee(employee, id));
		return responseStructure;
		//return dao.updatEmployee(employee, id);
	}

	public List<Employee> findBysal(double salary) {

		return dao.findBySal(salary);
	}

}
