package com.employeeservice.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProjectDto {


    @JsonProperty("project_id")
    private int projectId;
    @JsonProperty("project_name")
    private String projectName;
    @JsonProperty("project_location")
    private String projectLocation;
    private String manager;
    private Boolean Completed;


}
