package com.birly.backend.controller;

import com.birly.backend.HousingAssociation;
import com.birly.backend.dto.billboard.BillboardItemDTO;
import com.birly.backend.dto.billboard.CreateBillboardItemRequest;
import com.birly.backend.seeds.BillboardSeedService;
import com.birly.backend.service.BillboardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5174")
@RestController
@RequestMapping("/billboard")
public class BillboardController {
    private final BillboardService billboardService;
    private final BillboardSeedService billboardSeedService;

    public BillboardController(BillboardService billboardService, BillboardSeedService billboardSeedService) {
        this.billboardService = billboardService;
        this.billboardSeedService = billboardSeedService;
    }

    @GetMapping("/posts/{housingAssociation}")
    public List<BillboardItemDTO> get(@PathVariable HousingAssociation housingAssociation) {
        return billboardService.getBillboardPosts(housingAssociation);
    }

    @PostMapping("/posts")
    public BillboardItemDTO create(@RequestBody CreateBillboardItemRequest request) {
       
        return billboardService.createBillboardPost(request);
    }

    @PostMapping("/seed")
    public List<BillboardItemDTO> seedBillboardPosts(){
        return billboardSeedService.seedBillboardPosts();
    }

}
