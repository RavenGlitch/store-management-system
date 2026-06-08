package com.storeSystem.model;

public class Customer {
    private String fisrtName;
    private String lastName;
    private int id;
    private int mobile;

    public Customer(){
    }

    public Customer(String firstName, String lastName, int id , int mobile){
        this.fisrtName = fisrtName;
        this.lastName = lastName;
        this.id = id;
        this.mobile = mobile;
    }

    public String getFisrtName() {
        return fisrtName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    public int getMobile() {
        return mobile;
    }

    public void setFisrtName(String fisrtName) {
        this.fisrtName = fisrtName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }
}
