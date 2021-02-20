package com.florindanciu.videorecommendationservice.repository;

import com.florindanciu.videorecommendationservice.model.VideoRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRecommendationRepository extends JpaRepository<VideoRecommendation, Long> {
    List<VideoRecommendation> getAllByVideoId(Long videoId);
}
