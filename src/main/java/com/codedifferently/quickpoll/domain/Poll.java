package com.codedifferently.quickpoll.domain;

import javax.persistence.*;
import java.util.Set;

@Entity //This annotation specifies that the option class is an entity
public class Poll {
    @Id // specifies the primary key of the option class table, that means the primary key will be automatically generated
    @GeneratedValue //a value that has to be created for the primary key
    @Column(name= "Poll_id") //This will set an entity property value
    private Long id;

    @Column(name="Question")
    private String question;

    @OneToMany(cascade=CascadeType.ALL) //This annotation declares the relationship between two entities Poll and Option
                                        //here one Poll entity to many Option entity
    @JoinColumn(name="pollId")
    @OrderBy
    private Set<Option> options;

    public Poll(Long id, String question, Set<Option> options) {
        this.id = id;
        this.question = question;
        this.options = options;
    }

    public Long getPollId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Set<Option> getOptions() {
        return options;
    }

    public void setOptions(Set<Option> options) {
        this.options = options;
    }

    @Override
    public String toString(){
        return getPollId() + "," + getQuestion() + "," + getOptions();
    }

}
