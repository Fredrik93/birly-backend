package com.birly.backend.converter;

import com.birly.backend.domain.HousingAssociation;
import com.birly.backend.dto.user.UserDTO;
import com.birly.backend.entity.UserEntity;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class UserConverterTest {

    @Test
    void toDTO_mapsAllFieldsCorrectly(){
        UUID userId = UUID.randomUUID();

        UserEntity entity = new UserEntity(userId, HousingAssociation.SKOGSMARDEN, "1105");
        UserDTO dto = UserConverter.toDTO(entity);

        assertThat(dto.userId()).isEqualTo(userId);
        assertThat(dto.housingAssociation()).isEqualTo(HousingAssociation.SKOGSMARDEN);
        assertThat(dto.apartmentNumber()).isEqualTo("1105");
    }

    @Test void toEntity_mapsAllFieldsCorrectly(){

        UUID userId = UUID.randomUUID();

        UserDTO dto = new UserDTO(userId, HousingAssociation.SKOGSMARDEN, "1105");
        UserEntity entity = UserConverter.toEntity(dto);

        assertThat(entity.getUserId()).isEqualTo(userId);
        assertThat(entity.getHousingAssociation()).isEqualTo(HousingAssociation.SKOGSMARDEN);
        assertThat(entity.getApartmentNumber()).isEqualTo("1105");


    }
}
