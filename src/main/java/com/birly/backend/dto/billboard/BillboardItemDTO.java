package com.birly.backend.dto.billboard;

import com.birly.backend.HousingAssociation;

import java.time.Instant;
import java.util.UUID;

public record BillboardItemDTO(
                String title,
                String description,
                UUID billboardItemId,
                HousingAssociation housingAssociation,
                UUID createdByUser,
                Instant createdAt) {}
