package com.contactbook.controller;

import com.contactbook.entity.Contact;
import com.contactbook.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/contact")
@CrossOrigin("*")
public class ContactController {

    @Autowired
    private ContactRepository repository;

    @PostMapping(value = "/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Contact save(@RequestBody Contact contact) {
        return repository.save(contact);
    }

    @GetMapping(value = "/list")
    @ResponseStatus(HttpStatus.OK)
    public List<Contact> list() {
        return repository.findAll();
    }

    @DeleteMapping("/delete/{idContato}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("idContato") Integer idContato) {
        repository.deleteById(idContato);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Contact update(@RequestBody Contact contact) {
        return repository.save(contact);
    }

}
