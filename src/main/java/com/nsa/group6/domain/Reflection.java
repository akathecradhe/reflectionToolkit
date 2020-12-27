package com.nsa.group6.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Worked on by Tom, Jay
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reflection {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int reflectionID;

    @Convert(converter = AttributeEncryptor.class)
    private String box1;

    @Convert(converter = AttributeEncryptor.class)
    private String box2;

    @Convert(converter = AttributeEncryptor.class)
    private String box3;

    @Convert(converter = AttributeEncryptor.class)
    private String box4;

    @Convert(converter = AttributeEncryptor.class)
    private String box5;

    @Convert(converter = AttributeEncryptor.class)
    private String box6;

    @Convert(converter = AttributeEncryptor.class)
    private String learningPoint1;

    @Convert(converter = AttributeEncryptor.class)
    private String learningPoint2;

    @Convert(converter = AttributeEncryptor.class)
    private String learningPoint3;


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


    public void updateFields(String box1, String box2, String box3, String box4, String box5, String box6, String learningPoint1, String learningPoint2, String learningPoint3) {
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


}
