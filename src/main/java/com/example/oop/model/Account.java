package com.example.oop.model;

public class Account {
    private String number;
    private float balance;
    private String description;
    private String account_title;
    private String status;
    private int bankCode;

    public Account() {
    }

    public Account(String number, float balance, String description, String account_title, String status, int bankCode) {
        this.number = number;
        this.balance = balance;
        this.description = description;
        this.account_title = account_title;
        this.status = status;
        this.bankCode = bankCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAccount_title() {
        return account_title;
    }

    public void setAccount_title(String account_title) {
        this.account_title = account_title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getBankCode() {
        return bankCode;
    }

    public void setBankCode(int bankCode) {
        this.bankCode = bankCode;
    }

    public void viewAccount() {

    }
}
