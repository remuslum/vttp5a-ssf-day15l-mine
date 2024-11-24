package sg.nus.edu.iss.vttp5a_ssf_day15l_mine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.nus.edu.iss.vttp5a_ssf_day15l_mine.model.Person;
import sg.nus.edu.iss.vttp5a_ssf_day15l_mine.service.PersonService;
import sg.nus.edu.iss.vttp5a_ssf_day15l_mine.util.Utility;

@Controller
@RequestMapping("/persons")
public class PersonDeleteController {

    @Autowired
    PersonService personService;
    
    @GetMapping("/delete/{person-identifier}")
    public String deletePerson(@PathVariable("person-identifier") String identifier){
        Person p = personService.findPersonByIdentifier(Utility.REDISKEY, identifier);
        personService.removePerson(Utility.REDISKEY,p);
        return "redirect:/persons";
    }

}
