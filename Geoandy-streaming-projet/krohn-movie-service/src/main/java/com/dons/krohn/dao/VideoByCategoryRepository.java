package com.dons.krohn.dao;

import com.dons.krohn.entity.VideoByCategory;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface VideoByCategoryRepository extends CassandraRepository<VideoByCategory,String> {
}
