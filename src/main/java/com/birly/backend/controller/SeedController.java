package com.birly.backend.controller;

import com.birly.backend.dto.billboard.BillboardItemDTO;
import com.birly.backend.dto.user.UserDTO;
import com.birly.backend.seeds.BillboardSeedService;
import com.birly.backend.seeds.UserSeedService;
import com.birly.backend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    /**
     * Sets up both users and db, in case you dropped all tables.
     */
    @PostMapping("/seed-all")
    public ResponseEntity<String> seedAll() {
        userSeedService.seedUsers();
        billboardSeedService.seedBillboardPosts();
        return ResponseEntity.ok("Seeding completed");
    }

    @PostMapping("/users")
    public ResponseEntity<List<UserDTO>> seedUsers() {
        userSeedService.seedUsers();
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.getAllUsers());
    }


    @PostMapping("/billboard-posts")
    public ResponseEntity<List<BillboardItemDTO>> seedBillboardPosts() {
        return ResponseEntity.status(HttpStatus.CREATED).body(billboardSeedService.seedBillboardPosts());
    }

}
