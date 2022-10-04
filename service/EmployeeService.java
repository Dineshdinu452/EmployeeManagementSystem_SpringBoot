package com.employeeservice.service;

import com.employeeservice.Exception.ResourceNotFoundException;
import com.employeeservice.Projection.EmployeeProjectDetail;
import com.employeeservice.Projection.EmployeeProjectProjection;
import com.employeeservice.dto.EmployeeDto;
import com.employeeservice.dto.EmployeeProjectDto;
import com.employeeservice.entity.Employee;
import com.employeeservice.entity.Project;
import com.employeeservice.repository.EmployeeRepository;
import com.employeeservice.repository.ProjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(EmployeeService.class);

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ProjectRepository projectRepository;

    //    here we are converting the dto content to entity

    public Employee saveEmployeeToDb(EmployeeDto employeeDto){
        LOGGER.info("employeeDto: {}",employeeDto);
        Employee employee=new Employee();
        employee.setEmployeeName(employeeDto.getEmployeeName());
        employee.setAge(employeeDto.getAge());
        employee.setEmailId(employeeDto.getEmailId());
        employee.setSalary(employeeDto.getSalary());
        employee.setDateOfBirth(employeeDto.getDateOfBirth());
        employee.setManager(employeeDto.getManager());
        Project p=projectRepository.findByManager(employeeDto.getManager());
//        employee.setProject(p);
        LOGGER.info("employee: {}",employee);
        return employeeRepository.save(employee);
    }

    public String updateSalaryEmployee(int project_id)throws ResourceNotFoundException {


        Project project=projectRepository.findById(project_id);
        List<Employee> employee=employeeRepository.findByManager(project.getManager());


        LOGGER.info("employeeDetails: {}",employee);

        if(employee!=null){
            for(Employee e: employee){

               long sal= (long) (e.getSalary()*0.1+e.getSalary());
                e.setSalary(sal);

                employeeRepository.save(e);
            }
        }
        else{
            throw new ResourceNotFoundException("4001","no employee record found", null);
        }
        return "updated salary of all the employee by 10%";
    }

    public EmployeeProjectProjection getEmployeeAndProjectByManager(String manager, int employeeId) {
        EmployeeProjectProjection employee=employeeRepository.findByManagerByEmployee(manager,employeeId);
        if(employee!=null){
            return employeeRepository.findByManagerByEmployee(manager,employeeId);
        }
        else return null;
    }

    public List<EmployeeProjectDetail> findAll() {

        return employeeRepository.findAllProjection();

    }
}
