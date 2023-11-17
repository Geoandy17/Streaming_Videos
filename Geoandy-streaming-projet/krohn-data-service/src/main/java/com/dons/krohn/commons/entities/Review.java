package com.dons.krohn.commons.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Review {
    @PrimaryKeyColumn(name="user_id", ordinal= 0, type= PrimaryKeyType.PARTITIONED)
    private String userId;
    @PrimaryKeyColumn(name="num_receiver", ordinal= 1, type= PrimaryKeyType.PARTITIONED)
    private String videoId;
    @Column(value = "body")
    private String body;
    @Column(value = "rating")
    private String rating;
}
