package com.dons.krohn.commons.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.util.Date;

@Data
@AllArgsConstructor @NoArgsConstructor @ToString
public class ChanelByUser {
    @PrimaryKeyColumn(name="chanel_name", ordinal= 0, type= PrimaryKeyType.PARTITIONED)
    private String nameChanel;
    @PrimaryKeyColumn(name="user_id", ordinal= 1, type= PrimaryKeyType.PARTITIONED)
    private String userId;
    @Column(value = "description")
    private String description;
    @PrimaryKeyColumn(name="date", ordinal= 2, type= PrimaryKeyType.CLUSTERED,ordering = Ordering.DESCENDING)
    private Date dateCreation;
}
