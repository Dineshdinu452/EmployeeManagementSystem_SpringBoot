package com.employeeservice.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EmployeeProjectDto {


    @JsonProperty("employee_name")
    private String employeeName;
    private int age;
    @JsonProperty("email_id")
    private String emailId;
    private long salary;
    @JsonProperty("date_of_birth")
    private String dateOfBirth;
    @JsonProperty("date_of_joining")
    private long dateOfJoining;
//    private String manager;


    @JsonProperty("project_id")
    private int projectId;
    @JsonProperty("project_name")
    private String projectName;
    @JsonProperty("project_location")
    private String projectLocation;
//    private String manager;
    private Boolean completed;


}
