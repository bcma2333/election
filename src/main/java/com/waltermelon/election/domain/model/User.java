package com.waltermelon.election.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;

    private String username;

    private String email;

    public String toJson() {
        return "{\"id\":" + id + ", \"username\":\"" + username + "\", \"email\":\"" + email + "\"}";
    }
}
