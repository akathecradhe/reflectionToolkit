package com.nsa.group6.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

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
}


