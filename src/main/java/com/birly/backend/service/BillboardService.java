package com.birly.backend.service;

import com.birly.backend.HousingAssociation;
import com.birly.backend.converter.BillboardItemConverter;
import com.birly.backend.dto.billboard.BillboardItemDTO;
import com.birly.backend.dto.billboard.CreateBillboardItemRequest;

import com.birly.backend.dto.user.UserDTO;
import com.birly.backend.entity.BillboardItemEntity;
import com.birly.backend.repository.BillboardItemRepository;
import org.springframework.stereotype.Service;

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

    public List<BillboardItemDTO> getBillboardPosts(HousingAssociation housingAssociation) {
        // Show only one housingAssociation. this should be based on the user info later on.
        return billboardItemRepository.findByHousingAssociation(housingAssociation).stream().map(BillboardItemConverter::toDTO).toList();

    }

    public BillboardItemDTO createBillboardPost(CreateBillboardItemRequest request) {
        UserDTO user = userService.getUserById(request.createdByUser());

        if (user.housingAssociation() != request.housingAssociation()) {
            throw new IllegalArgumentException("The users housing association is not correct");
        }

        BillboardItemDTO dto = new BillboardItemDTO(
                request.title(),
                request.description(),
                UUID.randomUUID(),
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


}
