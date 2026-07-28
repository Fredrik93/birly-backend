package com.birly.backend.dto;

import com.birly.backend.Union;

public record CreateBillboardItemRequest(
        String title,
        String description,
        // union should be based on the user information, not passed here. 
        Union union,
        String createdByUser) {
}
