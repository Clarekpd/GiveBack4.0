package com.example.giveback;

/**
 * TODO: THIS CLASS WAS CREATED AS A TEST OF DB connectivity to Firebase.
 *
 *
 *
 */
public class Donors {
    public String getAllFirstName() {
        return firstName;
    }

    public void setAllFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAllLastName() {
        return lastName;
    }

    public void setAllLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAllPhone() {
        return phone;
    }

    public void setAllPhone(String phone) {
        this.phone = phone;
    }

    public String getAllStreet() {
        return street;
    }

    public void setAllStreet(String street) {
        this.street = street;
    }

    public String getAllState() {
        return state;
    }

    public void setAllState(String state) {
        this.state = state;
    }

    public String getAllCity() {
        return city;
    }

    public void setAllCity(String city) {
        this.city = city;
    }

    String firstName;
    String lastName;
    String phone;
    String street;
    String state;
    String city;

    public Donors() {

    }


}
