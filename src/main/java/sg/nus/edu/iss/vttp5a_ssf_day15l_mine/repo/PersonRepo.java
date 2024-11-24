package sg.nus.edu.iss.vttp5a_ssf_day15l_mine.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import sg.nus.edu.iss.vttp5a_ssf_day15l_mine.model.Person;

@Repository
public class PersonRepo {
    private List<Person> persons;

    public PersonRepo(){
        this.persons = new ArrayList<>(List.of(new Person("1", "mark", "mark@abc.com"), new Person("2", "jacobs", "jacobs@abc.com"), new Person("3", "daniels", "daniels@xyz.com")));
    }

    public List<Person> getPersonsList(){
        return this.persons;
    }

    public boolean addPersons(Person person){
        return persons.add(person);
    }

    public Person findPersonById(String id){
        Person temp = new Person();
        for(Person person: persons){
            if(person.getIdentifier().equals(id)){
                temp = person;
            }
        }
        return temp;
    }

    public void setPersonsList(List<Person> persons){
        this.persons = persons;
    }

    public boolean removePerson(Person person){
        return this.persons.remove(person);
    }

    public boolean updatePerson(Person person){
        Person filteredPerson = findPersonById(person.getIdentifier());
        if(filteredPerson != null){
            removePerson(filteredPerson);
            addPersons(person);
            return true;
        }
        return false;
    }

}
