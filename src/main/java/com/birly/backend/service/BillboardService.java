package com.birly.backend.service;

import com.birly.backend.Union;
import com.birly.backend.dto.BillboardItemDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillboardService {
    private final MockedBillboardPosts mockedBillboardPosts;

    public BillboardService(MockedBillboardPosts mockedBillboardPosts) {
        this.mockedBillboardPosts = mockedBillboardPosts;
    }


    public List<BillboardItemDTO> getBillboardPosts(Union union) {
        List<BillboardItemDTO> allPosts = mockedBillboardPosts.createMockPosts();
        // Show only one union. this should be based on the user info later on.
        return allPosts.stream().filter(p -> p.getUnion().equals(union)).toList();

    }

}
