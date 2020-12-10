package com.nsa.group6.service;

import com.nsa.group6.domain.Form;
import com.nsa.group6.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FormService {
    public void saveForm(Form aForm);

    public void updateForm(Form aForm);

    public void deleteForm(int id);

    List<Form> getAllFormsByUsername(User username);

    Form getFormByID(int formID);

    List<Form> getRecent(User aUsername);

    List<Form> getIncomplete(User aUsername);


    // TODO: 24/11/2020  order by tag/ orderby event type, Ukspsf element group,
//    public List<Form> findFormsByMostRecent();
//

//
//    public Optional<Form> findFormsById(Long id);
//
}
