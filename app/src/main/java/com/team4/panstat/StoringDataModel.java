package com.team4.panstat;

public class StoringDataModel {
    String name,password,email,confirmpassword;

    StoringDataModel(){}
    public StoringDataModel(String name, String password, String email, String confirmpassword) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.confirmpassword = confirmpassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }
}

