package com.dons.krohn.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class ReviewDTO {
    private String userId;
    private String videoId;
    private String body;
    private String rating;
}
