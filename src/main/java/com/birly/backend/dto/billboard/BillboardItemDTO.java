package com.birly.backend.dto.billboard;

import com.birly.backend.domain.HousingAssociation;
import com.birly.backend.domain.BillboardItemId;

import java.time.Instant;
import java.util.UUID;

public record BillboardItemDTO(
        String title,
        String description,
        BillboardItemId billboardItemId,
        HousingAssociation housingAssociation,
        UUID createdByUser,
        Instant createdAt) {
    public BillboardItemDTO {
        if (billboardItemId == null) {
            throw new IllegalArgumentException("BillboardItemId can't be null");
        }
    }
}
