package com.birly.backend.entity;

import com.birly.backend.Union;
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
    @Column(name = "\"union\"")
    private Union union;

    private String createdByUser;
    private Instant createdAt;

    // for JPA, it needs a no-arguments constructor
    protected BillboardItemEntity(){}
    public BillboardItemEntity(String id, String title, String description,
                               Union union, String createdByUser, Instant createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.union = union;
        this.createdByUser = createdByUser;
        this.createdAt = createdAt;
    }

    // getters and setters below
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Union getUnion() { return union; }
    public void setUnion(Union union) { this.union = union; }
    public String getCreatedByUser() { return createdByUser; }
    public void setCreatedByUser(String createdByUser) { this.createdByUser = createdByUser; }
    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }

}
