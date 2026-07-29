package com.birly.backend.entity;

import com.birly.backend.HousingAssociation;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "billboard_item")
public class BillboardItemEntity {

    @Id
    private String id;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private HousingAssociation housingAssociation;

    private String createdByUser;
    private Instant createdAt;

    // for JPA, it needs a no-arguments constructor
    protected BillboardItemEntity() {
    }

    public BillboardItemEntity(String id, String title, String description,
                               HousingAssociation housingAssociation, String createdByUser, Instant createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.housingAssociation = housingAssociation;
        this.createdByUser = createdByUser;
        this.createdAt = createdAt;
    }

    // getters and setters below
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HousingAssociation getHousingAssociation() {
        return housingAssociation;
    }

    public void setHousingAssociation(HousingAssociation housingAssociation) {
        this.housingAssociation = housingAssociation;
    }

    public String getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(String createdByUser) {
        this.createdByUser = createdByUser;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
