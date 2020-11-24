package com.nsa.group6.web;
import com.nsa.group6.domain.Event;
import com.nsa.group6.domain.Form;
import com.nsa.group6.domain.FormService;
import com.nsa.group6.domain.TestForm;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class FormController {
    @Autowired
    private FormService formService;

    @GetMapping("form")
    public String runForm(Model model) {

        model.addAttribute("event", "name");

        return "form";
    }

    @GetMapping("/reflections/{username}")
    public String allGreetings(@PathVariable(name = "username", required = false) Optional<String> username, Model model) {

//        if (username.isPresent()) {
            //reflections = formRetriever.findReflectionsByName(username)
//        } else {
            //reflections = formRetriever.findReflectionsByName(currentUser.username)
//        }

        model.addAttribute("forms", formService.getAllForms());

        return "reflection-list";

    }

}
