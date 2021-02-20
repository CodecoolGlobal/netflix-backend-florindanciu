package com.florindanciu.videorecommendationservice.controller;

import com.florindanciu.videorecommendationservice.model.VideoRecommendation;
import com.florindanciu.videorecommendationservice.service.VideoRecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/")
public class VideoRecommendationController {

    private final VideoRecommendationService service;

    @Autowired
    public VideoRecommendationController(VideoRecommendationService service) {
        this.service = service;
    }

    @GetMapping
    public List<VideoRecommendation> getAllRecommendations() {
        return service.getAllRecommendations();
    }

    @GetMapping("video/{videoId}")
    public List<VideoRecommendation> getRecommendationsByVideoId(@PathVariable Long videoId) {
        return service.getRecommendationsByVideoId(videoId);
    }

    @PostMapping("save")
    public ResponseEntity<?> addRecommendation(@RequestBody VideoRecommendation recommendation) {
        service.addRecommendation(recommendation);
        return ResponseEntity
                .accepted()
                .body("Video recommendation saved in video-recommendation DB");
    }
}
