package com.birly.backend.seeds;

import com.birly.backend.HousingAssociation;
import com.birly.backend.converter.BillboardItemConverter;
import com.birly.backend.dto.billboard.BillboardItemDTO;
import com.birly.backend.dto.billboard.CreateBillboardItemRequest;
import com.birly.backend.dto.user.UserDTO;
import com.birly.backend.repository.BillboardItemRepository;
import com.birly.backend.service.BillboardService;
import com.birly.backend.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillboardSeedService {
    private final BillboardItemRepository repository;
    private final BillboardService billboardService;
    private final UserService userService;
    private UserDTO bandlandetUser;
    private UserDTO bandlandetSecondUser;
    private UserDTO lindsdalUser;
    private UserDTO skogsmardenUser;

    public BillboardSeedService(BillboardService billboardService, BillboardItemRepository repository, UserService userService) {
        this.repository = repository;
        this.billboardService = billboardService;
        this.userService = userService;
    }

    public void setUpSeedUsers() {
        bandlandetUser = userService.getUsersInHousingAssociation(HousingAssociation.BANDLANDET).getFirst();
        bandlandetSecondUser = userService.getUsersInHousingAssociation(HousingAssociation.BANDLANDET).getLast();
        lindsdalUser = userService.getUsersInHousingAssociation(HousingAssociation.LINDSDAL).getFirst();
        skogsmardenUser = userService.getUsersInHousingAssociation(HousingAssociation.SKOGSMARDEN).getFirst();

    }

    public List<BillboardItemDTO> seedBillboardPosts() {
        setUpSeedUsers();
        if (!repository.existsByTitle("Clean the staircase")) {
            billboardService.createBillboardPost(new CreateBillboardItemRequest("Clean the staircase", "Staircase needs cleaning", bandlandetUser.housingAssociation(), bandlandetUser.userId()));
        }
        if (!repository.existsByTitle("Lending out my car")) {
            billboardService.createBillboardPost(new CreateBillboardItemRequest("Lending out my car", "If anyone needs it", bandlandetSecondUser.housingAssociation(), bandlandetSecondUser.userId()));
        }
        if (!repository.existsByTitle("Free moving boxes")) {
            billboardService.createBillboardPost(new CreateBillboardItemRequest("Free moving boxes", "Pick them up in the basement", bandlandetUser.housingAssociation(), bandlandetUser.userId()));
        }
        if (!repository.existsByTitle("Lending out my drill")) {
            billboardService.createBillboardPost(new CreateBillboardItemRequest("Lending out my drill", "Ask in the yard", lindsdalUser.housingAssociation(), lindsdalUser.userId()));
        }
        if (!repository.existsByTitle("Lost black cat")) {
            billboardService.createBillboardPost(new CreateBillboardItemRequest("Lost black cat", "Answers to Simba", lindsdalUser.housingAssociation(), lindsdalUser.userId()));
        }
        if (!repository.existsByTitle("Lost my dog")) {
            billboardService.createBillboardPost(new CreateBillboardItemRequest("Lost my lil doggie", "Answers to doggie", skogsmardenUser.housingAssociation(), skogsmardenUser.userId()));
        }

        return repository.findAll().stream().map(BillboardItemConverter::toDTO).toList();
    }
}
