package com.NunesDevs.PersonAPI.service;

import com.NunesDevs.PersonAPI.dto.MessageResponseDTO;
import com.NunesDevs.PersonAPI.dto.request.PersonDTO;
import com.NunesDevs.PersonAPI.entity.Person;
import com.NunesDevs.PersonAPI.exception.PersonNotFoundException;
import com.NunesDevs.PersonAPI.mapper.IPersonMapper;
import com.NunesDevs.PersonAPI.repositoy.IPersonREPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@org.springframework.transaction.annotation.Transactional
public class PersonService {

    private final IPersonREPO personREPO;

    private final IPersonMapper personMapper = IPersonMapper.INSTANCE;

    @Autowired
    public PersonService(IPersonREPO personREPO) {
        this.personREPO = personREPO;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {

        Person personToSave = personMapper.toModel(personDTO);
        personToSave.setId(null);
        personToSave.setCpf(personToSave.getCpf().replaceAll("[^0-9]", ""));
        clearChildIds(personToSave);
        Person savedPerson = personREPO.saveAndFlush(personToSave);

        return createdMessageResponse(savedPerson.getId(), "Created person with ID ");

    }

    public List<PersonDTO> listAll() {

        List<Person> allPeople = personREPO.findAll();

        return allPeople.stream().map(personMapper::toDTO).collect(Collectors.toList());

    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {

        Person person = verifyIfExists(id);

        return personMapper.toDTO(person);

    }

    public void delete(Long id) throws PersonNotFoundException {

        verifyIfExists(id);
        personREPO.deleteById(id);

    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExists(id);

        Person personToUpdate = personMapper.toModel(personDTO);
        personToUpdate.setId(id);
        personToUpdate.setCpf(personToUpdate.getCpf().replaceAll("[^0-9]", ""));
        clearChildIds(personToUpdate);
        Person updatePerson = personREPO.saveAndFlush(personToUpdate);

        return createdMessageResponse(updatePerson.getId(), "Update person with ID ");

    }

    private void clearChildIds(Person person) {
        person.getPhones().forEach(phone -> phone.setId(null));
        person.getAddress().forEach(address -> address.setId(null));
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException {

        return personREPO.findById(id).orElseThrow(() -> new PersonNotFoundException(id));

    }

    private MessageResponseDTO createdMessageResponse(Long id, String s) {

        return MessageResponseDTO
                .builder()
                .message(s + id)
                .build();

    }
}
