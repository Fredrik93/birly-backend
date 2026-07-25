package com.birly.backend.dto;

import com.birly.backend.Union;

public record BillboardItemDTO(
        String title,
        String description,
        String id,
        Union union,
        String createdByUser) {
}
