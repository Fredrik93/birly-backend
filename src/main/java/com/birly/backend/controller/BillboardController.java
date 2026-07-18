package com.birly.backend.controller;

import com.birly.backend.dto.BillboardItemDTO;
import com.birly.backend.service.BillboardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/billboard")
public class BillboardController {
    private final BillboardService billboardService;

    public BillboardController(BillboardService billboardService) {
        this.billboardService = billboardService;
    }

    @GetMapping("/posts")
    public List<BillboardItemDTO> getBillboardPosts() {
        return billboardService.getBillboardPosts();
    }
}
