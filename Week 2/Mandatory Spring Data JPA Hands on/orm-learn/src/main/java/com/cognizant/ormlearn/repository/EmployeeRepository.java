package com.cognizant.ormlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> 
{
    @Query("SELECT e FROM Employee e WHERE e.permanent = TRUE")
    List<Employee> getAllPermanentEmployees();

    @Query(
        value="select * from employee where em_permanent=true",
        nativeQuery=true
    )
    List<Employee> getAllPermanentEmployeesNative();
}