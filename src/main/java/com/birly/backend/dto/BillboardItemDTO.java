package com.birly.backend.dto;

import com.birly.backend.HousingAssociation;

import java.time.Instant;

public record BillboardItemDTO(
                String title,
                String description,
                String id,
                HousingAssociation housingAssociation,
                String createdByUser,
                Instant createdAt) {}
