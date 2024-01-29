package com.jithspycca.rest;

import com.jithspycca.config.PersonConfiguration;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "person",url ="http://localhost:8081/api",
configuration = PersonConfiguration.class)
public interface PersonProxy {

    @GetMapping("/getPersonDetails")
    @Headers(value = "Content-Type: application/json")
    public String getPersonDetails();
}
