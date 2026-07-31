package com.birly.backend.entity;

import com.birly.backend.HousingAssociation;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "billboard_item")
public class BillboardItemEntity {

    @Id
    @Column(name = "billboard_item_id")
    private UUID billboardItemId;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private HousingAssociation housingAssociation;

    private UUID createdByUser;
    private Instant createdAt;

    // for JPA, it needs a no-arguments constructor
    protected BillboardItemEntity() {
    }

    public BillboardItemEntity(UUID billboardItemId, String title, String description,
                               HousingAssociation housingAssociation, UUID createdByUser, Instant createdAt) {
        this.billboardItemId = billboardItemId;
        this.title = title;
        this.description = description;
        this.housingAssociation = housingAssociation;
        this.createdByUser = createdByUser;
        this.createdAt = createdAt;
    }

    // getters and setters below
    public UUID getBillboardItemId() {
        return billboardItemId;
    }

    public void setBillboardItemId(UUID billboardItemId) {
        this.billboardItemId = billboardItemId;
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

    public UUID getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(UUID createdByUser) {
        this.createdByUser = createdByUser;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
