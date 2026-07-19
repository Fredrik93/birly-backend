package com.birly.backend.controller;

import com.birly.backend.Union;
import com.birly.backend.dto.BillboardItemDTO;
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

    @GetMapping("/posts/{union}")
    public List<BillboardItemDTO> getBillboardPosts(@PathVariable Union union) {
        return billboardService.getBillboardPosts(union);
    }
}
