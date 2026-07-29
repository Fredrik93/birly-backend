package com.birly.backend.converter;

import com.birly.backend.dto.BillboardItemDTO;
import com.birly.backend.entity.BillboardItemEntity;

public class BillboardItemConverter {
    private BillboardItemConverter() {
        /* This utility class should not be instantiated */
    }


    public static BillboardItemEntity toEntity(BillboardItemDTO dto) {
        return new BillboardItemEntity(
                dto.id(), dto.title(), dto.description(), dto.housingAssociation(), dto.createdByUser(), dto.createdAt()
        );
    }

    public static BillboardItemDTO toDTO(BillboardItemEntity entity) {
        return new BillboardItemDTO(entity.getTitle(), entity.getDescription(), entity.getId(), entity.getHousingAssociation(), entity.getCreatedByUser(), entity.getCreatedAt());
    }
}
