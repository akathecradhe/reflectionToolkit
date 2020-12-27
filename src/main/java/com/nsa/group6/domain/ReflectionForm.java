package com.nsa.group6.domain;

import lombok.*;

/**
 * Worked on by Tom
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReflectionForm {
    public Integer formID;

    public String box1;
    public String box2;
    public String box3;
    public String box4;
    public String box5;
    public String box6;

    public String learningPoint1;
    public String learningPoint2;
    public String learningPoint3;

    public ReflectionForm(String box1, String box2, String box3, String box4, String box5, String box6, String learningPoint1, String learningPoint2, String learningPoint3) {
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
