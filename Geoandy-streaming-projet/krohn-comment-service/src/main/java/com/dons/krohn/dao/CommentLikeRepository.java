package com.dons.krohn.dao;

import com.dons.krohn.entities.CommentLike;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CommentLikeRepository extends CassandraRepository<com.dons.krohn.entities.CommentLike,String> {
}
