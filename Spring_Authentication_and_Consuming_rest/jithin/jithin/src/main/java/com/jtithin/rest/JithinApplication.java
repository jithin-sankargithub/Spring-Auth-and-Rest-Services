package com.jtithin.rest;

import com.jtithin.rest.model.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("api")
public class JithinApplication {

	public static void main(String[] args) {
		SpringApplication.run(JithinApplication.class, args);
	}

	@GetMapping("getPersonDetails")
	public String getPersonDetails(){
		return "Rest api received";
	}

	@PostMapping("savePerson")
	public Person savePerson(@RequestBody Person person){
		person.setEmail("Received@gmail.com from webclient");
		return person;
	}

	@PostMapping("savePerson1")
	public Person savePerson1(@RequestBody Person person){
		person.setEmail("Received@gmail.com from rest Template");
		return person;
	}

}
