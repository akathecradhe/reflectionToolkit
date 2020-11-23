package com.nsa.group6.web;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormController {

    @GetMapping("form")
    public String runForm(Model model) {

        model.addAttribute("event", "name");

        return "form";
    }
}
