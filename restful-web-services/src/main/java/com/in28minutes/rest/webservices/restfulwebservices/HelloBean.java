package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.Size;

/**
 * Created by Prasanna.Mondhe on 12/21/2018.
 */

public class HelloBean {


    @Id
    @GeneratedValue
    public Integer Id;

    @Size(min = 2,message = "Name should be greater than size of 2")
    public String name;

    public Integer number;

    public HelloBean(Integer id, String name, Integer number) {
        Id = id;
        this.name = name;
        this.number = number;
    }

    public HelloBean(){

    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
