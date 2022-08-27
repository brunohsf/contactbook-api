package com.contactbook.controller;

import com.contactbook.entity.Contact;
import com.contactbook.repository.ContactRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/contact")
@Api(value = "API Rest for Contacts Management")
@CrossOrigin("*")
public class ContactController {

    @Autowired
    private ContactRepository repository;

    @PostMapping(value = "/save")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Insert contact in table contact")
    public Contact save(@RequestBody Contact contact) {
        return repository.save(contact);
    }

    @GetMapping(value = "/list")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Return a contact list")
    public List<Contact> list() {
        return repository.findAll();
    }

    @DeleteMapping("/delete/{idContato}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Delete a contact from the table")
    public void delete(@PathVariable("idContato") Integer idContato) {
        repository.deleteById(idContato);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Update a contact from table contact")
    public Contact update(@RequestBody Contact contact) {
        return repository.save(contact);
    }

}
