package com.nsa.group6.domain;

import java.util.List;
import java.util.Optional;

public interface FormService {
    public void saveForm(Form aForm);

    public void updateForm(Form aForm);

    public void deleteForm(Long id);

    List<Form> getAllForms();


    // TODO: 24/11/2020  order by tag/ orderby event type, Ukspsf element group,
//    public List<Form> findFormsByMostRecent();
//
//    public List<Form> findFormsByName(String aName);
//
//    public Optional<Form> findFormsById(Long id);
//
}
