package com.florindanciu.videoservice.service;

import com.florindanciu.videoservice.model.VideoRecommendation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class VideoRecommendationCaller {

    @Value("${netflix-video-recommendation.url}")
    private String baseUrl;

    private final RestTemplate restTemplate;

    @Autowired
    public VideoRecommendationCaller(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String addRecommendation(VideoRecommendation recommendation) {
        log.info("Video Recommendation Caller: Recommendation saved for video with id " + recommendation.getVideoId());
        return restTemplate.postForEntity(baseUrl + "/save", recommendation, String.class).getBody();
    }

    public List getRecommendationsByVideoId(Long videoId) {
        log.info("Video Recommendation Caller: Recommendation retrieved.");
        return restTemplate.getForEntity(baseUrl + "/video/" + videoId, List.class).getBody();
    }

    public List getAllRecommendations() {
        return restTemplate.getForEntity(baseUrl, List.class).getBody();
    }
}
