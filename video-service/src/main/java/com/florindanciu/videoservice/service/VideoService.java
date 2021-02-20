package com.florindanciu.videoservice.service;

import com.florindanciu.videoservice.model.Video;
import com.florindanciu.videoservice.model.VideoRecommendation;
import com.florindanciu.videoservice.repository.VideoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
@Slf4j
public class VideoService {

    private final VideoRepository videoRepository;
    private final VideoRecommendationCaller caller;
    private final Environment env;

    @Autowired
    public VideoService(VideoRepository videoRepository, VideoRecommendationCaller caller, Environment env) {
        this.videoRepository = videoRepository;
        this.caller = caller;
        this.env = env;
    }

    public List<Video> getAllVideos() {
        log.info("Retrieved all videos");
        return videoRepository.findAll();
    }

    public Video getVideoById(Long id) {
        log.info("Retrieved video with id " + id);
        return videoRepository.findById(id)
            .orElseThrow(
                    () -> new IllegalArgumentException(MessageFormat.format("Video with id {0} not found", id)
                    )
            );
    }

    public String addVideoRecommendation(Long videoId, VideoRecommendation recommendation) {
        recommendation.setVideoId(videoId);
        log.info("Recommendation with video-id: " + recommendation.getVideoId() + " saved through port: " + env.getProperty("server.port"));
        return caller.addRecommendation(recommendation);
    }

    public List getRecommendationsByVideoId(Long videoId) {
        return caller.getRecommendationsByVideoId(videoId);
    }

    public List getAllRecommendations() {
        return caller.getAllRecommendations();
    }
}
