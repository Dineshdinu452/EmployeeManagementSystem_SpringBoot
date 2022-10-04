package com.employeeservice.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.CascadeType.*;

@Data
@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "employee_name")
    private String employeeName;

    @Column
    private int age;
    @Column(name = "email_id")
    private String emailId;
    @Column
    private long salary;
    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_joining")
    private Date dateOfJoining = new Date(System.currentTimeMillis());

    @Column
    private String manager;

//    @ManyToOne
//    @JoinColumn(name="manager")
//    private Project project;

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", age=" + age +
                ", emailId='" + emailId + '\'' +
                ", salary=" + salary +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", dateOfJoining=" + dateOfJoining +
                ", manager='" + manager + '\'' +
                '}';
    }
}



