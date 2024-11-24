package sg.nus.edu.iss.vttp5a_ssf_day15l_mine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.nus.edu.iss.vttp5a_ssf_day15l_mine.model.Person;
import sg.nus.edu.iss.vttp5a_ssf_day15l_mine.repo.PersonRepo;

@Service
public class PersonService {
    @Autowired
    PersonRepo personRepo;

    public List<Person> getPersonsList(String key){
        return personRepo.getPersonsList(key);
    }

    public void addPerson(String key, Person person){
        personRepo.addPerson(key, person);
    }

    public Person findPersonByIdentifier(String key, String identifier){
        return personRepo.findPersonByIdentifier(key, identifier);
    }

    public void removePerson(String key, Person person){
        personRepo.removePerson(key, person);
    }

    public void updatePerson(String key, Person person){
        personRepo.updatePerson(key, person);
    }

    
}
