package com.nsa.group6.web;

import com.nsa.group6.domain.Tags;
import com.nsa.group6.service.TagService;
import com.nsa.group6.service.TagsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;


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

//    This function deletes a tag
    @PostMapping("/deletetag/{tagID}")
    public ResponseEntity<String> deleteTagByID(@PathVariable(name = "tagID", required = true) int tagID, Model model) {
        // TODO: 26/11/2020 Validation- what to do when the formID entered in the url is not in the db.
        tagService.deleteTag(tagID);


        return ResponseEntity.noContent().build();

    }






}
