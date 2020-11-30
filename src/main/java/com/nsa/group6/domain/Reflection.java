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
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reflection {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int reflectionID;

    public Reflection(String box1, String box2, String box3, String box4, String box5, String box6, String learningPoint1, String learningPoint2, String learningPoint3) {
        this.box1 = box1;
        this.box2 = box2;
        this.box3 = box3;
        this.box4 = box4;
        this.box5 = box5;
        this.box6 = box6;
        this.learningPoint1 = learningPoint1;
        this.learningPoint2 = learningPoint2;
        this.learningPoint3 = learningPoint3;
    }

    private String box1;
    private String box2;
    private String box3;
    private String box4;
    private String box5;
    private String box6;
    private String learningPoint1;
    private String learningPoint2;
    private String learningPoint3;


}
