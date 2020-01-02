package com.prateek.springboot2jpacrudexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prateek.springboot2jpacrudexample.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
