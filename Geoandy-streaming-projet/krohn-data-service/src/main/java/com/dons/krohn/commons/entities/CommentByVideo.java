package com.dons.krohn.commons.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.sql.Timestamp;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class CommentByVideo {
    @PrimaryKeyColumn(name="video_id", ordinal= 0, type= PrimaryKeyType.PARTITIONED)
    private String videoId;
    @PrimaryKeyColumn(name="user_id", ordinal= 1, type= PrimaryKeyType.PARTITIONED)
    private String userId;
    private String commentText;
    @PrimaryKeyColumn(name="date_comment", ordinal= 2, type= PrimaryKeyType.CLUSTERED,ordering = Ordering.DESCENDING)
    private Timestamp dateComment;
    @Column(value = "parent_id")
    private String parendId;
    @Column(value = "replied_to_id")
    private String repliedToId;
}
