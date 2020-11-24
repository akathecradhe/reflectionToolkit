package com.nsa.group6.jpaservice;

import com.nsa.group6.domain.Form;

import com.nsa.group6.domain.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormJPAadptor implements FormService {


    @Autowired
    private final FormRepoJPA formRepoJPA;


    public FormJPAadptor(FormRepoJPA formRepoJPA) {
        this.formRepoJPA = formRepoJPA;
    }

    @Override
    public void saveForm(Form x) {
        formRepoJPA.save(x);
    }

    @Override
    public void updateForm(Form aForm) {

    }

    @Override
    public void deleteForm(Long id) {

    }

    @Override
    public List<Form> getAllForms() {
        return formRepoJPA.findAll();
    }

    // TODO: 24/11/2020  order by tag/ orderby event type, Ukspsf element group,

//
//    @Override
//    public List<Form> findFormsByMostRecent() {
//        return null;
//    }
//
//    @Override
//    public List<Form> findFormsByName(String aName) {
//        return null;
//    }
//
//    @Override
//    public Optional<Form> findFormsByCategory(Long id) {
//        return Optional.empty();
//    }
//
//    @Override
//    public Optional<Form> findFormsById(Long id) {
//        return Optional.empty();
//    }
}
