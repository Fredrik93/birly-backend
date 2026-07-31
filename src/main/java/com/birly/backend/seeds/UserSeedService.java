package com.birly.backend.seeds;


import com.birly.backend.HousingAssociation;
import com.birly.backend.dto.user.UserDTO;
import com.birly.backend.dto.user.UserRequest;
import com.birly.backend.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSeedService {
    private final UserService userService;

    public UserSeedService(UserService userService) {
        this.userService = userService;
    }

    public void seedUsers() {
        List<UserDTO> users = userService.getAllUsers();

        if (users.isEmpty()) {
            userService.save(new UserRequest(HousingAssociation.BANDLANDET, "1101"));
            userService.save(new UserRequest(HousingAssociation.BANDLANDET, "1102"));
            userService.save(new UserRequest(HousingAssociation.SKOGSMARDEN, "2301"));
            userService.save(new UserRequest(HousingAssociation.SKOGSMARDEN, "2302"));
            userService.save(new UserRequest(HousingAssociation.LINDSDAL, "9901"));
        }
    }
}
