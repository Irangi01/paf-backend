package com.example.community_management.service;

import com.example.community_management.dto.CommunityDTO;
import java.util.List;

public interface CommunityService {
    String saveCommunity(CommunityDTO communityDTO);
    String updateCommunity(CommunityDTO communityDTO); // Implementation will use the ID from DTO
    CommunityDTO getCommunityById(int communityId);
    List<CommunityDTO> getAllCommunitys();
    String deleteCommunity(int communityId);
    List<CommunityDTO> getAllCommunitysByActiveState(boolean activeState);
}