package com.controledeponto.application.controller;

import com.controledeponto.application.model.Person;
import com.controledeponto.application.dto.PersonDTO;
import com.controledeponto.application.mapper.PersonMapper;
import com.controledeponto.application.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @Autowired
    PersonMapper personMapper;

    @PostMapping
    public ResponseEntity<PersonDTO> insert(@RequestBody PersonDTO personDTO) {
        Person person = personMapper.personDTOToPerson(personDTO);
        personService.insert(person);
        personDTO = personMapper.toPersonDTO(person);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(personDTO);
    }

    @GetMapping
    public ResponseEntity<List<PersonDTO>> findAll() {
        return ResponseEntity.ok()
                .body(personMapper.toPersonDTOList(personService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> findById(@PathVariable Long id) {
        return ResponseEntity
                .ok()
                .body(personMapper
                        .toPersonDTO(personService.findbyId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody PersonDTO personDTO) {
        personService.update(id, personMapper.personDTOToPerson(personDTO));
        return ResponseEntity
                .ok()
                .build();
    }

    @GetMapping("/login/{login}")
    public ResponseEntity<PersonDTO> findByLogin(@PathVariable String login) {
        return ResponseEntity
                .ok()
                .body(personMapper.toPersonDTO(personService.findByLogin(login)));
    }

    @PutMapping("/status/inactivate/{id}")
    public ResponseEntity<Void> inactivatePerson(@PathVariable Long id) {
        personService.inactivatePerson(id);
        return ResponseEntity
                .ok()
                .build();
    }
    @PutMapping("/status/activate/{id}")
    public ResponseEntity<Void> activatedPerson(@PathVariable Long id) {
        personService.activatePerson(id);
        return ResponseEntity
                .ok()
                .build();
    }
}
