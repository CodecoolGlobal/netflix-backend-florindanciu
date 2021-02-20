package com.florindanciu.videorecommendationservice.service;

import com.florindanciu.videorecommendationservice.model.VideoRecommendation;
import com.florindanciu.videorecommendationservice.repository.VideoRecommendationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static reactor.core.publisher.Mono.when;

@SpringBootTest
@AutoConfigureMockMvc
public class VideoRecommendationServiceTest {

    @MockBean
    private VideoRecommendationRepository repository;

    @Test
    void getAllRecommendations() {
    }

    @Test
    void getRecommendationsByVideoId() {
    }

    @Test
    void addRecommendation() {
    }
}