package com.birly.backend.dto.billboard;

import com.birly.backend.domain.UserId;

import java.util.UUID;

public record UpdateBillboardItemRequest (String title, String description, UUID userId) {
}
