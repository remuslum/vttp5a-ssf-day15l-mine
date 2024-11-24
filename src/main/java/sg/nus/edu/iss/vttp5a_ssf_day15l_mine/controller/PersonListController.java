package sg.nus.edu.iss.vttp5a_ssf_day15l_mine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.nus.edu.iss.vttp5a_ssf_day15l_mine.model.Person;
import sg.nus.edu.iss.vttp5a_ssf_day15l_mine.service.PersonService;

@Controller
@RequestMapping("/persons")
public class PersonListController {
    
    @Autowired
    PersonService personService;

    @GetMapping
    public String displayPersons(Model model){
        List<Person> persons = personService.getPersonsList();
        model.addAttribute("persons",persons);
        return "PersonList";
    }
}
