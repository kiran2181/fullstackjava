package com.fullsatck.service;

import com.fullsatck.model.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeInterface {

    Employee signUp(Employee employee);

    boolean signIn(String empEmailId,String empPassword);

    Optional<Employee> findByEmpId(int empId);

    List<Employee> findAllEmp();

    Employee updateEmp(Employee employee);

    List<Employee> findByEmpName(String empName);

    void deleteByEmpId(int empId);

    void deleteAllEmp();

}
