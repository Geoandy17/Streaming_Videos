package com.dons.krohn.mapper;


import com.dons.krohn.dto.ReplyDTO;
import com.dons.krohn.entity.Comment;
import com.dons.krohn.entity.Reply;
import com.dons.krohn.entity.User;
import com.dons.krohn.exeption.CommentNotFoundException;
import com.dons.krohn.exeption.UserNotFoundException;
import com.dons.krohn.repository.CommentRepository;
import com.dons.krohn.repository.UserRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ReplyMapper {

    private UserRepository userRepository;
    private CommentRepository commentRepository;

    @Autowired
    public void setCommentRepository(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Mappings({
            @Mapping(target = "userId", source ="user.id"),
            @Mapping(target = "commentId", source ="comment.id")
    })
    public abstract ReplyDTO toReplyDTO(Reply reply);
    public abstract List<ReplyDTO> toReplyDTO(Collection<Reply> reply);

    public Reply toReplyEntity(ReplyDTO replyDTO){
        Reply reply = new Reply();

        User user = userRepository.findById(replyDTO.getUserId()).orElseThrow(()-> new UserNotFoundException("User nor found."));
        reply.setUser(user);

        Comment comment = commentRepository.findById(replyDTO.getCommentId()).orElseThrow(()-> new CommentNotFoundException("Comment nor found."));
        reply.setComment(comment);

        reply.setContent(replyDTO.getContent());
        reply.setCreatedAt(replyDTO.getCreatedAt());
        reply.setDislikes(replyDTO.getDislikes());
        reply.setLikes(replyDTO.getLikes());

        return reply;
    }
}

