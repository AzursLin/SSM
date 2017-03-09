package com.hctek.model;

public class User {
    private Integer Id;

    private String Name;

    private String Password;

    private Integer Administrative;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer userId) {
        this.Id = userId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String userName) {
        this.Name = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return Password;
    }



    public Integer getAdministrative() {
        return Administrative;
    }

    public void setAdministrative(Integer Administrative) {
        this.Administrative = Administrative;
    }

    public void setPassword(String password) {
        Password = password;
    }
}