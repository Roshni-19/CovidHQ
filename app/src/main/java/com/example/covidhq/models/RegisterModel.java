package com.example.covidhq.models;

public class RegisterModel {

    String name, gender, email, mobno;
    int age;

    public RegisterModel(String name, String gender, String email, String mobno, int age) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.mobno = mobno;
        this.age = age;
    }

    public RegisterModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobno() {
        return mobno;
    }

    public void setMobno(String mobno) {
        this.mobno = mobno;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
