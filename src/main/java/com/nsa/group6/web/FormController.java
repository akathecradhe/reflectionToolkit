package com.nsa.group6.web;
import com.nsa.group6.domain.*;
import com.nsa.group6.service.FormService;
import com.nsa.group6.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class FormController {


    private final FormService formService;
    private final UserService userService;

    public FormController(FormService formService, UserService userService) {
        this.formService = formService;
        this.userService = userService;
    }


    @GetMapping("form")
    public String runForm(Model model) {

        model.addAttribute("event", "name");

        return "form";
    }

    @GetMapping("/reflections/{username}")
    public String allGreetings(@PathVariable(name = "username", required = false) Optional<String> username, Model model) {

        // TODO: 25/11/2020 Validation- what to do when the user entered in the url is not  
        List<Form> form;
        Optional<User> ausername = userService.findUserByUsername(username.get());
        User aUser = ausername.get();
        form = formService.getAllFormsByUsername(aUser);

        //if (!username.isPresent()){

       // }
       // else {
       //     form = formService.getAllFormsByUsername();
       // }


        // find all forms by usernameID


     // if (username.isPresent()) {
     //     form = formService.findFormByUsername(username);
       // }
       // else {
            //reflections = FormService.findReflectionsByName(currentUser.username)
        //   form = formService.getAllForms();
       // }

        model.addAttribute("forms", form);

        return "reflection-list";

    }

    @GetMapping("/reflection/{formID}")
    public String allGreetings(@PathVariable(name = "formID", required = true) String formID, Model model) {

        //Replace this with getFormbyFormID soon
        model.addAttribute("form", formService.getAllForms().get(0));

        return "form-view";

    }

}
