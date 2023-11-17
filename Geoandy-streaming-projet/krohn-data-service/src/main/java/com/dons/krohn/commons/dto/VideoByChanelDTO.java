package com.dons.krohn.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class VideoByChanelDTO {
    private String chanelId;
    private String videoId;
}
