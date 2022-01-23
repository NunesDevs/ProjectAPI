package com.NunesDevs.PersonAPI.service;

import com.NunesDevs.PersonAPI.dto.MessageResponseDTO;
import com.NunesDevs.PersonAPI.entity.Person;
import com.NunesDevs.PersonAPI.repositoy.IPersonREPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonService {

    private IPersonREPO personREPO;

    @Autowired
    public PersonService(IPersonREPO personREPO) {
        this.personREPO = personREPO;
    }

    public MessageResponseDTO createPerson(Person person){
        Person savedPerson = personREPO.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }

}
