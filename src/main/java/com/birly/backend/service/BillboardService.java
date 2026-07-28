package com.birly.backend.service;

import com.birly.backend.Union;
import com.birly.backend.converter.BillboardItemConverter;
import com.birly.backend.dto.BillboardItemDTO;
import com.birly.backend.dto.CreateBillboardItemRequest;

import com.birly.backend.entity.BillboardItemEntity;
import com.birly.backend.repository.BillboardItemRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class BillboardService {
    private final BillboardItemRepository repository;

    public BillboardService(BillboardItemRepository repository) {
        this.repository = repository;
    }

    public List<BillboardItemDTO> getBillboardPosts(Union union) {
        // Show only one union. this should be based on the user info later on.
        List<BillboardItemDTO> dtos = getAllDTOs(union);
        return dtos.stream().filter(p -> p.union() == union).toList();

    }

    public BillboardItemDTO createBillboardPost(CreateBillboardItemRequest request) {

        BillboardItemDTO dto = new BillboardItemDTO(
                request.title(),
                request.description(),
                UUID.randomUUID().toString(),
                request.union(),
                request.createdByUser(),
                Instant.now());
        save(dto);
        return dto;
    }

    private void save(BillboardItemDTO dto) {
        BillboardItemEntity entity = BillboardItemConverter.toEntity(dto);
        repository.save(entity);
    }

    private List<BillboardItemDTO> getAllDTOs(Union union) {
        List<BillboardItemEntity> entities = repository.findAll();
        return entities.stream().map(BillboardItemConverter::toDTO).filter(u -> u.union().equals(union)).toList();
    }


}
