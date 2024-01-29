package com.jithspycca.controller;

import com.jithspycca.model.Person;
import com.jithspycca.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userOperations")
public class UserOperationsController {

    private PersonService personService;
    @Autowired
    public UserOperationsController(PersonService personService){
      this.personService = personService;
    }

    @GetMapping(value ="/getUserDetails/{userId}")
    public String getUserDetails(@PathVariable int userId){
        return "Provided user Id is: "+userId;
    }

    @GetMapping(value ="/checkHealth")
    public String checkHealth(){
        return "App is up";
    }

    @PostMapping("/createUser")
    public Person createUser(@RequestBody Person person){
        return personService.createUser(person);
    }

}
