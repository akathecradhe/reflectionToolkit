package com.nsa.group6.web;

import com.nsa.group6.domain.Event;
import com.nsa.group6.domain.*;
import com.nsa.group6.service.FormService;
import com.nsa.group6.service.UserService;
import com.nsa.group6.service.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.Timestamp;

import java.util.List;
import java.util.Optional;
import com.nsa.group6.domain.Form;
import com.nsa.group6.domain.SubmittingForm;
import com.nsa.group6.domain.Tags;


import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;


@Controller
public class FormController {

    private final FormService formService;
    private final UserService userService;
    private final FormHandler formHandler;
    private final TagsService tagsService;
    private final RoleService roleService;
    private final EventService eventService;
    private final ReflectionService reflectionService;

    public FormController(FormService formService, UserService userService, FormHandler formHandler, TagsService tagsService, RoleService roleService, EventService eventService, ReflectionService reflectionService) {
        this.formService = formService;
        this.userService = userService;
        this.formHandler = formHandler;
        this.tagsService = tagsService;
        this.roleService = roleService;
        this.eventService = eventService;
        this.reflectionService = reflectionService;
    }



    @GetMapping("form")
    public String runForm(Model model) {
        return getString(model);
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

            Reflection reflectionInput = new Reflection(aSubmittingForm.box1, aSubmittingForm.box2, aSubmittingForm.box3, aSubmittingForm.box4,
                    aSubmittingForm.box5, aSubmittingForm.box6, aSubmittingForm.learningPoint1, aSubmittingForm.learningPoint2, aSubmittingForm.learningPoint3);

            reflectionService.save(reflectionInput);

            List<Integer> allTags = new ArrayList<Integer>();
            if(aSubmittingForm.impact != null) {
                allTags.addAll(aSubmittingForm.impact);
            }
            if(aSubmittingForm.others != null) {
                allTags.addAll(aSubmittingForm.others);
            }
            if(aSubmittingForm.thoughtCloud != null) {
                allTags.addAll(aSubmittingForm.thoughtCloud);
            }
            if(aSubmittingForm.learningTechs != null) {
                allTags.addAll(aSubmittingForm.learningTechs);
            }
            if(aSubmittingForm.dimensions != null) {
                allTags.addAll(aSubmittingForm.dimensions);
            }
            User userInput = getCurrentUser();
            List<Tags> tagsInput = tagsService.findAllTagsByID(allTags);
            Role roleInput = roleService.getRoleByID(aSubmittingForm.role).get();
            Event eventInput = eventService.getEventByID(aSubmittingForm.eventType).get();
            String descInput = aSubmittingForm.shortDesc;
            Timestamp lastEditedInput = new Timestamp(System.currentTimeMillis());
            Form form1 = new Form(eventInput, descInput, userInput, roleInput, reflectionInput, lastEditedInput, tagsInput);

            if (aSubmittingForm.formID != null) {
                form1 = new Form(aSubmittingForm.formID, eventInput, descInput, userInput, roleInput, reflectionInput, lastEditedInput, tagsInput);
            }

            formService.saveForm(form1);
            model.addAttribute("tagsEdit", allTags);
            model.addAttribute("roleEdit", roleInput);
            model.addAttribute("eventEdit", eventInput);
            model.addAttribute("descEdit", form1);
            model.addAttribute("reflectionEdit", reflectionInput);

            return getFormsByUsername(model);
        }
    }

    private String getString(Model model) {
        List<Tags> allTags = tagsService.getAllTags();

        List<Tags> othersInvolved = new ArrayList<Tags>();
        List<Tags> impact = new ArrayList<Tags>();
        List<Tags> learningTechnologies = new ArrayList<Tags>();
        List<Tags> thoughtCloud = new ArrayList<Tags>();
        List<Tags> dimensions = new ArrayList<Tags>();

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
            } else if ("UKPSF".equals(whichCategory)){
                dimensions.add(addingTag);
            }
            else{}

        }

        List<Role> role = roleService.getAllRoles();
        List<Event> event = eventService.getAllEvent();

        SubmittingForm submittingForm = new SubmittingForm();

        model.addAttribute("event", event);
        model.addAttribute("role", role);
        model.addAttribute("form", submittingForm);
        model.addAttribute("othersInvolved", othersInvolved);
        model.addAttribute("impact", impact);
        model.addAttribute("learningTechnologies", learningTechnologies);
        model.addAttribute("thoughtCloud", thoughtCloud);
        model.addAttribute("dimensions", dimensions);

        return "form";
    }


    //This function retrieves the list of reflections by username
    @GetMapping("/reflection/user")
    public String getFormsByUsername( Model model) {

        // TODO: 25/11/2020 Validation- what to do when the user entered in the url is not in the db.
        // If the username is left blank then take it to the page of the signed in user.

        List<Form> form;

        User userDetails = getCurrentUser();

        // getUsername() - Returns the username used to authenticate the user.
        System.out.println("User name: " + userDetails.getUsername());


        form = formService.getAllFormsByUsername(userDetails);

        FiltersForm filters = new FiltersForm();

        //Gets the tags for filters
        model.addAttribute("othersInvolved", formHandler.findTagsByCategory("Others Involved"));
        model.addAttribute("impact", formHandler.findTagsByCategory("Impact"));
        model.addAttribute("learningTechnologies", formHandler.findTagsByCategory("Learning Technologies"));
        model.addAttribute("thoughtCloud", formHandler.findTagsByCategory("Thought Cloud"));
        model.addAttribute("ukpsf", formHandler.findTagsByCategory("UKPSF"));
        model.addAttribute("user", userDetails);
        model.addAttribute("forms", form);
        model.addAttribute("filters",filters);

        return "reflection-list";

    }

    @GetMapping("/reflectionedit/{formID}")
    public String editForm(@PathVariable(name = "formID", required = true) int formID, Model model){
        Form editingForm = formService.getFormByID(formID);

        editingForm.getTags();

        List<Integer> allTags = new ArrayList<Integer>();

        for (int i = 0; i < editingForm.getTags().size(); i++) {
            allTags.add(editingForm.getTags().get(i).getTagID());
        }

        Event eventInput = editingForm.getEventID();
        Role roleInput = editingForm.getRoleID();
        Reflection reflectionInput = editingForm.getReflectionID();

        model.addAttribute("tagsEdit", allTags);
        model.addAttribute("roleEdit", roleInput);
        model.addAttribute("eventEdit", eventInput);
        model.addAttribute("descEdit", editingForm);
        model.addAttribute("reflectionEdit", reflectionInput);
        model.addAttribute("formID", formID);

        return getString(model);
    }

    //This function retrieves a form by the ID selected.
    @GetMapping("/reflection/{formID}")
    public String getFormByID(@PathVariable(name = "formID", required = true) int formID, Model model) {
    // TODO: 26/11/2020 Validation- what to do when the formID entered in the url is not in the db.
        //Replace this with getFormbyFormID soon
        model.addAttribute("form", formService.getFormByID(formID));
        return "form-view";

    }

    @PostMapping("reflections")
    public String submitFilters(@ModelAttribute("filters") FiltersForm filtersForm, Model model) {

        User aUser = getCurrentUser();
        List<Form> forms = formHandler.findFormsByMatchingTagIDs(filtersForm.tags,aUser.getUsername());

        FiltersForm filters = new FiltersForm();
        //Gets the tags for filters
        model.addAttribute("othersInvolved", formHandler.findTagsByCategory("Others Involved"));
        model.addAttribute("impact", formHandler.findTagsByCategory("Impact"));
        model.addAttribute("learningTechnologies", formHandler.findTagsByCategory("Learning Technologies"));
        model.addAttribute("thoughtCloud", formHandler.findTagsByCategory("Thought Cloud"));
        model.addAttribute("ukpsf", formHandler.findTagsByCategory("UKPSF"));
        model.addAttribute("user", aUser);
        model.addAttribute("forms", forms);
        model.addAttribute("filters",filters);

        return "reflection-list";
    }


    @GetMapping("/home")
    public String getHomeData(Model model) {

        // TODO: 25/11/2020 Validation- what to do when the user entered in the url is not in the db.
        // If the username is left blank then take it to the page of the signed in user.;

        User aUser = getCurrentUser();

        model.addAttribute("user",aUser);

        return "home";
    }



    public User getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Optional<User> ausername = userService.findUserByUsername(userDetails.getUsername());
        User aUser = ausername.get();

        return aUser;
    }


}




