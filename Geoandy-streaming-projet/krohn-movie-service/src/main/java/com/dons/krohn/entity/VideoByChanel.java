package com.dons.krohn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.sql.Timestamp;

@AllArgsConstructor @Data @NoArgsConstructor @ToString
@Table(value = "video_by_chanel")
public class VideoByChanel {
    @PrimaryKeyColumn(name="chanel_id", ordinal= 0, type= PrimaryKeyType.PARTITIONED)
    private String chanelId;
    @PrimaryKeyColumn(name="video_id", ordinal= 1, type= PrimaryKeyType.PARTITIONED)
    private String videoId;
    @PrimaryKeyColumn(name="date", ordinal= 2, type= PrimaryKeyType.CLUSTERED,ordering = Ordering.DESCENDING)
    private Timestamp date;
}
