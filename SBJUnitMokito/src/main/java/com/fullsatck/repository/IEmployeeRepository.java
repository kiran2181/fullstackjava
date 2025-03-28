package com.fullsatck.repository;

import com.fullsatck.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {

    //Custom Method

    Employee findByEmpEmailIdAndEmpPassowrd(String empEmailId,String empPassowrd);

    List<Employee> findByEmpName(String empName);

}
