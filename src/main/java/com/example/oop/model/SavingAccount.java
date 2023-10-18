package com.example.oop.model;

public class SavingAccount extends Account{
    private float interest;

    public SavingAccount() {
        super();
    }

    public SavingAccount(String number, String description, String account_title, String status, int bankCode, int customerId, float interest) {
        super(number, description, account_title, status, bankCode, customerId);
        this.interest = interest;
    }

    @Override
    public void viewAccount() {

    }

    public float calculateInterest() {
        return 0.5F;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }
}
