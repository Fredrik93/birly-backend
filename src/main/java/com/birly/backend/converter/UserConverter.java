package com.birly.backend.converter;

import com.birly.backend.domain.UserId;
import com.birly.backend.dto.user.UserDTO;
import com.birly.backend.entity.UserEntity;

public class UserConverter {

    private UserConverter() {
        /* This utility class should not be instantiated, hence the private constructor */
    }

    public static UserEntity toEntity(UserDTO dto) {
        return new UserEntity(dto.getUserId(), dto.housingAssociation(), dto.apartmentNumber());
    }

    public static UserDTO toDTO(UserEntity entity) {
        UserId userId = new UserId(entity.getUserId());
        return new UserDTO(userId, entity.getHousingAssociation(), entity.getApartmentNumber());
    }
}
