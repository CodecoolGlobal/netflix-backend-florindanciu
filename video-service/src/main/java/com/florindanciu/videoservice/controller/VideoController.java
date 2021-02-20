package com.florindanciu.videoservice.controller;


import com.florindanciu.videoservice.model.Video;
import com.florindanciu.videoservice.model.VideoRecommendation;
import com.florindanciu.videoservice.service.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/")
@CrossOrigin(origins = "*", maxAge = 3600)
public class VideoController {

    private final VideoService service;

    @Autowired
    public VideoController(VideoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Video> getAllVideos() {
        return service.getAllVideos();
    }

    @GetMapping("/videoId/{id}")
    public Video getVideoById(@PathVariable String id) {
        Long videoId = Long.parseLong(id);
        return service.getVideoById(videoId);
    }

    @GetMapping("recommendations")
    public List getAllRecommendations() {
        return service.getAllRecommendations();
    }

    @GetMapping("recommendations/{videoId}")
    public List getRecommendationsByVideoId(@PathVariable Long videoId) {
        return service.getRecommendationsByVideoId(videoId);
    }

    @PostMapping("recommendation/{videoId}")
    public ResponseEntity<?> addRecommendation(@PathVariable Long videoId, @RequestBody VideoRecommendation recommendation) {
        return ResponseEntity
                .accepted()
                .body(service.addVideoRecommendation(videoId, recommendation));
    }
}
