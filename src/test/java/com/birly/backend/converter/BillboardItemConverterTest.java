package com.birly.backend.converter;

import com.birly.backend.HousingAssociation;
import com.birly.backend.dto.billboard.BillboardItemDTO;
import com.birly.backend.entity.BillboardItemEntity;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class BillboardItemConverterTest {

    @Test
    void toDTO_mapsAllFieldsCorrectly() {
        UUID billboardItemId = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        Instant createdAt = Instant.now();

        BillboardItemEntity entity = new BillboardItemEntity(billboardItemId, "aTitle", "aDescription", HousingAssociation.BANDLANDET, userId, createdAt);

        BillboardItemDTO dto = BillboardItemConverter.toDTO(entity);

        assertThat(dto.billboardItemId()).isEqualTo(billboardItemId);
        assertThat(dto.title()).isEqualTo("aTitle");
        assertThat(dto.description()).isEqualTo("aDescription");
        assertThat(dto.housingAssociation()).isEqualTo(HousingAssociation.BANDLANDET);
        assertThat(dto.createdByUser()).isEqualTo(userId);
        assertThat(dto.createdAt()).isEqualTo(createdAt);
    }

    @Test
    void toEntity_mapsAllFieldsCorrectly() {
        UUID billboardItemId = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        Instant createdAt = Instant.now();

        BillboardItemDTO dto = new BillboardItemDTO("aTitle", "aDescription", billboardItemId, HousingAssociation.BANDLANDET, userId, createdAt);

        BillboardItemEntity entity = BillboardItemConverter.toEntity(dto);

        assertThat(entity.getBillboardItemId()).isEqualTo(billboardItemId);
        assertThat(entity.getTitle()).isEqualTo("aTitle");
        assertThat(entity.getDescription()).isEqualTo("aDescription");
        assertThat(entity.getHousingAssociation()).isEqualTo(HousingAssociation.BANDLANDET);
        assertThat(entity.getCreatedByUser()).isEqualTo(userId);
        assertThat(entity.getCreatedAt()).isEqualTo(createdAt);
    }
}
