package com.intexsoft.samokat.entity;

import com.google.gson.Gson;

public class Order {
    private String name;
    private String surname;
    private String address;
    private String subway;
    private String phoneNumber;
    private String date;
    private String term;
    private String scooterColor;

    public Order(String name, String surname, String address, String subway, String phoneNumber, String date, String term, String scooterColor) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.subway = subway;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.term = term;
        this.scooterColor = scooterColor;
    }

    public Order() {
    }

    public static Order buildFromJsonString(String jsonString) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, Order.class);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getSubway() {
        return subway;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDate() {
        return date;
    }

    public String getTerm() {
        return term;
    }

    public String getScooterColor() {
        return scooterColor;
    }
}
