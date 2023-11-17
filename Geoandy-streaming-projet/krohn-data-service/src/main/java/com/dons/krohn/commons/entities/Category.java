package com.dons.krohn.commons.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

@AllArgsConstructor @Data @NoArgsConstructor @ToString
public class Category {
    @PrimaryKeyColumn(name="category_name", ordinal= 0, type= PrimaryKeyType.PARTITIONED)
    private String nameCategory;
    private String description;
}
