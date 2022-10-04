package com.employeeservice.repository;
import com.employeeservice.entity.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project,Integer> {


    Project findById(int project_id);

    @Query("delete from Project where completed = '1' ")
    void deleteAllCompleted();

    List<Project> findByCompleted(boolean status);

    Project findByManager(String manager);


}
