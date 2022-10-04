package com.employeeservice.controller;
import com.employeeservice.Exception.ResourceNotFoundException;
import com.employeeservice.Projection.EmployeeProjectDetail;
import com.employeeservice.Projection.EmployeeProjectProjection;
import com.employeeservice.dto.EmployeeDto;
import com.employeeservice.dto.EmployeeProjectDto;
import com.employeeservice.entity.Employee;
import com.employeeservice.service.EmployeeService;
import com.employeeservice.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    ProjectService projectService;

    @PostMapping("/employee/save")
    public Employee saveEmployee(@RequestBody EmployeeDto employeeDto){
        return employeeService.saveEmployeeToDb(employeeDto);

//        http://localhost:8080/employee/save
    }
    //swagger ui implementation
//    http://localhost:8080/swagger-ui/index.html#/

//    Update the salary of all employees by 10% who is in the project with project_id

    @PutMapping("/employee/update/project/{project_id}")
    public Object updateSalary(@PathVariable int project_id){
        try{
           return employeeService.updateSalaryEmployee(project_id);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

//  @GetMapping("/employee/project/{manager}/detail?id=value")
    @GetMapping("/employee/project/{manager}/detail")
    public ResponseEntity<Object> findByManager(@PathVariable(value = "manager")String manager,
                                                @RequestParam(value = "id", required = true)int employeeId){

        EmployeeProjectProjection employee=  employeeService.getEmployeeAndProjectByManager(manager,employeeId);
        if(employee==null){
            return new ResponseEntity<>("NO EMPLOYEE FOUND",HttpStatus.NOT_FOUND);
        }
        else {
            return  new ResponseEntity<>(employee,HttpStatus.OK);
        }
    }

//    Fetch the employee_id, employee_name, project_name and project_location of each employee
//    url : /employee/project/location

    @GetMapping("/employee/project/location")
    public List<EmployeeProjectDetail> getAllDetails()
    {
        return employeeService.findAll();
    }
}
