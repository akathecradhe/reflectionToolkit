package com.nsa.group6.web;
import com.nsa.group6.domain.Event;
import com.nsa.group6.domain.Form;
import com.nsa.group6.domain.SubmittingForm;
import com.nsa.group6.domain.Tags;
import com.nsa.group6.jpa.FormRepoJPA;
import com.nsa.group6.jpa.FormRepoJPAAdaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FormController {

    @Autowired
    FormRepoJPA formRepo;

//    @GetMapping("formtest")
//    public String readForm(Model model) {
//
//        model.addAttribute("form", aForm)
//
//
//
//        return "formtest";
//
//    }

    @GetMapping("form")
    public String runForm(Model model) {

        List<Tags> allTags = formRepo.findAll();

        List<Tags> othersInvolved = new ArrayList<Tags>();
        List<Tags> impact = new ArrayList<Tags>();
        List<Tags> learningTechnologies = new ArrayList<Tags>();
        List<Tags> thoughtCloud = new ArrayList<Tags>();

        for (int i = 0; i < allTags.size(); i++) {
            String whichCategory = allTags.get(i).getCategory();
            Tags addingTag = allTags.get(i);

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



}




