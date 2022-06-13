package com.example.diplomaproject.Database;

public class UserClass {

    String fullName, username, email, phoneN, password, data, gender;

    public UserClass(){}

    public UserClass(String fullName, String username, String email, String phoneN, String password, String data, String gender) {
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.phoneN = phoneN;
        this.password = password;
        this.data = data;
        this.gender = gender;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneN() {
        return phoneN;
    }

    public void setPhoneN(String phoneN) {
        this.phoneN = phoneN;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
