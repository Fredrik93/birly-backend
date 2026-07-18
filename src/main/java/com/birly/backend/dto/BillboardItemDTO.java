package com.birly.backend.dto;

import com.birly.backend.Union;

public class BillboardItemDTO {
    private String title;
    private String description;
    private final String id;
    private final Union union;
    private final String createdByUser;

    public BillboardItemDTO(String title, String description, String id, Union union, String createdByUser) {
        this.title = title;
        this.description = description;
        this.id = id;
        this.union = union;
        this.createdByUser = createdByUser;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getId() {
        return id;
    }

    public Union getUnion() {
        return union;
    }

    public String getCreatedByUser() {
        return createdByUser;
    }
}
