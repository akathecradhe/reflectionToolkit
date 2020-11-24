package com.nsa.group6.web;
import com.nsa.group6.domain.Tags;
import com.nsa.group6.jpa.FormRepoJPA;
import com.nsa.group6.jpa.FormRepoJPAAdaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FormController {

    @Autowired FormRepoJPA formRepo;

    @GetMapping("form")
    public String runForm(Model model) {

//        List<Tags> allTags = formRepo.findAll();
//
//        List<Tags> othersInvolved = null;
//        List<Tags> impact = null;
//        List<Tags> learningTechnologies = null;
//        List<Tags> thoughtCloud = null;
//
//        for (int i = 0; i < allTags.size(); i++){
//            String whichCategory = allTags.get(i).getCategory();
//            Tags addingTag = allTags.get(i);
//
//            if (whichCategory.equals("Others Involved")) {
//                othersInvolved.add(addingTag);
//            }
//            else if (whichCategory.equals("Impact")) {
//                impact.add(addingTag);
//            }
//            else if (whichCategory.equals("Learning Technologies")) {
//                learningTechnologies.add(addingTag);
//            }
//            else if (whichCategory.equals("Thought Cloud")) {
//                thoughtCloud.add(addingTag);
//            }
//            else {}
//
//        }
//
//        allTags.get(0).getCategory();
//
//        model.addAttribute("othersInvolved", othersInvolved);
//        model.addAttribute("impact", impact);
//        model.addAttribute("learningTechnologies", learningTechnologies);
//        model.addAttribute("thoughtCloud", thoughtCloud);

        return "form";
    }
}
