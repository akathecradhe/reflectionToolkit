package com.nsa.group6.domain;

import com.nsa.group6.service.FormService;
import com.nsa.group6.service.TagService;
import com.nsa.group6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
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
        System.out.println(user);
        List<Form> forms = formService.getAllFormsByUsername(user);
        System.out.println(forms);
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
        List<Tags> ukpsf = tagService.getTagByCategory("UKPSF");
        HashMap<Tags, Integer> ukspfCount = new HashMap<>();
        if (user.getRoles().equals("ADMIN")){
            for (Tags tag: ukpsf) {
                ukspfCount.put(tag,formService.getTotalTagCount(tag));
            }
        } else{
            for (Tags tag: ukpsf) {
                System.out.println(formService.getTotalTagCountByUser(tag,user));
                ukspfCount.put(tag,formService.getTotalTagCountByUser(tag,user));
            }
        }
        return ukspfCount;
    }

    @Override
    public HashMap<Tags, Integer> getOrderedUKPSF(User aUser) {
        //Getting the UKPSF Stats - code adapted from https://www.geeksforgeeks.org/sorting-a-hashmap-according-to-values/
        HashMap<Tags,Integer> ukpsfStats = findAllUKPSFStats(aUser);
        List<Map.Entry<Tags, Integer> > list =
                new LinkedList<Map.Entry<Tags, Integer> >(ukpsfStats.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Tags, Integer> >() {
            public int compare(Map.Entry<Tags, Integer> o1,
                               Map.Entry<Tags, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        HashMap<Tags, Integer> orderedUkpsfStats = new LinkedHashMap<Tags, Integer>();
        for (Map.Entry<Tags, Integer> aa : list) {
            orderedUkpsfStats.put(aa.getKey(), aa.getValue());
        }
        return orderedUkpsfStats;
    }

    @Override
    public HashMap<Tags, Integer> findOrderedThoughtCloudStats() {
        HashMap<Tags, Integer> thoughtStats = findAllThoughtCloudStats();
        List<Map.Entry<Tags, Integer> > list2 =
                new LinkedList<Map.Entry<Tags, Integer> >(thoughtStats.entrySet());
        Collections.sort(list2, new Comparator<Map.Entry<Tags, Integer> >() {
            public int compare(Map.Entry<Tags, Integer> o1,
                               Map.Entry<Tags, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        HashMap<Tags, Integer> orderedthoughtStats = new LinkedHashMap<Tags, Integer>();
        for (Map.Entry<Tags, Integer> aa : list2) {
            orderedthoughtStats.put(aa.getKey(), aa.getValue());
        }
        return orderedthoughtStats;

    }

    @Override
    public HashMap<Tags, Integer> findAllThoughtCloudStats() {
        List<Tags> thoughtCloud = tagService.getTagByCategory("Thought Cloud");
        HashMap<Tags, Integer> thoughtCount = new HashMap<>();
            for (Tags tag: thoughtCloud) {
                thoughtCount.put(tag, formService.getTotalTagCount(tag));
            }

        return thoughtCount;
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
