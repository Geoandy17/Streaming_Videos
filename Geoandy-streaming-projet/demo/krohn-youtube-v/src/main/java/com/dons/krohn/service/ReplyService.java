package com.dons.krohn.service;

import com.dons.krohn.entity.Reply;
import com.dons.krohn.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ReplyService {

    private ReplyRepository replyRepository;

    @Autowired
    public ReplyService(ReplyRepository replyRepository) {
        this.replyRepository = replyRepository;
    }

    public List<Reply> getReplies(){
        return replyRepository.findAll();
    }

    public List<Reply> getRepliesByCommentId(Long id){
        return replyRepository.findAllByCommentId(id);
    }

    public Reply postReply(Reply reply){
        return replyRepository.save(reply);
    }
}
