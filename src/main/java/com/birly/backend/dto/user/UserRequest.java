package com.birly.backend.dto.user;

import com.birly.backend.HousingAssociation;

public record UserRequest (HousingAssociation housingAssociation, String apartmentNumber) {

}
