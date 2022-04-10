package com.example.backend.data_model;

public class User {
    private long id;
    private String username;
    private String password;
    private int type;


    public User(long id, String username, String password, int type){
        this.id = id;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public User(String username, String password, int type) {
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString(){
        String text = "%s (%d)";
        return String.format(text, username, id);
    }
}
