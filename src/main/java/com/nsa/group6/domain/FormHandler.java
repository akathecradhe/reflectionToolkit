package com.nsa.group6.domain;

import java.util.HashMap;
import java.util.List;

/**
 * Worked on by Tom
 */
public interface FormHandler {
    HashMap<Tags, Integer> findAllThoughtCloudStats();

    List<Form> findFormsByMatchingTagIDs(List<Integer> tagIDs, String aUser);
    List<Form> findFormsByMatchingTags(List<Tags> tags, String aUser);

    List<Tags> findTagsByCategory(String category);

    List<Form> filterByCompletionStatus(List<Form> forms, List<String> completionStatus);

    HashMap<Tags, Integer> findAllUKPSFStats(User user);

    HashMap<Tags, Integer> getOrderedUKPSF(User aUser);

    HashMap<Tags, Integer> findOrderedThoughtCloudStats();
}
