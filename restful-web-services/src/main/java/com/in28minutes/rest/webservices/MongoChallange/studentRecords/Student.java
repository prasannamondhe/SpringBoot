package com.in28minutes.rest.webservices.MongoChallange.studentRecords;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prasanna.Mondhe on 1/17/2019.
 */
public class Student {

    public String studentName;
    public String standard;
    public List<Subject> subjects = null;

    public Student(String studentName, String standard, List<Subject> subjects) {
        this.studentName = studentName;
        this.standard = standard;
        this.subjects = subjects;
    }

    public Student() {
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
