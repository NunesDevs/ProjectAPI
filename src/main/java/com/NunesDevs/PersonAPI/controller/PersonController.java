package com.NunesDevs.PersonAPI.controller;

import com.NunesDevs.PersonAPI.dto.MessageResponseDTO;
import com.NunesDevs.PersonAPI.dto.request.PersonDTO;
import com.NunesDevs.PersonAPI.entity.Person;
import com.NunesDevs.PersonAPI.exception.PersonNotFoundException;
import com.NunesDevs.PersonAPI.repositoy.IPersonREPO;
import com.NunesDevs.PersonAPI.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private IPersonREPO personREPO;

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {

        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){

        return personService.createPerson(personDTO);

    }

    @GetMapping
    public List<PersonDTO> listAll(){

        return personService.listAll();

    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {

        return personService.findById(id);

    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException {

        return personService.updateById(id, personDTO);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PersonNotFoundException {

      personService.delete(id);

    }
}
