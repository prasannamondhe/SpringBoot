package com.in28minutes.rest.webservices.pdfBox;

import org.springframework.data.annotation.Id;

/**
 * Created by Prasanna.Mondhe on 1/14/2019.
 */
public class FormDetails {

    @Id
    Integer id;
    String name;
    String companyName;
    String address;
    String city;
    String email;
    String state;

    public FormDetails(Integer id, String name, String companyName, String address, String city, String email, String state) {
        this.id = id;
        this.name = name;
        this.companyName = companyName;
        this.address = address;
        this.city = city;
        this.email = email;
        this.state = state;
    }

    public FormDetails(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
