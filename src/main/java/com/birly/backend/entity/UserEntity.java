package com.birly.backend.entity;

import com.birly.backend.domain.HousingAssociation;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    private UUID userId;

    @Enumerated(EnumType.STRING)
    private HousingAssociation housingAssociation;

    private String apartmentNumber;

    // JPA needs no-args constructor
    protected UserEntity(){}

    public UserEntity(UUID userId, HousingAssociation housingAssociation, String apartmentNumber) {
        this.userId = userId;
        this.housingAssociation = housingAssociation;
        this.apartmentNumber = apartmentNumber;
    }

    public UUID getUserId() {
        return userId;
    }

    public HousingAssociation getHousingAssociation() {
        return housingAssociation;
    }

    public void setHousingAssociation(HousingAssociation housingAssociation) {
        this.housingAssociation = housingAssociation;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }
}
