package com.nsa.group6.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubmittingForm {

    public String eventType;

    public String getEventType() {
        return eventType;
    }

    public String shortDesc;

    public String getShortDesc(){
        return shortDesc;
    }

    public String role;

    public String getRole(){
        return role;
    }

    public List<String> others;

    public List<String> getOthers(){
        return others;
    }

    public List<String> impact;

    public List<String> getImpact(){
        return impact;
    }

    public List<String> learningTechs;

    public List<String> getLearningTechs(){
        return learningTechs;
    }

    public List<String> thoughtCloud;

    public List<String> getThoughtCloud(){
        return thoughtCloud;
    }

    public String thoughtDesc;

    public String getThoughtDesc(){
        return thoughtDesc;
    }

    public String box1;

    public String getBox1(){
        return box1;
    }

    public String box2;

    public String getBox2(){
        return box2;
    }

    public String box3;

    public String getBox3(){
        return box3;
    }


    public String box4;

    public String getBox4(){
        return box4;
    }


    public String box5;

    public String getBox5(){
        return box5;
    }

    public String box6;

    public String getBox6(){
        return box6;
    }

    public String learningPoint1;

    public String getLearningPoint1() {
        return learningPoint1;
    }

    public String learningPoint2;

    public String getLearningPoint2() {
        return learningPoint2;
    }

    public String learningPoint3;

    public String getLearningPoint3() {
        return learningPoint3;
    }
//    public SubmittingForm(){
//
//    }
}

