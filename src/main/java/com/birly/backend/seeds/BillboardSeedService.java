package com.birly.backend.seeds;

import com.birly.backend.controller.BillboardController;
import com.birly.backend.converter.BillboardItemConverter;
import com.birly.backend.dto.billboard.BillboardItemDTO;
import com.birly.backend.dto.billboard.CreateBillboardItemRequest;
import com.birly.backend.entity.BillboardItemEntity;
import com.birly.backend.repository.BillboardItemRepository;
import com.birly.backend.service.BillboardService;

import java.util.List;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

public class BillboardSeedService {
    private final BillboardItemRepository repository;
    private final BillboardService billboardService;

    public BillboardSeedService(BillboardService billboardService, BillboardItemRepository repository) {
        this.repository = repository;
        this.billboardService = billboardService;
    }

    public void seedBillboardPosts() {
        List<BillboardItemDTO> posts = repository.findAll().stream().map(BillboardItemConverter::toDTO).toList();

        if (posts.isEmpty()) {
            billboardService.createBillboardPost(new CreateBillboardItemRequest("Clean the staircase"))
        }

    }
}
