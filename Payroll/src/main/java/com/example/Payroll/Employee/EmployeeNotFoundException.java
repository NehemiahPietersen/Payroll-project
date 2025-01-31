package com.example.Payroll.Employee;

public class EmployeeNotFoundException extends RuntimeException{
    EmployeeNotFoundException(Long id) {
        super("Could not find Employee" + id);
    }
}
