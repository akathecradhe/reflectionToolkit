package com.nsa.group6.repositories;

import com.nsa.group6.domain.Form;

import com.nsa.group6.domain.User;
import com.nsa.group6.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FormJPAAdaptor implements FormService {


    @Autowired
    private final FormRepository formRepository;


    public FormJPAAdaptor(FormRepository formRepository) {
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
    public void deleteForm(int id) {
        formRepository.deleteById(id);
    }

    @Override
    public List<Form> getAllFormsByUsername(User aUsername) {

        //String stringUsername = aUsername.toString();

        return formRepository.findAllByUsername(aUsername, Sort.by(Sort.Direction.DESC, "lastEdited"));

    }

    @Override
    public Form getFormByID(int formID) {
        return formRepository.findByFormID(formID);
    }

    @Override
    public List<Form> getRecent() {


        List<Form> aForms = formRepository.findAll(Sort.by(Sort.Direction.DESC, "lastEdited"));

        List<Form> aForms2 = new ArrayList<>();

        if (aForms.size() > 1) {
            Form aForm = aForms.get(aForms.size() - 1);
            Form aForm2 = aForms.get(aForms.size() - 2);
            aForms2.add(aForm);
            aForms2.add(aForm2);
        }
        else if (aForms.size() == 1) {
            Form aForm = aForms.get(aForms.size() - 1);
            aForms2.add(aForm);
        }
        else {

        }

        return aForms2;
    }

    @Override
    public List<Form> getIncomplete() {

        List<Form> aForms = formRepository.findAll();

        for (int i = 0; i < aForms.size(); i++) {
            String compLevel = aForms.get(i).getCompletionLevel();

            if (compLevel.equals("green")) {
                aForms.remove(i);
            }

        }

        return aForms;

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
