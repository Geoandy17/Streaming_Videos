package com.dons.krohn.mapper;

import com.dons.krohn.dto.CommentDTO;
import com.dons.krohn.entity.Comment;
import com.dons.krohn.entity.Film;
import com.dons.krohn.entity.User;
import com.dons.krohn.exeption.FilmNotFoundException;
import com.dons.krohn.exeption.UserNotFoundException;
import com.dons.krohn.repository.FilmRepository;
import com.dons.krohn.repository.UserRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class CommentMapper {

    private UserRepository userRepository;
    private FilmRepository filmRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setFilmRepository(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Mappings({
            @Mapping(target = "filmId", source = "film.id"),
            @Mapping(target = "userId", source = "user.id")
    })
    public abstract CommentDTO toCommentDTO(Comment comment);

    public abstract List<CommentDTO> toCommentDTO(Collection<Comment> comments);

    public Comment toCommentEntity(CommentDTO commentDTO) {
        Comment comment = new Comment();

        User user = userRepository.findById(commentDTO.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        comment.setUser(user);

        Film film = filmRepository.findById(commentDTO.getFilmId())
                .orElseThrow(() -> new FilmNotFoundException("Film not found"));
        comment.setFilm(film);

        comment.setLikes(commentDTO.getLikes());
        comment.setDislikes(commentDTO.getDislikes());

        comment.setContent(commentDTO.getContent());
        comment.setUpdatedAt(commentDTO.getUpdatedAt());
        comment.setCreatedAt(commentDTO.getCreatedAt());

        return comment;
    }

}
