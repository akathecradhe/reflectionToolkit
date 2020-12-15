package com.nsa.group6.domain;

import com.nsa.group6.service.FormService;
import com.nsa.group6.service.TagService;
import com.nsa.group6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Component
public class DefaultFormHandler implements FormHandler {

    private final FormService formService;
    private final UserService userService;
    private final TagService tagService;

    @Autowired
    public DefaultFormHandler(FormService formService, UserService userService, TagService tagService) {
        this.formService = formService;
        this.userService = userService;
        this.tagService = tagService;
    }

    // Checks the tags provided and selects the forms that have matching tags.
    @Override
    public List<Form> findFormsByMatchingTags(List<Tags> tags, String aUser) {
        Optional<User> aUsername = userService.findUserByUsername(aUser);
        User user = aUsername.get();
        List<Form> forms = formService.getAllFormsByUsername(user);
        return forms
                .stream()
                .filter(a -> a.containsTags(tags))
                .collect(Collectors.toList());
    }

    @Override
    public List<Tags> findTagsByCategory(String category) {
        return tagService.getTagByCategory(category);
    }

    @Override
    public List<Form> filterByCompletionStatus(List<Form> forms, List<String> completionStatus) {
        return forms
                .stream()
                .filter(a -> completionStatus.contains(a.getCompletionLevel()))
                .collect(Collectors.toList());
    }

    @Override
    public HashMap<Tags, Integer> findAllUKPSFStats(User user) {
        List<Tags> ukpsf = tagService.getTagByCategory("ukpsf");
        HashMap<Tags, Integer> ukspfCount = new HashMap<>();
        if (user.getRoles().equals("ADMIN")){
            for (Tags tag: ukpsf) {
                ukspfCount.put(tag,formService.getTotalTagCount(tag));
            }
        } else{
            for (Tags tag: ukpsf) {
                ukspfCount.put(tag,formService.getTotalTagCountByUser(tag,user));
            }
        }
        return ukspfCount;
    }


    @Override
    public List<Form> findFormsByMatchingTagIDs(List<Integer> tagIDs, String aUser) {
        List<Tags> tags = tagIDs
                .stream()
                .map(s -> tagService.getTagByID(s))
                .collect(Collectors.toList());
        return findFormsByMatchingTags(tags, aUser);
    }

}
