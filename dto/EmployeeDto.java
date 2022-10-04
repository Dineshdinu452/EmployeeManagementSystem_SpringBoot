package com.employeeservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EmployeeDto {


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

    private String manager;
}
