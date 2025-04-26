package com.example.community_management.repository;

import com.example.community_management.entity.Community;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface CommunityRepository extends JpaRepository<Community, Integer> {
    List<Community> findAllByActiveEquals(boolean activeState);
}
