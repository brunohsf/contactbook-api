package com.contactbook.controller;

import com.contactbook.entity.Contact;
import com.contactbook.entity.Person;
import com.contactbook.repository.PersonRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/person")
@Api(value = "API Rest for User Management")
@CrossOrigin("*")
public class PersonController {

    @Autowired
    private PersonRepository repository;

    @PostMapping(value = "/save")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Insert user in table user")
    public Person save(@RequestBody Person person) {
        return repository.save(person);
    }

    @GetMapping(value = "/list")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Return a person list")
    public List<Person> list() {
        return repository.findAll();
    }

}
