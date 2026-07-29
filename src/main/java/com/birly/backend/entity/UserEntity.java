package com.birly.backend.entity;

import com.birly.backend.HousingAssociation;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    private String userId;

    @Enumerated(EnumType.STRING)
    private HousingAssociation housingAssociation;

    // JPA needs no-args constructor
    protected UserEntity(){}

    public UserEntity(String userId, HousingAssociation housingAssociation) {
        this.userId = userId;
        this.housingAssociation = housingAssociation;
    }

    public String getUserId() {
        return userId;
    }

    public HousingAssociation getHousingAssociation() {
        return housingAssociation;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setHousingAssociation(HousingAssociation housingAssociation) {
        this.housingAssociation = housingAssociation;
    }
}
