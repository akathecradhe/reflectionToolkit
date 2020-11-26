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
import com.nsa.group6.domain.Form;
import com.nsa.group6.domain.Tags;
import com.nsa.group6.jpa.FormRepoJPA;
import com.nsa.group6.jpa.FormRepoJPAAdaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FormController {


    private final FormService formService;
    private final UserService userService;
    @Autowired FormRepoJPA formRepo;

    public FormController(FormService formService, UserService userService) {
        this.formService = formService;
        this.userService = userService;
    }



    @GetMapping("form")
    public String runForm(Model model) {

        List<Tags> allTags = formRepo.findAll();

        List<Tags> othersInvolved = new ArrayList<Tags>();
        List<Tags> impact = new ArrayList<Tags>();
        List<Tags> learningTechnologies = new ArrayList<Tags>();
        List<Tags> thoughtCloud = new ArrayList<Tags>();

        for (int i = 0; i < allTags.size(); i++){
            String whichCategory = allTags.get(i).getCategory();
            Tags addingTag = allTags.get(i);

            if ("Others Involved".equals(whichCategory)) {
                othersInvolved.add(addingTag);
            }
            else if ("Impact".equals(whichCategory)) {
                impact.add(addingTag);
            }
            else if ("Learning Technologies".equals(whichCategory)) {
                learningTechnologies.add(addingTag);
            }
            else if ("Thought Cloud".equals(whichCategory)) {
                thoughtCloud.add(addingTag);
            }
            else {}
        }

        model.addAttribute("othersInvolved", othersInvolved);
        model.addAttribute("impact", impact);
        model.addAttribute("learningTechnologies", learningTechnologies);
        model.addAttribute("thoughtCloud", thoughtCloud);

        return "form";
    }

    @GetMapping("/reflections/{username}")
    public String getFormsByUsername(@PathVariable(name = "username", required = false) Optional<String> username, Model model) {

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
    public String getFormByID(@PathVariable(name = "formID", required = true) int formID, Model model) {

        //Replace this with getFormbyFormID soon
        model.addAttribute("form", formService.getFormByID(formID));

        return "form-view";

    }

}
