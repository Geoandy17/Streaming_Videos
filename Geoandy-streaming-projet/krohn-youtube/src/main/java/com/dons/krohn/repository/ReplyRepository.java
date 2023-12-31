package com.dons.krohn.repository;

import com.marcinwo.youtubeapi.demo.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {

    List<Reply> findAllByCommentId(Long id);
    List<Reply> findAllByUser_UserName(String s);
}
