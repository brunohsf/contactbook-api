package com.contactbook.repository;

import com.contactbook.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository <Person, Integer> {
    Optional<Person> findByEmailPerson(String emailPerson);
}
