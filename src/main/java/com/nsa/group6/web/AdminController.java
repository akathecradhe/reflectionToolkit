package com.nsa.group6.web;

import com.nsa.group6.domain.Tags;
import com.nsa.group6.service.TagService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class AdminController {

    private final TagService tagService;

    public AdminController(TagService tagService) {
        this.tagService = tagService;
    }

    // admin
    @GetMapping("/admin/edit-tags")

    public String getAllThoughtClouds(Model model) {

        List<Tags> allThoughtClouds = tagService.getTagByCategory("Thought Cloud");
        System.out.println(allThoughtClouds);
        model.addAttribute("ThoughtTags",allThoughtClouds);

        return "admintags";
    }

    @PostMapping("/addNew")
    public String addThoughtCloud(Tags tag){

        return  "redirect:/admintags";
    }




}
