package com.nsa.group6;

import com.nsa.group6.domain.*;
import org.junit.jupiter.api.Test;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DomainTests {

    @Test
    public void UKPSF_IncorrectConstructor() throws Exception {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            new Tags(123,"UKPSF","Teaching Name");
        });
    }

    @Test
    public void Tag_IncorrectConstructor() throws Exception {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            new Tags(123,"Teaching","Teaching Name","A1","Description...");
        });
    }

    @Test
    public void Tag_And_UKPSF_LegalConstructor() throws Exception {
        Tags ukpsf = new Tags(123,"UKPSF","Teaching Name","A1","Description...");
        Tags tag = new Tags(123,"teaching","Teaching Name");
    }

    @Test
    public void traffic_lights_UKPSF_complete() {
        Event event = new Event(1,"Test Event");
        User user = new User("rowbo","Tom Rowbotham",new Date(5000));
        Role role = new Role(1,"Test role");
        List<Tags> tags = null;
        try {
            tags = Arrays.asList(new Tags(1,"UKPSF","Test tag","A1","Test tag desc"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        DateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
        Date activityDate = null;
        try {
            activityDate = formatter.parse("23/07/2001");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Form form = new Form(event,"Test event", user, role, new Timestamp(5000),tags,activityDate);
        assertEquals("amber",form.getCompletionLevel());
    }

    @Test
    public void traffic_lights_all_complete() {
        Event event = new Event(1,"Test Event");
        User user = new User("rowbo","Tom Rowbotham",new Date(5000));
        Role role = new Role(1,"Test role");
        List<Tags> tags = null;
        try {
            tags = Arrays.asList(new Tags(1,"UKPSF","Test tag","A1","Test tag desc"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        DateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
        Date activityDate = null;
        try {
            activityDate = formatter.parse("23/07/2001");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Reflection reflection = new Reflection(1,"test","test","test","test","test","test","test","test","test");
        Form form = new Form(event,"Test event", user, role, reflection, new Timestamp(5000),tags,activityDate);
        assertEquals("green",form.getCompletionLevel());
    }

    @Test
    public void traffic_lights_reflection_complete() {
        Event event = new Event(1,"Test Event");
        User user = new User("rowbo","Tom Rowbotham",new Date(5000));
        Role role = new Role(1,"Test role");
        List<Tags> tags = null;
        try {
            tags = Arrays.asList(new Tags(1,"Other Category","Test tag"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        DateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
        Date activityDate = null;
        try {
            activityDate = formatter.parse("23/07/2001");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Reflection reflection = new Reflection(1,"test","test","test","test","test","test","test","test","test");
        Form form = new Form(event,"Test event", user, role, reflection, new Timestamp(5000),tags,activityDate);
        assertEquals("amber",form.getCompletionLevel());
    }

    @Test
    public void traffic_lights_none_complete() {
        Event event = new Event(1,"Test Event");
        User user = new User("rowbo","Tom Rowbotham",new Date(5000));
        Role role = new Role(1,"Test role");
        List<Tags> tags = null;
        try {
            tags = Arrays.asList(new Tags(1,"Other Category","Test tag"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        DateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
        Date activityDate = null;
        try {
            activityDate = formatter.parse("23/07/2001");
        } catch (ParseException e) {
            e.printStackTrace();
        }
               Form form = new Form(event,"Test event", user, role, new Timestamp(5000),tags,activityDate);
        assertEquals("red",form.getCompletionLevel());
    }
}
