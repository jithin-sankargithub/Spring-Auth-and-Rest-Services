package com.jithspycca.service;

import com.jithspycca.model.Person;
import com.jithspycca.model.Roles;
import com.jithspycca.repository.PersonRepository;
import com.jithspycca.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    private PersonRepository personRepository;
    private PasswordEncoder passwordEncoder;
    private RolesRepository roleRepository;

    @Autowired
    public PersonService(PersonRepository personRepository,PasswordEncoder passwordEncoder
    ,RolesRepository roleRepository){
        this.personRepository = personRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }
    public Person createUser(Person person) {
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        Optional<Roles> role = roleRepository.findById(1);
        role.ifPresent(r -> person.setRoles(role.get()));
        return personRepository.save(person);
    }
}
