package com.birly.backend.seeds;


import com.birly.backend.HousingAssociation;
import com.birly.backend.dto.user.UserDTO;
import com.birly.backend.dto.user.UserRequest;
import com.birly.backend.repository.UserRepository;
import com.birly.backend.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSeedService {
    private final UserService userService;
    private final UserRepository userRepository;

    public UserSeedService(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    public void seedUsers() {

        if (!userRepository.existsByApartmentNumber("1101")) {
            userService.save(new UserRequest(HousingAssociation.BANDLANDET, "1101"));
        }
        if (!userRepository.existsByApartmentNumber("1102")) {
            userService.save(new UserRequest(HousingAssociation.BANDLANDET, "1102"));
        }
        if (!userRepository.existsByApartmentNumber("2301")) {
            userService.save(new UserRequest(HousingAssociation.SKOGSMARDEN, "2301"));
        }
        if (!userRepository.existsByApartmentNumber("2302")) {
            userService.save(new UserRequest(HousingAssociation.SKOGSMARDEN, "2302"));
        }
        if (!userRepository.existsByApartmentNumber("9901")) {
            userService.save(new UserRequest(HousingAssociation.LINDSDAL, "9901"));
        }
    }
}
