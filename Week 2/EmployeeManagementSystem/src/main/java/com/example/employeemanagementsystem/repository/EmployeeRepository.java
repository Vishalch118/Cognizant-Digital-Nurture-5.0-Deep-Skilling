package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmail(String email);

    List<Employee> findByName(String name);

    List<Employee> findByNameContaining(String name);

    List<Employee> findByNameStartingWith(String prefix);

    List<Employee> findByDepartmentName(String departmentName);

    @Query("SELECT e FROM Employee e WHERE e.email = :email")
    Employee getEmployeeByEmail(@Param("email") String email);

    @Query(value = "SELECT * FROM employees WHERE name = :name", nativeQuery = true)
    List<Employee> getEmployeesByNameNative(@Param("name") String name);

    Employee findByEmailNamed(@Param("email") String email);

}