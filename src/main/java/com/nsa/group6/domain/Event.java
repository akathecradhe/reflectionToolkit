package com.nsa.group6.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventID;
    private Date eventDate;
    private String name;


    public int getEventId() {
        return eventID;
    }

    public void setId(int eventID) {
        this.eventID = eventID;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }
        //This function returns the date object in the format wanted for the webpage. Previously printing the
        //event would include a timestamp of midnight.
        public String getDateString () {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            return formatter.format(eventDate);

        }
    }


