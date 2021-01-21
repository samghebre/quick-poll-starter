package com.codedifferently.quickpoll.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity //This annotation specifies that the option class is an entity
public class Option {
    @Id // specifies the primary key of the option class table, that means the primary key will be automatically generated
    @GeneratedValue //a value that has to be created for the primary key
    @Column(name= "Option_id") //This will set an entity property value
    private Long id;

    @Column(name= "Option value")
    private String value;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    @Override
    public String toString(){
        return getId() + "," + getValue();
    }
}
