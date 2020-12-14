package com.nsa.group6.repositories;

import com.nsa.group6.domain.ActionPoints;
import com.nsa.group6.domain.Event;
import com.nsa.group6.domain.Form;
import com.nsa.group6.domain.User;
import com.nsa.group6.service.APService;
import com.nsa.group6.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class APJPAAdaptor implements APService {


    private final APRepository apRepository;

    @Autowired
    public APJPAAdaptor(APRepository apRepository) {
        this.apRepository = apRepository;
    }

//    @Autowired
//    private final FormRepository formRepository;
//
//
//    public FormJPAAdaptor(FormRepository formRepository) {
//        this.formRepository = formRepository;
//    }

    @Override
    public void saveAction(ActionPoints aAction) {
        apRepository.save(aAction);
    }

    @Override
    public void updateAction(ActionPoints aAction) {

    }

    @Override
    public List<ActionPoints> getAllActionsByUsername(User aUsername) {
        return apRepository.findAllByUsername(aUsername, Sort.by(Sort.Direction.DESC, "actionID"));
    }

    @Override
    public List<ActionPoints> getRecent(User aUsername) {

        List<ActionPoints> aPoints = apRepository.findAllByUsername(aUsername, Sort.by(Sort.Direction.ASC, "actionID"));

        List<ActionPoints> aPoints2 = new ArrayList<>();

        if (aPoints.size() > 2) {
            ActionPoints aPoint = aPoints.get(aPoints.size() - 1);
            ActionPoints aPoint2 = aPoints.get(aPoints.size() - 2);
            ActionPoints aPoint3 = aPoints.get(aPoints.size() - 3);
            aPoints2.add(aPoint);
            aPoints2.add(aPoint2);
            aPoints2.add(aPoint3);
        }
        else if (aPoints.size() == 2) {
            ActionPoints aPoint = aPoints.get(aPoints.size() - 1);
            ActionPoints aPoint2 = aPoints.get(aPoints.size() - 2);
            aPoints2.add(aPoint);
            aPoints2.add(aPoint2);
        }
        else if (aPoints.size() == 1) {
            ActionPoints aPoint = aPoints.get(aPoints.size() - 1);
            aPoints2.add(aPoint);
        }
        else {
        }

        return aPoints2;
    }

    @Override
    public Optional<ActionPoints> getActionByID(int actionID) {
        return apRepository.findById(actionID);
    }
}
