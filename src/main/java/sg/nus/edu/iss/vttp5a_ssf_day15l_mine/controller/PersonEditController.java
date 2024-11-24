package sg.nus.edu.iss.vttp5a_ssf_day15l_mine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.nus.edu.iss.vttp5a_ssf_day15l_mine.model.Person;
import sg.nus.edu.iss.vttp5a_ssf_day15l_mine.service.PersonService;

@Controller
@RequestMapping("/persons")
public class PersonEditController {

    @Autowired 
    PersonService personService;

    @GetMapping("/edit/{person-identifier}")
    public String getPerson(@PathVariable("person-identifier") String personId, Model model){
        Person p = personService.findPersonById(personId);
        model.addAttribute("person", p);
        return "PersonEdit";
    }

    @PostMapping("/edit")
    public String editPerson(Person person){
        personService.updatePerson(person);
        return "redirect:/persons";
    }
    
}
