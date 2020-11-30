package com.nsa.group6.web;


import com.nsa.group6.domain.Form;
import com.nsa.group6.domain.SubmittingForm;
import com.nsa.group6.domain.Tags;
import com.nsa.group6.domain.User;
import com.nsa.group6.jpa.FormRepoJPA;
import com.nsa.group6.service.FormService;
import com.nsa.group6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
public class UserController {



    private final FormService formService;
    private final UserService userService;

    @Autowired
    FormRepoJPA formRepo;


    public UserController(FormService formService, UserService userService) {
        this.formService = formService;
        this.userService = userService;
    }



    @GetMapping("/login")
    public String login() {

        return "home";
    }


    @PostMapping("/logout")
    public String logout() {


            return "login";

    }


}




