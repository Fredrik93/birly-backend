package com.birly.backend.dto;

import com.birly.backend.Union;

public record CreateBillboardItemRequest(
        String title,
        String description,
        Union union,
        String createdByUser) {
}
