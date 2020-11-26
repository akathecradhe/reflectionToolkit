package com.nsa.group6.jpa;

import com.nsa.group6.domain.TagRead;
import com.nsa.group6.domain.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FormRepoJPAAdaptor implements TagRead {

    private FormRepoJPA formRepoJPA;

    @Autowired
    public FormRepoJPAAdaptor(FormRepoJPA aFormRepoJPA) {
        formRepoJPA = aFormRepoJPA;
    }

    @Override
    public List<Tags> findAll() {
        return formRepoJPA.findAll();
    }

}
