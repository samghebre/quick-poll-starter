package com.codedifferently.quickpoll.domain;

import javax.persistence.*;

@Entity
public class Vote {

    @Id //This annotation specifies that the option class is an entity
    @GeneratedValue //specifies the primary key of the option class table, that means the primary key will be automatically generated
    @Column(name= "Vote_id") // This is to specify the characteristics of the column for Vote_Id
    private Long id;

    @ManyToOne
    @JoinColumn(name="Option_id") //This annotation will allow joining of the Option_Id
    private Option option;


    public Vote(Long id, Option option) {
        this.id = id;
        this.option = option;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    @Override
    public String toString(){
        return getId() + "," + getOption();
    }
}
