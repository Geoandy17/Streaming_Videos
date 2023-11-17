package com.dons.krohn.dao;

import org.springframework.data.cassandra.repository.CassandraRepository;

public interface VideoByChanel extends CassandraRepository<VideoByChanel,String> {
}
