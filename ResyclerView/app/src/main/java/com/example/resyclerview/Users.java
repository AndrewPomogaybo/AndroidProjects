package com.example.resyclerview;

import com.google.gson.annotations.SerializedName;

public class Users {
    @SerializedName("firstName")
    public String Name;
    public String lastName;
    public int age;
    public String email;

    public String getFirstName() {
        return Name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }
}
