package com.birly.backend.controller;

import com.birly.backend.dto.billboard.BillboardItemDTO;
import com.birly.backend.dto.user.UserDTO;
import com.birly.backend.seeds.BillboardSeedService;
import com.birly.backend.seeds.UserSeedService;
import com.birly.backend.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5174")
@RestController
@RequestMapping("/seed")
public class SeedController {
    private final UserSeedService userSeedService;
    private final UserService userService;
    private final BillboardSeedService billboardSeedService;
    public SeedController(UserSeedService userSeedService,
                          UserService userService,
                          BillboardSeedService billboardSeedService) {
        this.userSeedService = userSeedService;
        this.userService = userService;
        this.billboardSeedService = billboardSeedService;
    }

    @PostMapping("/users")
    public List<UserDTO> seedUsers() {
        userSeedService.seedUsers();
        return userService.getAllUsers();
    }

    /**
     * IF you drop the users table you have to replace the two hardcoded users in BillboardSeedService to a user from the users db or else it will not work
     */
    @PostMapping("/billboardPosts")
    public List<BillboardItemDTO> seedBillboardPosts(){
        return billboardSeedService.seedBillboardPosts();
    }

}
