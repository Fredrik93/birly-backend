package com.birly.backend.dto.user;

import com.birly.backend.domain.HousingAssociation;
import com.birly.backend.domain.UserId;

import java.util.UUID;

/**
 *
 * @param userId unique UUID for the user
 * @param housingAssociation which association (förening) eg BANDLANDET
 * @param apartmentNumber the apartment number written on the door (e.g., 1106)
 */
public record UserDTO (UserId userId, HousingAssociation housingAssociation, String apartmentNumber) {

    public UUID getUserId(){
        return this.userId.userId();
    }
}
