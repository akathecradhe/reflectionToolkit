package com.nsa.group6;

import com.nsa.group6.domain.Form;
import com.nsa.group6.domain.Tags;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

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

}
