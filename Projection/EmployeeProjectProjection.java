package com.employeeservice.Projection;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public interface EmployeeProjectProjection {

    int getEmployeeId();
    String getEmployeeName();
    int getAge();
    String getEmailId();
    long getSalary();
    String getDateOfBirth();
    Date getDateOfJoining();
    String getManager();


    int getProjectId();
    String getProjectName();
    String getProjectLocation();
    Boolean getCompleted();
//    String getManager();

}
