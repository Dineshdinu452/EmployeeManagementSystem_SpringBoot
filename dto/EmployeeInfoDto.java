package com.employeeservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EmployeeInfoDto {

    private int employeeId;

    @JsonProperty("employee_name")
    private String employeeName;

    @JsonProperty("project_name")
    private String projectName;

    @JsonProperty("project_location")
    private String projectLocation;

}
