package com.nsa.group6.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Worked on by Jay
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
public class ActionPoints {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actionID;

    @ManyToOne
    @JoinColumn(name= "username")
    private User username;

    @Convert(converter = AttributeEncryptor.class)
    private String learning_point;

    private int checked;

    public ActionPoints(User username, int actionID, int checked) {
        this.username = username;
        this.actionID = actionID;
        this.checked = checked;
    }

    public ActionPoints(User username, String learning_point, int checked) {
        this.username = username;
        this.learning_point = learning_point;
        this.checked = checked;
    }

    public void updateFields(User username, int actionID, int checked) {
        this.username = username;
        this.actionID = actionID;
        this.checked = checked;
    }
}
