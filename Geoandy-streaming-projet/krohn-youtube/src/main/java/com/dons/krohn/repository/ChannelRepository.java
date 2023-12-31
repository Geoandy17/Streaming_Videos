package com.dons.krohn.repository;

import com.marcinwo.youtubeapi.demo.entity.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {

    List<Channel> findAllByUser_Id(Long id);

}
