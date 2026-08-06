package com.birly.backend.domain;

import java.util.UUID;


public record BillboardItemId(UUID id) {

    public BillboardItemId {
        if (id == null) {
            throw new IllegalArgumentException("UUID can't be null");
        }
    }
}
