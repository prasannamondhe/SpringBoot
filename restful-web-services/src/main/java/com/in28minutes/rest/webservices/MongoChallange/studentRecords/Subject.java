package com.in28minutes.rest.webservices.MongoChallange.studentRecords;

/**
 * Created by Prasanna.Mondhe on 1/17/2019.
 */
public class Subject {

    public String name;
    public Integer status;

    public Subject(String name, Integer status) {
        this.name = name;
        this.status = status;
    }

    public Subject() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
