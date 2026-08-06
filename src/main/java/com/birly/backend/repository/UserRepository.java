package com.birly.backend.repository;

import com.birly.backend.domain.HousingAssociation;
import com.birly.backend.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findUserByApartmentNumber(String apartmentNumber);

    List<UserEntity> findAllByHousingAssociation(HousingAssociation housingAssociation);
}
