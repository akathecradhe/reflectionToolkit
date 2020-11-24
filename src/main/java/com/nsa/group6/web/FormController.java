package com.nsa.group6.web;
import com.nsa.group6.domain.Event;
import com.nsa.group6.domain.Form;
import com.nsa.group6.domain.TestForm;
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

    @GetMapping("form")
    public String runForm(Model model) {

        model.addAttribute("event", "name");

        return "form";
    }

    @GetMapping("reflections/{username}")
    public String allGreetings(@PathVariable(name = "username", required = false) Optional<String> username, Model model) {

//        if (username.isPresent()) {
            //reflections = formRetriever.findReflectionsByName(username)
//        } else {
            //reflections = formRetriever.findReflectionsByName(currentUser.username)
//        }
        TestForm form1 = new TestForm("Design Or Plan", "DESCRIPTION HERE REEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE","21/11/2020","22/11/2020 11:34");
        System.out.println(form1.getEventDate());
        model.addAttribute("form1", form1);

        return "reflection-list";

    }

}
