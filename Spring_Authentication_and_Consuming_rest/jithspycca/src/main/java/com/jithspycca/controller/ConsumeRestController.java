package com.jithspycca.controller;

import com.jithspycca.model.Person;
import com.jithspycca.rest.PersonProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/restApi")
public class ConsumeRestController {

    private PersonProxy personProxy;
    private WebClient webClient;
    private RestTemplate restTemplate;

    @Autowired
    public ConsumeRestController(PersonProxy personProxy,WebClient webClient,RestTemplate restTemplate){
        this.personProxy = personProxy;
        this.webClient = webClient;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/getPersonEmail")
    public String getPersonEmail(){
        return personProxy.getPersonDetails();
    }

    @PostMapping("/savePerson")
    public Mono<Person> savePerson(@RequestBody Person person){
        String url = "http://localhost:8081/api/savePerson";
        return webClient.post().uri(url)
                .header("invocationFrom","JithspyccaService")
                .body(Mono.just(person),Person.class)
                .retrieve().bodyToMono(Person.class);
    }

    @PostMapping("/savePerson1")
    public Person savePerso1(@RequestBody Person person){
        String url = "http://localhost:8081/api/savePerson1";
        HttpHeaders httpHeaders = new HttpHeaders();
       httpHeaders.add("invocationFrom","restService");
        HttpEntity<Person> httpEntity = new HttpEntity<>(person,httpHeaders);
        ResponseEntity<Person> responseEntity = restTemplate.exchange(url, HttpMethod.POST,httpEntity,Person.class);
        return responseEntity.getBody();
    }
}
