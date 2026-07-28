package com.birly.backend.converter;

import com.birly.backend.dto.BillboardItemDTO;
import com.birly.backend.entity.BillboardItemEntity;

public class BillboardItemConverter {

    public static BillboardItemEntity toEntity(BillboardItemDTO dto) {
        return new BillboardItemEntity(
                dto.id(), dto.title(), dto.description(), dto.union(), dto.createdByUser(), dto.createdAt()
        );
    }

    public static BillboardItemDTO toDTO(BillboardItemEntity entity) {
        return new BillboardItemDTO(entity.getTitle(), entity.getDescription(), entity.getId(), entity.getUnion(), entity.getCreatedByUser(), entity.getCreatedAt());
    }
}
