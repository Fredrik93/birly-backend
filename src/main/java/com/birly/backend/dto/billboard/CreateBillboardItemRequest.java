package com.birly.backend.dto.billboard;

import com.birly.backend.domain.HousingAssociation;

import java.util.UUID;

public record CreateBillboardItemRequest(
        String title,
        String description,
        HousingAssociation housingAssociation,
        UUID createdByUser) {
}
