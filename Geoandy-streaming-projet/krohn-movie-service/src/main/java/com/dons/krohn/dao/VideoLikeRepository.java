package com.dons.krohn.dao;

import com.dons.krohn.entity.VideoLike;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface VideoLikeRepository extends CassandraRepository<VideoLike,String> {
}
