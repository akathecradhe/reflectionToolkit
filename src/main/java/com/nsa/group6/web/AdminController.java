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

/**
 * Worked on by Brian and Clive
 */
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
        model.addAttribute("ThoughtTags",allThoughtClouds);

        return "admintags";
    }

    @PostMapping("/addNew")
    public String addThoughtCloud(Model model,
                                  @RequestParam String
                                          tagNameAdd) throws Exception {

        List<Tags> allTags = tagsService.getAllTags();

        Tags newThought  = new Tags(tagNameAdd);

       tagsService.saveTags(newThought);


         return getAllThoughtClouds(model);
    }

//    This function deletes a tag
    @DeleteMapping("/deletetag/{tagID}")
    public ResponseEntity<String> deleteTagByID(@PathVariable(name = "tagID", required = true) int tagID, Model model) {
        tagService.deleteTag(tagID);


        return ResponseEntity.noContent().build();

    }






}
