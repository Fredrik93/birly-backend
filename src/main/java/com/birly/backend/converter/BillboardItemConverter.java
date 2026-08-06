package com.birly.backend.converter;

import com.birly.backend.domain.BillboardItemId;
import com.birly.backend.dto.billboard.BillboardItemDTO;
import com.birly.backend.entity.BillboardItemEntity;

public class BillboardItemConverter {
    private BillboardItemConverter() {
        /* This utility class should not be instantiated */
    }

    public static BillboardItemEntity toEntity(BillboardItemDTO dto) {
        return new BillboardItemEntity(
                dto.billboardItemId().id(), dto.title(), dto.description(), dto.housingAssociation(), dto.createdByUser(), dto.createdAt()
        );
    }

    public static BillboardItemDTO toDTO(BillboardItemEntity entity) {
        BillboardItemId billboardItemId = new BillboardItemId(entity.getBillboardItemId());
        return new BillboardItemDTO(entity.getTitle(), entity.getDescription(), billboardItemId, entity.getHousingAssociation(), entity.getCreatedByUser(), entity.getCreatedAt());
    }
}
