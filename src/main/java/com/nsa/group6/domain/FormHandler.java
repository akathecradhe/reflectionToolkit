package com.nsa.group6.domain;

import java.util.List;

public interface FormHandler {
    List<Form> findFormsByMatchingTagIDs(List<Integer> tagIDs, String aUser);
    List<Form> findFormsByMatchingTags(List<Tags> tags, String aUser);

    List<Tags> findTagsByCategory(String category);
}
