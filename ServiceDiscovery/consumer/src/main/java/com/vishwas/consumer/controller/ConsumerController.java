package com.vishwas.consumer.controller;

import com.vishwas.consumer.dto.Employee;
import com.vishwas.consumer.sevice.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @GetMapping("/getEmp")
    public List<Employee> getList() {
        return consumerService.getEmployees();
    }
}
