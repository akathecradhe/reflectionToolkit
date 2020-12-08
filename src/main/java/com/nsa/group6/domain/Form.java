package com.nsa.group6.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.text.SimpleDateFormat;

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


    private Date activityDate;


    //This function returns the date object in the format wanted for the webpage. Previously printing the
    //event would include a timestamp of midnight.
    public String getDateString () {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(activityDate);

    }


    public String getLastEditedString() {
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(lastEdited);
    }

    //Allows for you to search by tag category
    public List<Tags> getTagsByCategory(final String category) {
        return tags
                .stream()
                .filter(a -> tagCategoryMatch(a, category))
                .collect(Collectors.toList());
    }


    private static boolean tagCategoryMatch(Tags tag, String category) {
        return tag.getCategory().equals(category);
    }

    //Does a loop through the filters and returns if form contains the exact same tags
    public boolean containsTags(List<Tags> filters) {
        return filters
                .stream()
                .filter(a -> containsTag(a))
                .collect(Collectors.toList())
                .size()
                == (filters.size());
    }

    public boolean containsTag(Tags tag) {
        return tags.contains(tag);
    }

    //Create a form without ID
    public Form(Event eventID, String shortDescription, User username, Role roleID, Reflection reflectionID, Timestamp lastEdited, List<Tags> tags, Date activityDate) {
        this.eventID = eventID;
        this.shortDescription = shortDescription;
        this.username = username;
        this.roleID = roleID;
        this.reflectionID = reflectionID;
        this.lastEdited = lastEdited;
        this.tags = tags;
        this.activityDate = activityDate;
    }

    //Create a form without a reflection or ID
    public Form(Event eventID, String shortDescription, User username, Role roleID, Timestamp lastEdited, List<Tags> tags, Date activityDate) {
        this.eventID = eventID;
        this.shortDescription = shortDescription;
        this.username = username;
        this.roleID = roleID;
        this.lastEdited = lastEdited;
        this.tags = tags;
        this.activityDate = activityDate;
    }

    //Create a form without a reflection but with ID
    public Form(int formID, Event eventID, String shortDescription, User username, Role roleID, Timestamp lastEdited, List<Tags> tags, Date activityDate) {
        this.formID = formID;
        this.eventID = eventID;
        this.shortDescription = shortDescription;
        this.username = username;
        this.roleID = roleID;
        this.lastEdited = lastEdited;
        this.tags = tags;
        this.activityDate = activityDate;
    }

    public String getCompletionLevel() {
        String completionLevel = "red";
        if(!getTagsByCategory("UKPSF").isEmpty()){
            if(reflectionID == null){
                completionLevel = "amber";
            } else {
                completionLevel = "green";
            }
        } else if (reflectionID != null) {
            completionLevel = "amber";
        }


        return completionLevel;
    }
}


