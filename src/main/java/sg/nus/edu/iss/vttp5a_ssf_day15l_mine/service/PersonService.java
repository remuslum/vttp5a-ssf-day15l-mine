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

    public List<Person> getPersonsList(){
        return personRepo.getPersonsList();
    }

    public boolean addPersons(Person person){
        return personRepo.addPersons(person);
    }

    public Person findPersonById(String id){
        return personRepo.findPersonById(id);
    }

    public void setPersonsList(List<Person> persons){
        personRepo.setPersonsList(persons);
    }

    public boolean removePerson(Person person){
        return personRepo.removePerson(person);
    }

    public boolean updatePerson(Person person){
        return personRepo.updatePerson(person);
    }

    
}
