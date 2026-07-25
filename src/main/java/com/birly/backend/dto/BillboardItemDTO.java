package com.birly.backend.dto;

import com.birly.backend.Union;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

public record BillboardItemDTO(
                String title,
                String description,
                String id,
                Union union,
                String createdByUser,
                Instant createdAt) {
        public BillboardItemDTO(String title,
                        String description,
                        Union union,
                        String createdByUser) {
                this(title, description, UUID.randomUUID().toString(), union, createdByUser, Instant.now());

        }

}
