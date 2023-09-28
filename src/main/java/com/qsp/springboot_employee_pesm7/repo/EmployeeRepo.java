package com.qsp.springboot_employee_pesm7.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qsp.springboot_employee_pesm7.dto.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>
{
    Employee findByemail(String email);
    
    @Query("select e from Employee e where phone=?1")
    Employee findByPhone(long phone);
    List<Employee> findBySalary(double salary);
}
