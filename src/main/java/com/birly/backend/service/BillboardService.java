package com.birly.backend.service;

import com.birly.backend.domain.BillboardItemId;
import com.birly.backend.domain.HousingAssociation;
import com.birly.backend.converter.BillboardItemConverter;
import com.birly.backend.dto.billboard.BillboardItemDTO;
import com.birly.backend.dto.billboard.CreateBillboardItemRequest;

import com.birly.backend.dto.billboard.UpdateBillboardItemRequest;
import com.birly.backend.dto.user.UserDTO;
import com.birly.backend.entity.BillboardItemEntity;
import com.birly.backend.repository.BillboardItemRepository;
import com.birly.backend.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class BillboardService {
    private final BillboardItemRepository billboardItemRepository;
    private final UserService userService;

    public BillboardService(BillboardItemRepository billboardItemRepository, UserService userService) {
        this.billboardItemRepository = billboardItemRepository;
        this.userService = userService;
    }

    public List<BillboardItemDTO> get(HousingAssociation housingAssociation) {
        // Show only one housingAssociation. this should be based on the user info later on.
        return billboardItemRepository.findByHousingAssociation(housingAssociation).stream().map(BillboardItemConverter::toDTO).toList();

    }

    public BillboardItemDTO create(CreateBillboardItemRequest request) {
        UserDTO user = userService.getUserById(request.createdByUser());

        if (user.housingAssociation() != request.housingAssociation()) {
            throw new IllegalArgumentException("The users housing association is not correct");
        }
        BillboardItemId billboardItemId = new BillboardItemId(UUID.randomUUID());
        BillboardItemDTO dto = new BillboardItemDTO(
                request.title(),
                request.description(),
                billboardItemId,
                request.housingAssociation(),
                request.createdByUser(),
                Instant.now());
        save(dto);
        return dto;
    }

    private void save(BillboardItemDTO dto) {
        BillboardItemEntity entity = BillboardItemConverter.toEntity(dto);
        billboardItemRepository.save(entity);
    }

    public BillboardItemDTO update(UUID billboardItemId, UpdateBillboardItemRequest request) {
        
        userService.checkUserById(request.userId());

        BillboardItemEntity entity = billboardItemRepository.findById(billboardItemId)
                .orElseThrow(() -> new IllegalArgumentException("Billboard item ID " + billboardItemId + " not found"));

        // Update entity
        if (request.title() != null && !request.title().isEmpty()) {
            entity.setTitle(request.title());
        }
        if (request.description() != null && !request.description().isEmpty()) {
            entity.setDescription(request.description());
        }

        billboardItemRepository.save(entity);

        return BillboardItemConverter.toDTO(entity);
    }


}
