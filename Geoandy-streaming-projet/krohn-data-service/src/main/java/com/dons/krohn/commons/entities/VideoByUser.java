package com.dons.krohn.commons.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.build.ToStringPlugin;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.sql.Timestamp;
import java.util.Date;

@AllArgsConstructor @Data @NoArgsConstructor @ToStringPlugin.Enhance
public class VideoByUser {
    @PrimaryKeyColumn(name="video_id", ordinal= 0, type= PrimaryKeyType.PARTITIONED)
    private String title;
    @PrimaryKeyColumn(name="num_receiver", ordinal= 1, type= PrimaryKeyType.PARTITIONED)
    private String userId;
    @PrimaryKeyColumn(name="date", ordinal= 1, type= PrimaryKeyType.CLUSTERED,ordering = Ordering.DESCENDING)
    private Timestamp dateCreation;
    @Column(value = "slug")
    private String slug;
    @Column(value = "description")
    private String description;
    @Column(value = "image")
    private String image;
    @Column(value = "likes")
    private long likes;
    @Column(value = "dislikes")
    private long dislikes;
    @Column(value = "status")
    private String status;
}
