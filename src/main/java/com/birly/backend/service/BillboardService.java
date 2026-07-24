package com.birly.backend.service;

import com.birly.backend.Union;
import com.birly.backend.dto.BillboardItemDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillboardService {
    private final MockedBillboardPosts mockedBillboardPosts;
    private final List<BillboardItemDTO> allPosts = new ArrayList<>();
    public BillboardService(MockedBillboardPosts mockedBillboardPosts) {
        this.mockedBillboardPosts = mockedBillboardPosts;
    }


    public List<BillboardItemDTO> getBillboardPosts(Union union) {
        allPosts.addAll(mockedBillboardPosts.createMockPosts());
        BillboardItemDTO test = allPosts.getFirst();
        System.out.println(test.getCreatedByUser() + " testy124");
        // Show only one union. this should be based on the user info later on.
        return allPosts.stream().filter(p -> p.getUnion().equals(union)).toList();

    }
    
    public BillboardItemDTO createBillboardPost(BillboardItemDTO dto){
        
        return null;
    }

}
