package com.fullsatck.service;

import com.fullsatck.model.Employee;
import com.fullsatck.repository.IEmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest

public class EmployeeServiceImplTest {


    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @MockitoBean
    private IEmployeeRepository employeeRepository;

    @BeforeEach
    public void setUp()
    {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void saveTest()
    {
        Employee employee = new Employee(101,"Kiran","Karad",7219824947L,87000.25,"kiran@gmail.com","Kiran@123");

       employeeRepository.save(employee);

        Mockito.verify(employeeRepository,Mockito.times(1)).save(employee);
    }

    @Test
    public void findallTest()
    {
       Mockito.when(employeeRepository.findAll()).thenReturn(Stream.of(new Employee(101,"Kiran","Karad",7219824947L,87000.25,"kiran@gmail.com","Kiran@123"),
               new Employee(102,"Akash","Chikhali",9970159904L,80000.25,"akash@gmail.com","Akash@123"),
               new Employee(103,"Mayur","Vita",9419824947L,97000.25,"mayur@gmail.com","Mayur@123")).toList());


        Assertions.assertEquals(3,employeeService.findAllEmp().stream().collect(Collectors.counting()));

    }

    @Test
    public void findByIdTest()
    {
        Mockito.when(employeeRepository.findById(121)).thenReturn(Optional.of(new Employee(101,"Kiran","Karad",7219824947L,87000.25,"kiran@gmail.com","Kiran@123")));
        employeeService.findByEmpId(121);

        Mockito.verify(employeeRepository,Mockito.times(1)).findById(121);


    }

    @Test
    public void updateTest()
    {
        Employee employee = new Employee(101,"Kiran","Karad",7219824947L,87000.25,"kiran@gmail.com","Kiran@123");

        employeeService.updateEmp(employee);
        Mockito.verify(employeeRepository,Mockito.times(1)).save(employee);
    }

    @Test

    public void deleteByIdTest()
    {
        Employee employee = new Employee(101,"Kiran","Karad",7219824947L,87000.25,"kiran@gmail.com","Kiran@123");

        employeeService.deleteByEmpId(employee.getEmpId());

        Mockito.verify(employeeRepository,Mockito.times(1)).deleteById(employee.getEmpId());
    }
}
