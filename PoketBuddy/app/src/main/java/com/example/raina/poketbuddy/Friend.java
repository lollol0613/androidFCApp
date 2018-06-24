package com.example.raina.poketbuddy;

public class Friend {
    private String name;
    private String phone;
    private String gender;
    private String qul;
    private String pros;
    private String address;
    private boolean stat;

    public Friend() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone;
    }

    public void setPhone_number(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getQul() {
        return qul;
    }

    public void setQul(String qul) {
        this.qul = qul;
    }

    public String getProfession() {
        return pros;
    }

    public void setProfession(String pros) {
        this.pros = pros;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setstatus(boolean stat)
    {this.stat = stat;}

    public boolean getstatus()
    {
        return this.stat;
    }

}
