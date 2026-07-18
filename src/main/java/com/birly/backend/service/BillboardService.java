package com.birly.backend.service;

import com.birly.backend.Union;
import com.birly.backend.dto.BillboardItemDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillboardService {

    public List<BillboardItemDTO> getBillboardPosts(){
        return createMockPosts();
    }

    private List<BillboardItemDTO> createMockPosts(){
        BillboardItemDTO post1 = new BillboardItemDTO("Firealarms being checked", "desc on fire alarm checking", "1", Union.BANDLANDET, "1106");

        return List.of(post1);
    }
}
