package com.example.community_management.controller;

import com.example.community_management.dto.CommunityDTO;
import com.example.community_management.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/community")
@CrossOrigin
public class CommunityController {

    @Autowired
    private CommunityService communityService;

    @PostMapping(path = "/save")
    public String saveCommunity(@RequestBody CommunityDTO communityDTO) {
        return communityService.saveCommunity(communityDTO);
    }

    @PutMapping(path = "/update/{id}")
    public String updateCommunity(@PathVariable(value = "id") int communityId,
                                 @RequestBody CommunityDTO communityDTO) {
        communityDTO.setId(communityId); // Ensure the ID from path is set in DTO
        return communityService.updateCommunity(communityDTO);
    }

    @GetMapping(path = "/get-by-id/{id}")
    public CommunityDTO getCommunityById(@PathVariable(value = "id") int communityId) {
        return communityService.getCommunityById(communityId);
    }

    @GetMapping(path = "/get-all-communitys")
    public List<CommunityDTO> getAllCommunitys() {
        return communityService.getAllCommunitys();
    }

    @DeleteMapping(path = "/delete-community/{id}")
    public String deleteCommunity(@PathVariable(value = "id") int communityId) {
        return communityService.deleteCommunity(communityId);
    }

    @GetMapping(path = "/get-all-communitys-by-active-state/{status}")
    public List<CommunityDTO> getAllCommunitysByActiveState(
            @PathVariable(value = "status") boolean activeState) {
        return communityService.getAllCommunitysByActiveState(activeState);
    }
}