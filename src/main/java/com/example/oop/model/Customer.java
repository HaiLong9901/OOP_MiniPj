package com.example.oop.model;

public class Customer {
    public static int lastestId = 1;
    private int id = 0;
    private String name;
    private String email;
    private String phoneNo;
    private String username;
    private String address;
    private String cardNo;

    public Customer() {
    }

    public Customer(String name, String email, String phoneNo, String username, String address, String cardNo) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.username = username;
        this.address = address;
        this.cardNo = cardNo;
        this.id = lastestId;
        ++lastestId;
    }

    public Customer(int id, String name, String email, String phoneNo, String username, String address, String cardNo) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.username = username;
        this.address = address;
        this.cardNo = cardNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", cardNo='" + cardNo + '\'' +
                '}';
    }
}
