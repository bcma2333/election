package com.waltermelon.election.domain;

public class User {
    private int id;

    private String username;

    private String email;

    public User(int id, String username, String email) {
        this.id = id;
        this.email = email;
        this.username = username;
    }

    public String toJson() {
        return "{\"id\":" + id + ", \"username\":\"" + username + "\", \"email\":\"" + email + "\"}";
    }
}
