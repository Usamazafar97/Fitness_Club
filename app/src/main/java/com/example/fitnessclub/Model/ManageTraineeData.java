package com.example.fitnessclub.Model;


public class ManageTraineeData {

    private String name, phno, email;

    public ManageTraineeData(String name, String phno, String email) {
        this.name = name;
        this.phno = phno;
        this.email = email;

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
        return phno;
    }

    public void setPhoneNo(String phno) {
        this.phno = phno;
    }

}
