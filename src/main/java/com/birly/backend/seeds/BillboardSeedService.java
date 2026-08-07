package com.birly.backend.seeds;

import com.birly.backend.domain.HousingAssociation;
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

    private void setUpSeedUsers() {
        bandlandetUser = userService.getUsersInHousingAssociation(HousingAssociation.BANDLANDET).getFirst();
        bandlandetSecondUser = userService.getUsersInHousingAssociation(HousingAssociation.BANDLANDET).getLast();
        lindsdalUser = userService.getUsersInHousingAssociation(HousingAssociation.LINDSDAL).getFirst();
        skogsmardenUser = userService.getUsersInHousingAssociation(HousingAssociation.SKOGSMARDEN).getFirst();
    }

    public List<BillboardItemDTO> seedBillboardPosts() {
        setUpSeedUsers();
        if (!repository.existsByTitle("Clean the staircase")) {
            billboardService.create(new CreateBillboardItemRequest("Clean the staircase", "Staircase needs cleaning", bandlandetUser.housingAssociation(), bandlandetUser.userId().userId()));
        }
        if (!repository.existsByTitle("Lending out my car")) {
            billboardService.create(new CreateBillboardItemRequest("Lending out my car", "If anyone needs it", bandlandetSecondUser.housingAssociation(), bandlandetSecondUser.getUserId()));
        }
        if (!repository.existsByTitle("Free moving boxes")) {
            billboardService.create(new CreateBillboardItemRequest("Free moving boxes", "Pick them up in the basement", bandlandetUser.housingAssociation(), bandlandetUser.getUserId()));
        }
        if (!repository.existsByTitle("Lending out my drill")) {
            billboardService.create(new CreateBillboardItemRequest("Lending out my drill", "Ask in the yard", lindsdalUser.housingAssociation(), lindsdalUser.getUserId()));
        }
        if (!repository.existsByTitle("Lost black cat")) {
            billboardService.create(new CreateBillboardItemRequest("Lost black cat", "Answers to Simba", lindsdalUser.housingAssociation(), lindsdalUser.getUserId()));
        }
        if (!repository.existsByTitle("Lost my dog")) {
            billboardService.create(new CreateBillboardItemRequest("Lost my lil doggie", "Answers to doggie", skogsmardenUser.housingAssociation(), skogsmardenUser.getUserId()));
        }

        return repository.findAll().stream().map(BillboardItemConverter::toDTO).toList();
    }
}
