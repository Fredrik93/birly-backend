package com.birly.backend.domain;

import java.util.UUID;

public record UserId (UUID userId){
    public UserId {
        if (userId == null) {
            throw new IllegalArgumentException("User ID is null");
        }
    }
}
