package com.example.Payroll;

import com.example.Payroll.Employee.Employee;
import com.example.Payroll.Employee.EmployeeRepository;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {
        return args -> {
            log.info("Preloading... " + repository.save(new Employee("Bilbo Baggins", "Burglar")));
            log.info("Preloading... " + repository.save(new Employee("Frodo Baggins", "Thief")));
        };
    }
}
