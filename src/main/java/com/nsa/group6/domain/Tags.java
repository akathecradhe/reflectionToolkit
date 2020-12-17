package com.nsa.group6.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Tags {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int tagID;
    private String category;
    private String tagName;
    private String shortenedTag;
    private String description;

//    @ManyToMany(mappedBy = "tags")
//    Set<Form> connect;

    public Tags(int tagID, String category, String tagName) throws Exception {
        this.tagID = tagID;
        this.category = category;
        this.tagName = tagName;

        if (category.equals("UKPSF")) {
            throw new IllegalStateException("Cannot use this category with these parameters.");
        }
    }

    public Tags(int tagID, String category, String tagName, String shortenedTag, String description) throws Exception {
        this.tagID = tagID;
        this.category = category;
        this.tagName = tagName;
        this.shortenedTag = shortenedTag;
        this.description = description;

        if (!category.equals("UKPSF")) {
            throw new IllegalStateException("Cannot use this category with these parameters.");
        }
    }

    public Tags(String tagName) {
        this.tagName = tagName;
        category = "Thought Cloud";
    }
}


