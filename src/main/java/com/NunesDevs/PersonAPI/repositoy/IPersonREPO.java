package com.NunesDevs.PersonAPI.repositoy;

import com.NunesDevs.PersonAPI.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonREPO extends JpaRepository<Person, Long> {

}
