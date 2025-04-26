package com.example.community_management.dto;

import java.time.LocalDateTime;

public class CommunityDTO {
    private int id;
    private String groupName;
    private String description;
    private String coverImage;
    private String category;  // e.g., CrossFit, Zumba
    private boolean active;

    // Constructors
    public CommunityDTO() {
    }

    public CommunityDTO(int id, String groupName, String description,
                        String coverImage, String category, boolean active) {
        this.id = id;
        this.groupName = groupName;
        this.description = description;
        this.coverImage = coverImage;
        this.category = category;
        this.active = active;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}