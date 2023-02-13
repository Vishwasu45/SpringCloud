package com.vishwas.producer.controller;

import com.vishwas.producer.dto.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProducerController {

    @GetMapping("/get")
    public ResponseEntity<List<Employee>> getEmployee() {
        var emp1 = new Employee(1, "Vishwas");
        var emp2 = new Employee(2, "Umashankar");
        return new ResponseEntity<>(List.of(emp1, emp2), HttpStatus.OK);
    }
}
