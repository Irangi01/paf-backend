package com.example.community_management.service.impl;

import com.example.community_management.dto.CommunityDTO;
import com.example.community_management.entity.Community;
import com.example.community_management.repository.CommunityRepository;
import com.example.community_management.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommunityServiceIMPL implements CommunityService {

    @Autowired
    private CommunityRepository communityRepository;

    @Override
    public String saveCommunity(CommunityDTO communityDTO) {
        Community community = new Community(
                communityDTO.getId(),
                communityDTO.getGroupName(),
                communityDTO.getDescription(),
                communityDTO.getCoverImage(),
                communityDTO.getCategory(),
                communityDTO.isActive()
        );
        community.setCreatedAt(LocalDateTime.now());
        communityRepository.save(community);
        return communityDTO.getGroupName() + " saved successfully";
    }

    @Override
    public String updateCommunity(CommunityDTO communityDTO) {
        if(communityRepository.existsById(communityDTO.getId())) {
            Community community = communityRepository.getReferenceById(communityDTO.getId());

            // Update all fields except createdAt
            community.setGroupName(communityDTO.getGroupName());
            community.setDescription(communityDTO.getDescription());
            community.setCoverImage(communityDTO.getCoverImage());
            community.setCategory(communityDTO.getCategory());
            community.setActive(communityDTO.isActive());
            community.setUpdatedAt(LocalDateTime.now());

            communityRepository.save(community);
            return communityDTO.getGroupName() + " updated successfully";
        } else {
            throw new RuntimeException("No community found with ID: " + communityDTO.getId());
        }
    }

    @Override
    public CommunityDTO getCommunityById(int communityId) {
        if(communityRepository.existsById(communityId)) {
            Community community = communityRepository.getReferenceById(communityId);
            return new CommunityDTO(
                    community.getId(),
                    community.getGroupName(),
                    community.getDescription(),
                    community.getCoverImage(),
                    community.getCategory(),
                    community.isActive()
            );
        } else {
            throw new RuntimeException("No community found with ID: " + communityId);
        }
    }

    @Override
    public List<CommunityDTO> getAllCommunitys() {
        List<Community> allCommunities = communityRepository.findAll();
        List<CommunityDTO> communityDTOList = new ArrayList<>();

        if(!allCommunities.isEmpty()) {
            for(Community community : allCommunities) {
                communityDTOList.add(new CommunityDTO(
                        community.getId(),
                        community.getGroupName(),
                        community.getDescription(),
                        community.getCoverImage(),
                        community.getCategory(),
                        community.isActive()
                ));
            }
            return communityDTOList;
        } else {
            throw new RuntimeException("No communities found");
        }
    }

    @Override
    public String deleteCommunity(int communityId) {
        if(communityRepository.existsById(communityId)) {
            communityRepository.deleteById(communityId);
            return "Community with ID: " + communityId + " deleted successfully";
        } else {
            throw new RuntimeException("No community found with ID: " + communityId);
        }
    }

    @Override
    public List<CommunityDTO> getAllCommunitysByActiveState(boolean activeState) {
        List<Community> activeCommunities = communityRepository.findAllByActiveEquals(activeState);
        List<CommunityDTO> communityDTOList = new ArrayList<>();

        if(!activeCommunities.isEmpty()) {
            for(Community community : activeCommunities) {
                communityDTOList.add(new CommunityDTO(
                        community.getId(),
                        community.getGroupName(),
                        community.getDescription(),
                        community.getCoverImage(),
                        community.getCategory(),
                        community.isActive()
                ));
            }
            return communityDTOList;
        } else {
            throw new RuntimeException("No " + (activeState ? "active" : "inactive") + " communities found");
        }
    }
}