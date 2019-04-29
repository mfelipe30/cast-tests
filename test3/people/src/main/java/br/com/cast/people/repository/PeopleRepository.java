package br.com.cast.people.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.cast.people.domain.People;

public interface PeopleRepository extends CrudRepository<People, Long> {

    List<People> findByName(String name);

}