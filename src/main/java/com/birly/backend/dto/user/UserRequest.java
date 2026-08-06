package com.birly.backend.dto.user;

import com.birly.backend.domain.HousingAssociation;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserRequest(
        @NotNull HousingAssociation housingAssociation,
        @Size(min = 4, max = 8, message = "Apartment number must be 4-8 digits")
        @NotNull
        String apartmentNumber) {

}
