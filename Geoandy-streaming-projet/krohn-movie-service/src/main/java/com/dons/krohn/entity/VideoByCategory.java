package com.dons.krohn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value = "catagory_of_video")
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class VideoByCategory {
    @PrimaryKeyColumn(name="category", ordinal= 0, type= PrimaryKeyType.PARTITIONED)
    private String categoryName;
    private String descriptionCategory;
}
