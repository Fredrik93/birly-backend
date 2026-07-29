package com.birly.backend.dto.billboard;

import com.birly.backend.HousingAssociation;

import java.time.Instant;

public record BillboardItemDTO(
                String title,
                String description,
                String id,
                HousingAssociation housingAssociation,
                // should be called userId instead
                String createdByUser,
                Instant createdAt) {}
