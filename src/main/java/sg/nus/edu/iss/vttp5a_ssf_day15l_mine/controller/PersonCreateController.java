package sg.nus.edu.iss.vttp5a_ssf_day15l_mine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.nus.edu.iss.vttp5a_ssf_day15l_mine.model.Person;
import sg.nus.edu.iss.vttp5a_ssf_day15l_mine.service.PersonService;
import sg.nus.edu.iss.vttp5a_ssf_day15l_mine.util.Utility;

@Controller
@RequestMapping("/persons")
public class PersonCreateController {
    
    @Autowired
    PersonService personService;

    @GetMapping("/create")
    public String goToCreateForm(Model model){
        model.addAttribute("person", new Person());
        return "PersonCreate";
    }

    @PostMapping("/create")
    public String createPerson(Person person, Model model){
        Person p = new Person(person.getId(), person.getFullName(), person.getEmail());
        personService.addPerson(Utility.REDISKEY, p);
        // List<Person> persons = personService.getPersonsList(Utility.REDISKEY);
        // model.addAttribute("persons", persons);
        return "redirect:/persons";
    }
}
