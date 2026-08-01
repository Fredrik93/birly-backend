package com.birly.backend.controller;

import com.birly.backend.dto.user.UserDTO;
import com.birly.backend.dto.user.UserRequest;
import com.birly.backend.seeds.UserSeedService;
import com.birly.backend.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5174")
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final UserSeedService userSeedService;

    public UserController(UserService userService, UserSeedService userSeedService) {
        this.userService = userService;
        this.userSeedService = userSeedService;
    }

    @PostMapping("/create")
    public UserDTO createUser(@RequestBody UserRequest request) {

        return userService.save(request);
    }

    @PostMapping("/seed")
    public List<UserDTO> seedUsers() {
        userSeedService.seedUsers();
        return userService.getAllUsers();
    }
}
