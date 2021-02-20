package com.florindanciu.videorecommendationservice.model;

import com.google.inject.internal.asm.$Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class VideoRecommendation {

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private int rating;
    @Column(columnDefinition = "text")
    private String comment;
    private Long videoId;
}
