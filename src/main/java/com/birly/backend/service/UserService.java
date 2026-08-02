package com.birly.backend.service;

import com.birly.backend.HousingAssociation;
import com.birly.backend.converter.UserConverter;
import com.birly.backend.dto.user.UserDTO;
import com.birly.backend.dto.user.UserRequest;
import com.birly.backend.entity.UserEntity;
import com.birly.backend.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO save(UserRequest request) {
        UserDTO dto = new UserDTO(UUID.randomUUID(), request.housingAssociation(), request.apartmentNumber());
        UserEntity saved = userRepository.save(UserConverter.toEntity(dto));
        return UserConverter.toDTO(saved);
    }

    public UserDTO getUserById(UUID userId) {
        UserEntity entity = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found: " + userId));
        return UserConverter.toDTO(entity);
    }

    public List<UserDTO> getAllUsers() {
        List<UserEntity> entities = userRepository.findAll();
        return entities.stream().map(UserConverter::toDTO).toList();
    }

    public List<UserDTO> getUsersInHousingAssociation(HousingAssociation housingAssociation) {
        return userRepository.findAllByHousingAssociation(housingAssociation).stream().map(UserConverter::toDTO).toList();
    }

    public boolean userExist(String apartmentNumber) {
        return userRepository.findUserByApartmentNumber(apartmentNumber).isEmpty();
    }

}
