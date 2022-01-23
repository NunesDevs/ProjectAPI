package com.NunesDevs.PersonAPI.mapper;

import com.NunesDevs.PersonAPI.dto.request.PersonDTO;
import com.NunesDevs.PersonAPI.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IPersonMapper {

    IPersonMapper INSTANCE = Mappers.getMapper(IPersonMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")

    Person toModel(PersonDTO personDTO);
    PersonDTO toDTO(Person person);

}
