package com.birly.backend.dto;

import com.birly.backend.Union;

public class BillboardItemDTO {
    private String title;
    private String description;
    private final String id;
    private final Union union;
    private final String createdByUser;

    private BillboardItemDTO(Builder builder) {
        this.title = builder.title;
        this.description = builder.description;
        this.id = builder.id;
        this.union = builder.union;
        this.createdByUser = builder.createdByUser;
    }

    public static class Builder {
        private String title;
        private String description;
        private String id;
        private Union union;
        private String createdByUser;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder union(Union union) {
            this.union = union;
            return this;
        }

        public Builder createdByUser(String createdByUser) {
            this.createdByUser = createdByUser;
            return this;
        }

        public BillboardItemDTO build() {
            return new BillboardItemDTO(this);
        }

    }

    // getters

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
