package com.dons.krohn.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor @Data @NoArgsConstructor @ToString
public class ChanelByUserDTO {
    private String videoId;
    private String userId;
    private String commentText;
    private String parendId;
    private String repliedToId;
}
