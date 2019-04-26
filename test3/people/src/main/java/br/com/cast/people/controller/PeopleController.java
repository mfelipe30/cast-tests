package br.com.cast.people.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.people.domain.People;
import br.com.cast.people.service.PeopleService;

/**
 * PeopleController
 */

@RestController
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @RequestMapping(value="/clientDetails", method = RequestMethod.GET)
    public Optional getClient(@RequestParam("id") Long id) {
        return peopleService.findParticularPeople(id);
    }

    @RequestMapping(value="/clients", method= RequestMethod.GET)
    public List getAllPeoplesList() {
        return peopleService.getAllPeoples();
    }

    @RequestMapping(value="/clientCreate", method = RequestMethod.POST)
    public void createPeople(@RequestBody People people) {
        peopleService.createPeople(people);
    }

    @RequestMapping(value="/clientDelete", method = RequestMethod.DELETE)
    public void deleteClient(@RequestParam("id") Long id) {
        peopleService.deletePeopleRecord(id);
    }

    @RequestMapping(value="/clientUpdate", method = RequestMethod.PUT)
    public void updateClient(@RequestBody People people, @RequestParam("id") Long peopleId) {
        peopleService.updatePeopleRecord(people, peopleId);
    }
    
}
