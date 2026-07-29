package com.birly.backend.controller;

import com.birly.backend.HousingAssociation;
import com.birly.backend.dto.billboard.BillboardItemDTO;
import com.birly.backend.dto.billboard.CreateBillboardItemRequest;
import com.birly.backend.service.BillboardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/billboard")
public class BillboardController {
    private final BillboardService billboardService;

    public BillboardController(BillboardService billboardService) {
        this.billboardService = billboardService;
    }

    @GetMapping("/posts/{housingAssociation}")
    public List<BillboardItemDTO> get(@PathVariable HousingAssociation housingAssociation) {
        return billboardService.getBillboardPosts(housingAssociation);
    }

    @PostMapping("/posts")
    public BillboardItemDTO create(@RequestBody CreateBillboardItemRequest request) {
       
        return billboardService.createBillboardPost(request);
    }

}
