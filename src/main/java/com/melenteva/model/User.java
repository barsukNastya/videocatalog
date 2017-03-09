package com.melenteva.model;

/**
 * Created by User on 18.02.2017.
 */
public class User {

    private int Id;
    private String userName;
    private String userPassword;
    private Boolean isAdmin;

    public User(String username, String password){
        this.userName = username;
        this.userPassword = password;
    }

    public User(String username, String password, Boolean isAdmin){
        this.userName = username;
        this.userPassword = password;
        this.isAdmin = isAdmin;
    }
    public User()
    {}

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        this.isAdmin = admin;
    }


}
