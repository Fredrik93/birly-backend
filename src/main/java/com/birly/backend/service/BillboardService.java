package com.birly.backend.service;

import com.birly.backend.Union;
import com.birly.backend.dto.BillboardItemDTO;
import com.birly.backend.dto.CreateBillboardItemRequest;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BillboardService {
    private final List<BillboardItemDTO> allPosts = new ArrayList<>();

    public BillboardService(MockedBillboardPosts mockedBillboardPosts) {
        allPosts.addAll(mockedBillboardPosts.createMockPosts());
    }

    public List<BillboardItemDTO> getBillboardPosts(Union union) {
        // Show only one union. this should be based on the user info later on.
        return allPosts.stream().filter(p -> p.union().equals(union)).toList();

    }

    public BillboardItemDTO createBillboardPost(CreateBillboardItemRequest request) {

        BillboardItemDTO dto = new BillboardItemDTO(
            request.title(), 
            request.description(),
            UUID.randomUUID().toString(), 
            request.union(),
            request.createdByUser(), 
            Instant.now());

        allPosts.add(dto);
        return dto;
    }
    

}
