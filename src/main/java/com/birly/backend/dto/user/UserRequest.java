package com.birly.backend.dto.user;

import com.birly.backend.HousingAssociation;

public record UserRequest (String userId, HousingAssociation housingAssociation) {

}
