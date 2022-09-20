package com.neo4j.example.springdataneo4jintroapp.controllers;

import com.neo4j.example.springdataneo4jintroapp.domainClasses.Person;
import com.neo4j.example.springdataneo4jintroapp.repositories.PersonRepository;
import com.neo4j.example.springdataneo4jintroapp.utils.RequestUtils;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/people")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    public Page<Person> findAllPersons(
            @RequestParam Map<String, String> pageAndSort,
            @RequestParam(name = "sortBy", required = false) String[] sortBy) {
        PageRequest page = RequestUtils.pageAndSort(pageAndSort, sortBy);
        return this.personRepository.findAll(page);
    }

    @GetMapping("/{name}")
    public Person getPersonByName(@PathVariable String name) {
        return personRepository.getPersonByName(name);
    }

    @GetMapping("/search/{name}")
    public Iterable<Person> findPersonByNameLike(@PathVariable String name) {
        return personRepository.findPersonByNameLike(name);
    }

    @GetMapping("/actanddirect")
    public List<Person> getPersonsWhoActAndDirect() {
        return personRepository.getPersonsWhoActAndDirect();
    }

    @PostMapping
    public Person save(@RequestBody Person newPerson) {
        return personRepository.save(newPerson);
    }
}
