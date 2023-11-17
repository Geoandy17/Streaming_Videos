package com.dons.krohn.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value = "like_by_comment")
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class CommentLike {
    @PrimaryKeyColumn(name="video_id", ordinal= 0, type= PrimaryKeyType.PARTITIONED)
    private String videoId;
    @PrimaryKeyColumn(name="commentId", ordinal= 1, type= PrimaryKeyType.PARTITIONED)
    private String commentId;
    @PrimaryKeyColumn(name="user_id", ordinal= 3, type= PrimaryKeyType.PARTITIONED)
    private String userId;
    private String commentText;
}
