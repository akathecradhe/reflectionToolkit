package com.nsa.group6.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int formID;

    @ManyToOne
    @JoinColumn(name= "eventID")
    private Event eventID;

    private String shortDescription;

    @ManyToOne
    @JoinColumn(name= "username")
    private User username;

    @ManyToOne
    @JoinColumn(name= "roleID")
    private Role roleID;

    @ManyToOne
    @JoinColumn(name= "reflectionID")
    private Reflection reflectionID;

    private Timestamp lastEdited;

    @ManyToMany
    @JoinTable(name = "Tagform"
            , joinColumns = @JoinColumn(name = "formID"),
            inverseJoinColumns = @JoinColumn(name = "TagID"))
    private List<Tags> tags;


    //Allows for you to search by tag category
    public List<Tags> getTagsByCategory(final String category) {
        return tags
                .stream()
                .filter(a -> tagMatch(a, category))
                .collect(Collectors.toList());
    }


    private static boolean tagMatch(Tags tag, String category) {
        return tag.getCategory().equals(category);
    }
}


