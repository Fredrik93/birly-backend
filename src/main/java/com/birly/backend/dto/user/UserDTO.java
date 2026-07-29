package com.birly.backend.dto.user;

import com.birly.backend.HousingAssociation;

public record UserDTO (String userId, HousingAssociation housingAssociation) {
}
