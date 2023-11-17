package com.dons.krohn.dao;

import com.dons.krohn.entity.VideoByUser;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface VideoByUserRepository extends CassandraRepository<VideoByUser,String> {
}
