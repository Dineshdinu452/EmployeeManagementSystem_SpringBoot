package com.employeeservice.controller;
import com.employeeservice.Exception.ResourceNotFoundException;
import com.employeeservice.dto.ProjectDto;
import com.employeeservice.entity.Project;
import com.employeeservice.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class ProjectController {

    @Autowired ProjectService projectService;


    @PostMapping("/project/save")
    public Project saveProject(@RequestBody ProjectDto projectDto){
        return projectService.saveProjectToDb(projectDto);
    }

//Update completed to true for given project_id

    @PutMapping("/project/update/{project_id}")
    public Object updateProject(@PathVariable int project_id){
        try {
           return projectService.updateProjectStatus(project_id);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/project/delete")
    public ResponseEntity<String> deleteProject(){
        try{
            String delete=projectService.deleteCompletedProject();
            return new ResponseEntity<String>(delete,HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

}

