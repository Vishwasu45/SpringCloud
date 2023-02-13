package com.vishwas.consumer.sevice;

import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;
import com.vishwas.consumer.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class ConsumerService {

    @Autowired
    private EurekaClient discoveryClient;

    private RestTemplate restTemplate = new RestTemplate();

    public List<Employee> getEmployees() {
        var app = discoveryClient.getApplication("producer");
        var instance = app.getInstances().get(0);

        var list = restTemplate.getForEntity(instance.getHomePageUrl()+ "/api/v1/get", Employee[].class);
        return Arrays.asList(Objects.requireNonNull(list.getBody()));
    }

}
