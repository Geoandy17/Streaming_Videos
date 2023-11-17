package com.dons.krohn.dao;

import com.dons.krohn.entities.CommentByVideo;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CommentByVideoRepository extends CassandraRepository<CommentByVideo,String> {
}
