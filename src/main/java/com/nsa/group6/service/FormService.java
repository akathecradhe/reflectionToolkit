package com.nsa.group6.service;

import com.nsa.group6.domain.Form;
import com.nsa.group6.domain.User;

import java.util.List;
import java.util.Optional;

public interface FormService {
    public void saveForm(Form aForm);

    public void updateForm(Form aForm);

    public void deleteForm(Long id);

    List<Form> getAllFormsByUsername(User username);


    List<Form> getAllForms(int aId);




    // TODO: 24/11/2020  order by tag/ orderby event type, Ukspsf element group,
//    public List<Form> findFormsByMostRecent();
//

//
//    public Optional<Form> findFormsById(Long id);
//
}
