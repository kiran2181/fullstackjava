package com.fullsatck.controller;

import com.fullsatck.exception.RecordNotFoundException;
import com.fullsatck.model.Employee;
import com.fullsatck.service.EmployeeServiceImpl;
import jdk.dynalink.linker.LinkerServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;


    @PostMapping("/signup")
    public ResponseEntity<Employee> signUp(@RequestBody Employee employee)
    {
        return ResponseEntity.ok(employeeService.signUp(employee));
    }

    @GetMapping("/signin")
    public ResponseEntity<Boolean> signIn(@RequestParam String empEmailId,@RequestParam String empPassword)
    {
        return ResponseEntity.ok(employeeService.signIn(empEmailId,empPassword));
    }

    @GetMapping("/findbyid")

    public ResponseEntity<Optional<Employee>> findByEmpId(@RequestParam int empId)
    {
        return ResponseEntity.ok(employeeService.findByEmpId(empId));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Employee>> findAllEmp()
    {
        return ResponseEntity.ok(employeeService.findAllEmp());
    }

    @PutMapping("/updatedata")
    public ResponseEntity<Employee> updateEmp(@RequestParam int empId,@RequestBody Employee employee)
    {
        Employee employee1 = employeeService.findByEmpId(empId).orElseThrow(()->new RecordNotFoundException("Employee #Id not Exist"));

        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpAddress(employee.getEmpAddress());
        employee1.setEmpEmailId(employee.getEmpEmailId());
        employee1.setEmpContactNo(employee.getEmpContactNo());
        employee1.setEmpPassowrd(employee.getEmpPassowrd());

        return ResponseEntity.ok(employeeService.updateEmp(employee1));
    }

    @GetMapping("/findbyname")
    public ResponseEntity<List<Employee>> findByEmpName(@RequestParam String empName)
    {
        return ResponseEntity.ok(employeeService.findByEmpName(empName));
    }

    @DeleteMapping("/deletebyid")
    public ResponseEntity<String> deleteByEmpId(@RequestParam int empId)
    {
        employeeService.deleteByEmpId(empId);
        return ResponseEntity.ok("Delete Data Successfully...!!");
    }

    @DeleteMapping("/deleteall")
    public ResponseEntity<String> deleteAllEmp()
    {
        employeeService.deleteAllEmp();
        return ResponseEntity.ok("Delete All Data Successfully..!!!");
    }

}
