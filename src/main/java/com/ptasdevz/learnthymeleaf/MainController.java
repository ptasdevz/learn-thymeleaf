package com.ptasdevz.learnthymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.GregorianCalendar;
import java.util.HashMap;

@Controller
public class MainController {
    Person person;

    public MainController() {
        this.person = new Person();
        person.setTitle("Mr");
        person.setFirstName("Jason");
        person.setLastName("Peters");
        person.setDateOfBirth(new GregorianCalendar(2006, 3, 9).getTime());
        person.setDescription("a <strong>fantastic</strong> Web Developer.");
        person.setUserName("jpeters");
        person.setId(771);
    }

    @RequestMapping()
    public ModelAndView homepage() {
        return new ModelAndView("homepage", "model", person);
    }

    @RequestMapping("/profile")
    public ModelAndView viewProfile() {

        //standard way


        //generic way
        HashMap<String, Object> model = new HashMap<>();
        model.put("title", "Mr.");
        model.put("firstName", "Jason");
        model.put("lastName", "Peters");
        model.put("dateOfBirth", new GregorianCalendar(2006, 3, 9).getTime());
        model.put("description", "a <strong>fantastic</strong> Web Developer.");

        return new ModelAndView("profile", "model", person);
    }
}
