package com.employeeservice.service;


import com.employeeservice.Exception.ResourceNotFoundException;
import com.employeeservice.dto.ProjectDto;
import com.employeeservice.entity.Project;
import com.employeeservice.repository.ProjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(ProjectService.class);

    @Autowired
    ProjectRepository projectRepository;

    public Project saveProjectToDb(ProjectDto projectDto){
        LOGGER.info("projectDto: {}",projectDto);
        Project project=new Project();
        project.setProjectName(projectDto.getProjectName());
        project.setProjectLocation(projectDto.getProjectLocation());
        project.setManager(projectDto.getManager());
        project.setCompleted(false);
        LOGGER.info("project: {}",project);

        return projectRepository.save(project);
    }

//    Update completed to true for given project_id

    public Project updateProjectStatus(int project_id) throws ResourceNotFoundException{

        Project project=projectRepository.findById(project_id);

        if(project!=null){
            project.setCompleted(true);
            projectRepository.save(project);
        }
        else {
            throw new ResourceNotFoundException("40010","ALREADY UPDATED",null);
        }
        return project;
    }


    //    Delete all projects who has completed the development (delete if completed=true)

    public String deleteCompletedProject() throws ResourceNotFoundException {
//       if(projectRepository.deleteAllCompleted()){
////           projectRepository.delete();
//           return "deleted all project";
//        }
//        else {
//            throw new ResourceNotFoundException("4001","no student record found", null);
//        }

        List<Project> completedProjects=projectRepository.findByCompleted(true);
        projectRepository.deleteAll(completedProjects);
        return "deleted project ";
    }
}





