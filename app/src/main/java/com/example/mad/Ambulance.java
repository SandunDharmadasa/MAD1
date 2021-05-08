package com.example.mad;

public class Ambulance {

    private String name;
    private int PhoneNumber;
    private String address;
    private int AmNumber;

    public Ambulance() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAmNumber() {
        return AmNumber;
    }

    public void setAmNumber(int amNumber) {
        AmNumber = amNumber;
    }
}
