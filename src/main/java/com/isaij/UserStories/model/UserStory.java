package com.isaij.UserStories.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "userstory")
public class UserStory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter
    @Getter
    private long id;

    @Column(name = "description")
    @Setter
    @Getter
    private String description;

    @Column(name = "startDate")
    @Setter
    @Getter
    private String startDate;

    @Column(name = "endDate")
    @Setter
    @Getter
    private String endDate;

    @Column(name = "finished")
    @Setter
    @Getter
    private boolean finished;

    @Column(name = "state")
    @Setter
    @Getter
    private String state;

    public UserStory() {
    }

    public UserStory(String description, String startDate, String endDate, boolean finished, String state) {
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.finished = finished;
        this.state = state;
    }


}
