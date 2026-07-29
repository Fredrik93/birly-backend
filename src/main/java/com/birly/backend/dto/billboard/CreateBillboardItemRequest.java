package com.birly.backend.dto.billboard;

import com.birly.backend.HousingAssociation;

public record CreateBillboardItemRequest(
        String title,
        String description,
        // housingAssociation should be based on the user information, not passed here.
        HousingAssociation housingAssociation,
        String createdByUser) {
}
