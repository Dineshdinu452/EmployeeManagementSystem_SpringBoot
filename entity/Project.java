package com.employeeservice.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table(name="project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private int projectId;
    @Column(name = "project_name")
    private String projectName;
    @Column(name = "project_location")
    private String projectLocation;
    @Column
    private String manager;
    @Column
    private boolean completed;
//
//    joining two table using one to many annotation........
//    @NotNull
//    @OneToMany(mappedBy = "project")
//    @JoinColumn(name="manager")
//    private List<Employee> employee;


    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", projectLocation='" + projectLocation + '\'' +
                ", manager='" + manager + '\'' +
                ", completed=" + completed +
                '}';
    }
}
