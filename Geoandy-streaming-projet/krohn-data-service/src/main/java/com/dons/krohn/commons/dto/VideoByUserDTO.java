package com.dons.krohn.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor @NoArgsConstructor @Data @ToString
public class VideoByUserDTO {
    private String title;
    private String userId;
    private String slug;
    private String description;
    private String image;
    private long likes;
    private long dislikes;
    private String status;
}
