package com.fullsatck.service;

import com.fullsatck.model.Employee;
import com.fullsatck.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class EmployeeServiceImpl implements IEmployeeInterface{

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public Employee signUp(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public boolean signIn(String empEmailId, String empPassword) {

        boolean flag = false;

        Employee employee = employeeRepository.findByEmpEmailIdAndEmpPassowrd(empEmailId,empPassword);

        if(employee != null && employee.getEmpEmailId().equals(empEmailId) && employee.getEmpPassowrd().equals(empPassword))
        {
            flag = true;

        }

        return flag;
    }

    @Override
    public Optional<Employee> findByEmpId(int empId) {
        return employeeRepository.findById(empId);
    }

    @Override
    public List<Employee> findAllEmp() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmp(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findByEmpName(String empName) {
        return employeeRepository.findByEmpName(empName);
    }

    @Override
    public void deleteByEmpId(int empId) {
        employeeRepository.deleteById(empId);
    }

    @Override
    public void deleteAllEmp() {
        employeeRepository.deleteAll();
    }
}
