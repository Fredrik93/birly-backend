package com.birly.backend.dto;

import com.birly.backend.Union;

import java.time.Instant;

public record BillboardItemDTO(
                String title,
                String description,
                String id,
                Union union,
                String createdByUser,
                Instant createdAt) {}
