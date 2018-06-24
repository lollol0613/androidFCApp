package com.example.raina.poketbuddy;

public class FMember {
    private String name;
    private String email;
    private String contact;
    private String id;
    private String password;
    private boolean stat;

    public FMember() {
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact= contact;
    }

    public String getMid() {
        return id;
    }

    public void setMid(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setstatus(boolean stat)
    {this.stat = stat;}

    public boolean getstatus()
    {
        return this.stat;
    }

}
