package com.dons.krohn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.sql.Timestamp;

@Table(value="like_by_video")
@Data @AllArgsConstructor @ToString @NoArgsConstructor
public class VideoLike {
    @PrimaryKeyColumn(name="video_id", ordinal= 0, type= PrimaryKeyType.PARTITIONED)
    private String videoId;
    @PrimaryKeyColumn(name="user_id", ordinal= 1, type= PrimaryKeyType.PARTITIONED)
    private String userId;
    @PrimaryKeyColumn(name="date_du_like", ordinal= 1, type= PrimaryKeyType.CLUSTERED,ordering = Ordering.DESCENDING)
    private Timestamp datePublication;
    @Column(value = "status")
    private String status;
}
