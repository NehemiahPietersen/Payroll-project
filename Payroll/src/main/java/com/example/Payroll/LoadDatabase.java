package com.example.payroll;

import com.example.payroll.Employee.Employee;
import com.example.payroll.Employee.EmployeeRepository;
import com.example.payroll.Order.Order;
import com.example.payroll.Order.OrderRepository;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;

@Configuration
class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepository, OrderRepository orderRepository) {
        return args -> {
            employeeRepository.save(new Employee("Bilbo", "Baggins", "Burglar"));
            employeeRepository.save(new Employee("Frodo", "Baggins", "Thief"));

            employeeRepository.findAll().forEach(employee -> log.info("Preloaded..." + employee));

            orderRepository.save(new Order("MacBook Pro", Status.COMPLETED));
            orderRepository.save(new Order("Iphone", Status.IN_PROGRESS));

            orderRepository.findAll().forEach(order -> log.info("Preloaded..." + order));
        };
    }
}
