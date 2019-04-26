
package br.com.cast.people.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cast.people.domain.People;
import br.com.cast.people.repository.PeopleRepository;

@Service
public class PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;

    /**
     * List all People
     * @return List of people
     */
    public List<People> getAllPeoples() {
        List<People> Peoples = new ArrayList<>();
		peopleRepository.findAll().forEach(Peoples::add);
        
        return Peoples;
    }

    /**
     * Get one People 
     * @param id
     * @return People
     */
    public Optional<People> findParticularPeople(Long id) {

        return peopleRepository.findById(id);
    }

    /**
     * Create new People
     * @param people
     * @return Boolean
     */
    public Boolean createPeople(People people){
        try{
            peopleRepository.save(people);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    /**
     * Delete People
     * @param id
     * @return boolean
     */
    public boolean deletePeopleRecord(Long id){
        try{
            peopleRepository.deleteById(id);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    /**
     * Update People
     * @param people
     * @param peopleId
     * @return boolean
     */
    public boolean updatePeopleRecord(People people, Long peopleId){
        try{
            peopleRepository.save(people);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
