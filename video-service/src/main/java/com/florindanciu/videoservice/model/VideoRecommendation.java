package com.florindanciu.videoservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VideoRecommendation {
    private String username;
    private int rating;
    private String comment;
    private Long videoId;
}
