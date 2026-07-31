package com.birly.backend.seeds;

import com.birly.backend.HousingAssociation;
import com.birly.backend.converter.BillboardItemConverter;
import com.birly.backend.dto.billboard.BillboardItemDTO;
import com.birly.backend.dto.billboard.CreateBillboardItemRequest;
import com.birly.backend.repository.BillboardItemRepository;
import com.birly.backend.service.BillboardService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BillboardSeedService {
    private final BillboardItemRepository repository;
    private final BillboardService billboardService;

    public BillboardSeedService(BillboardService billboardService, BillboardItemRepository repository) {
        this.repository = repository;
        this.billboardService = billboardService;
    }

    public List<BillboardItemDTO> seedBillboardPosts() {
        if (!repository.existsByTitle("Clean the staircase")) {
            billboardService.createBillboardPost(new CreateBillboardItemRequest("Clean the staircase", "Staircase needs cleaning", HousingAssociation.BANDLANDET, UUID.fromString("eea7afae-96d4-463f-aca2-70b43f367941")));
        }
        if (!repository.existsByTitle("Lending out my car")) {
            billboardService.createBillboardPost(new CreateBillboardItemRequest("Lending out my car", "If anyone needs it", HousingAssociation.BANDLANDET, UUID.fromString("eea7afae-96d4-463f-aca2-70b43f367941")));
        }
        if (!repository.existsByTitle("Free moving boxes")) {
            billboardService.createBillboardPost(new CreateBillboardItemRequest("Free moving boxes", "Pick them up in the basement", HousingAssociation.BANDLANDET, UUID.fromString("eea7afae-96d4-463f-aca2-70b43f367941")));
        }
        if (!repository.existsByTitle("Lending out my drill")) {
            billboardService.createBillboardPost(new CreateBillboardItemRequest("Lending out my drill", "Ask in the yard", HousingAssociation.BANDLANDET, UUID.fromString("eea7afae-96d4-463f-aca2-70b43f367941")));
        }
        if (!repository.existsByTitle("Lost black cat")) {
            billboardService.createBillboardPost(new CreateBillboardItemRequest("Lost black cat", "Answers to Simba", HousingAssociation.BANDLANDET, UUID.fromString("eea7afae-96d4-463f-aca2-70b43f367941")));
        }
        if (!repository.existsByTitle("Lost my dog")) {
            billboardService.createBillboardPost(new CreateBillboardItemRequest("Lost my lil doggie", "Answers to doggie", HousingAssociation.LINDSDAL, UUID.fromString("ae00f153-8cb8-4993-ab17-e0b8d74f2303")));
        }

        return repository.findAll().stream().map(BillboardItemConverter::toDTO).toList();
    }
}
