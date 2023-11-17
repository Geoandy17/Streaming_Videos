package com.dons.krohn.commons.entities;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.sql.Timestamp;

public class VideoByChanel {
    @PrimaryKeyColumn(name="chanel_id", ordinal= 0, type= PrimaryKeyType.PARTITIONED)
    private String chanelId;
    @PrimaryKeyColumn(name="video_id", ordinal= 1, type= PrimaryKeyType.PARTITIONED)
    private String videoId;
    @PrimaryKeyColumn(name="date", ordinal= 2, type= PrimaryKeyType.CLUSTERED,ordering = Ordering.DESCENDING)
    private Timestamp date;
}
