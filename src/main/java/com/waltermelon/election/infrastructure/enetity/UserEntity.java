package com.waltermelon.election.infrastructure.enetity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "user")
@Getter
@Setter
public class UserEntity extends BaseEntity{
    @Id
    private Long id;

    private String username;

    private String email;
}
