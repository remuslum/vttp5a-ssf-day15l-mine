package sg.nus.edu.iss.vttp5a_ssf_day15l_mine.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import sg.nus.edu.iss.vttp5a_ssf_day15l_mine.model.Person;
import sg.nus.edu.iss.vttp5a_ssf_day15l_mine.util.Utility;

@Repository
public class PersonRepo {
    @Autowired
    @Qualifier(Utility.TEMPLATE01)
    private RedisTemplate<String, Person> redisTemplate;

    // public PersonRepo(){
    //     this.persons = new ArrayList<>(List.of(new Person("1", "mark", "mark@abc.com"), new Person("2", "jacobs", "jacobs@abc.com"), new Person("3", "daniels", "daniels@xyz.com")));
    // }

    public List<Person> getPersonsList(String key){
        return redisTemplate.opsForList().range(key, 0, -1);
    }

    public void addPerson(String key, Person person){
        redisTemplate.opsForList().rightPush(key, person);
    }

    public Person findPersonByIdentifier(String key, String identifier){
        List<Person> persons = getPersonsList(key);
        Person temp = new Person();
        for(Person person: persons){
            if(person.getIdentifier().equals(identifier)){
                temp = person;
            }
        }
        return temp;
    }

    public void removePerson(String key, Person person){
        redisTemplate.opsForList().remove(key, 1, person);
    }

    public void updatePerson(String key, Person person){
        Person filteredPerson = findPersonByIdentifier(key, person.getIdentifier());
        if(filteredPerson != null){
            removePerson(key, filteredPerson);
            addPerson(key, person);
        }
    }

}
