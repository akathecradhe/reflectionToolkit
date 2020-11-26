package com.nsa.group6.repositories;

import com.nsa.group6.domain.Form;

import com.nsa.group6.domain.User;
import com.nsa.group6.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormJPAadptor implements FormService {


    @Autowired
    private final FormRepository formRepository;


    public FormJPAadptor(FormRepository formRepository) {
        this.formRepository = formRepository;
    }

    @Override
    public void saveForm(Form x) {
         formRepository.save(x);
    }

    @Override
    public void updateForm(Form aForm) {

    }

    @Override
    public void deleteForm(Long id) {

    }

    @Override
    public List<Form> getAllFormsByUsername(User aUsername) {

        return formRepository.findAllByUsername(aUsername);

    }

    @Override
    public Form getFormByID(int formID) {
        return formRepository.findByFormID(formID);
    }


    // TODO: 24/11/2020  order by tag/ orderby event type, Ukspsf element group,


//    @Override
//    public List<Form> findFormsByMostRecent() {
//        return null;
//    }

//    @Override
//    public List<Form> findFormsByName(String aName) {
//        return null;
//    }

//    @Override
//    public Optional<Form> findFormsByElement(Long id) {
//        return Optional.empty();
//    }
//

}