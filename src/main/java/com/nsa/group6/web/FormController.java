package com.nsa.group6.web;


import com.nsa.group6.domain.*;
import com.nsa.group6.jpa.MyUserDetails;
import com.nsa.group6.service.FormService;
import com.nsa.group6.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import com.nsa.group6.domain.Form;
import com.nsa.group6.domain.SubmittingForm;
import com.nsa.group6.domain.Tags;
import com.nsa.group6.jpa.FormRepoJPA;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;


@Controller
public class FormController {



    private final FormService formService;
    private final UserService userService;

    @Autowired
    FormRepoJPA formRepo;


    public FormController(FormService formService, UserService userService) {
        this.formService = formService;
        this.userService = userService;
    }



    @GetMapping("form")
    public String runForm(Model model) {

        List<Tags> allTags = formRepo.findAll();

        List<Tags> othersInvolved = new ArrayList<>();
        List<Tags> impact = new ArrayList<>();
        List<Tags> learningTechnologies = new ArrayList<>();
        List<Tags> thoughtCloud = new ArrayList<>();

        for (Tags allTag : allTags) {
            String whichCategory = allTag.getCategory();
            Tags addingTag = allTag;

            if ("Others Involved".equals(whichCategory)) {
                othersInvolved.add(addingTag);
            } else if ("Impact".equals(whichCategory)) {
                impact.add(addingTag);
            } else if ("Learning Technologies".equals(whichCategory)) {
                learningTechnologies.add(addingTag);
            } else if ("Thought Cloud".equals(whichCategory)) {
                thoughtCloud.add(addingTag);
            } else {
            }
        }

        SubmittingForm submittingForm = new SubmittingForm();

        model.addAttribute("form", submittingForm);
        model.addAttribute("othersInvolved", othersInvolved);
        model.addAttribute("impact", impact);
        model.addAttribute("learningTechnologies", learningTechnologies);
        model.addAttribute("thoughtCloud", thoughtCloud);

        return "form";
    }



    @PostMapping("form")
    public String submitForm(@ModelAttribute("form") SubmittingForm aSubmittingForm, BindingResult bindings, Model model) {


        if (bindings.hasErrors()) {
            System.out.println("Errors:" + bindings.getFieldErrorCount());
            for (ObjectError oe : bindings.getAllErrors()) {
                System.out.println(oe);
            }
            return "form";
        }
        else {


            model.addAttribute("aForm", aSubmittingForm);

            return "formtest";
        }
    }



    //This function retrieves the list of reflections by username
    @GetMapping("/reflection/user")
    public String getFormsByUsername( Model model) {

        // TODO: 25/11/2020 Validation- what to do when the user entered in the url is not in the db.
        // If the username is left blank then take it to the page of the signed in user.
        List<Form> form;

        User userDetails = getCurrentUser();

        // getUsername() - Returns the username used to authenticate the user.
        System.out.println("User name: " + userDetails.getUsername());


        form = formService.getAllFormsByUsername(userDetails);

        model.addAttribute("forms", form);

        return "reflection-list";

    }

    //This function retrieves a form by the ID selected.
    @GetMapping("/reflection/{formID}")
    public String getFormByID(@PathVariable(name = "formID", required = true) int formID, Model model) {
    // TODO: 26/11/2020 Validation- what to do when the formID entered in the url is not in the db.
        //Replace this with getFormbyFormID soon
        model.addAttribute("form", formService.getFormByID(formID));

        return "form-view";

    }


    public User getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Optional<User> ausername = userService.findUserByUsername(userDetails.getUsername());
        User aUser = ausername.get();

        return aUser;
    }


}




