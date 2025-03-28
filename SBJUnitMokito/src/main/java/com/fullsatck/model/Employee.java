package com.fullsatck.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Employee")

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int empId;

    private  String empName;

    private String empAddress;

    private long empContactNo;

    private double empSalary;

    private String empEmailId;

    private String empPassowrd;


}
