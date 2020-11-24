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
