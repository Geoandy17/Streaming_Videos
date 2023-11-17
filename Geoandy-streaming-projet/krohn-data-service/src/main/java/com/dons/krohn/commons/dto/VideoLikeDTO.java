package com.dons.krohn.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class VideoLikeDTO {
    private String userId;
    private String videoId;
    private String status;
}
