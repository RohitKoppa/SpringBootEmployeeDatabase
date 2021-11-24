package com.springboot.springboot.exception;

public class EmployeeNotFoundForThisUid extends Exception {
	private static final long serialVersionUID = 1L;
	
    String message;
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public EmployeeNotFoundForThisUid(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String toString() {
        return "EmployeeNotFoundForThisUid{" +
                "message='" + message + '\'' +
                '}';
    }

}
