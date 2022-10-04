package com.employeeservice.Exception;

import lombok.Data;
@Data
public class ResourceNotFoundException extends Throwable {

    private String errorCode;
    private String message;

    public ResourceNotFoundException(String errorCode, String message, Exception exception){
        super(message,exception);
        this.errorCode=errorCode;
        this.message=message;

    }
}
