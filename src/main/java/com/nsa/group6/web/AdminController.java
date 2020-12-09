package com.nsa.group6.web;

import com.nsa.group6.domain.Tags;
import com.nsa.group6.repositories.TagsRepository;
import com.nsa.group6.service.TagService;
import com.nsa.group6.service.TagsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;


import java.util.List;


@Controller
public class AdminController {


    private final TagsService tagsService;
    private final TagService tagService;

    public AdminController(TagService tagService, TagsService tagsService, TagsRepository tagsRepository) {
        this.tagsService = tagsService;
        this.tagService = tagService;

    }

    // admin
    @GetMapping("/admin/edit-tags")

    public String getAllThoughtClouds(Model model) {

        List<Tags> allThoughtClouds = tagsService.getTagByCategory("Thought Cloud");
        System.out.println(allThoughtClouds);
        model.addAttribute("ThoughtTags",allThoughtClouds);

        return "admintags";
    }

    @RequestMapping("/addNew")
    public String addThoughtCloud(Model model,
                                  @RequestParam String
                                          tagNameAdd) throws Exception {

        System.out.println(tagNameAdd);

        List<Tags> allTags = tagsService.getAllTags();

        int latestTagId = allTags.size()+1;

        Tags newThought  = new Tags(latestTagId,"Thought Cloud",tagNameAdd);

       tagsService.saveTags(newThought);

        getAllThoughtClouds(model);


         return "admintags";
    }

//    This function deletes a tag
    @PostMapping("/deletetag/{tagID}")
    public ResponseEntity<String> deleteTagByID(@PathVariable(name = "tagID", required = true) int tagID, Model model) {
        tagService.deleteTag(tagID);


        return ResponseEntity.noContent().build();

    }






}
