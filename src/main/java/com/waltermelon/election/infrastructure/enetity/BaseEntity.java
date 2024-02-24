package com.waltermelon.election.infrastructure.enetity;

import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {
    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_time")
    private Instant createdTime;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "updated_time")
    private Instant updatedTime;

    @Column(name = "deleted")
    private boolean deleted;

    @PrePersist
    protected void onCreate() {
        createdTime = Instant.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedTime = Instant.now();
    }
}
