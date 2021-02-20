package com.florindanciu.videorecommendationservice.service;

import com.florindanciu.videorecommendationservice.model.VideoRecommendation;
import com.florindanciu.videorecommendationservice.repository.VideoRecommendationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class VideoRecommendationService {

    private final VideoRecommendationRepository repository;
    private final Environment env;

    @Autowired
    public VideoRecommendationService(VideoRecommendationRepository repository, Environment env) {
        this.repository = repository;
        this.env = env;
    }

    public List<VideoRecommendation> getAllRecommendations() {
        return repository.findAll();
    }

    public List<VideoRecommendation> getRecommendationsByVideoId(Long videoId) {
        return repository.getAllByVideoId(videoId);
    }

    public void addRecommendation(VideoRecommendation recommendation) {
        log.info("Recommendation with video-id: " + recommendation.getVideoId() + " saved in DB at port: " + env.getProperty("server.port"));
        repository.save(recommendation);
    }
}
