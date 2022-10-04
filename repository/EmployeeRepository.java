package com.employeeservice.repository;

import com.employeeservice.Projection.EmployeeProjectDetail;
import com.employeeservice.Projection.EmployeeProjectProjection;
import com.employeeservice.dto.EmployeeProjectDto;
import com.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {


    List<Employee> findByManager(String manager);


    @Query(value = "select Employee.employee_id as employeeId, Employee.employee_name as employeeName, Employee.age as age, Employee.email_id as emailId, Employee.salary as salary, Employee.date_of_birth as dateOfBirth, Employee.date_of_joining as dateOfJoining, Employee.manager as manager, Project.project_id as projectId, Project.project_name as projectName, Project.project_location as projectLocation from Employee join Project on Employee.manager=Project.manager where Employee.employee_id=:employeeId and Employee.manager=:managerName",nativeQuery = true)
    EmployeeProjectProjection findByManagerByEmployee(String managerName, int employeeId);


    @Query(value = "select Employee.employee_id as employeeId, Employee.employee_name as employeeName, Project.project_name as projectName, Project.project_location as projectLocation from Employee join Project on Employee.manager=Project.manager",nativeQuery = true)
    List<EmployeeProjectDetail> findAllProjection();

}
