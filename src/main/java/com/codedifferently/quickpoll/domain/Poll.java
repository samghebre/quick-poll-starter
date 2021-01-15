package com.codedifferently.quickpoll.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Poll {
    @Id
    @GeneratedValue
    @Column(name= "Poll_id")
    private Long id;

    @Column(name="Question")
    private String question;

    @OneToMany(cascade=CascadeType.ALL)
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
