package com.dons.krohn.mapper;


import com.dons.krohn.dto.UserWatchedFilmDTO;
import com.dons.krohn.entity.Film;
import com.dons.krohn.entity.User;
import com.dons.krohn.entity.UserWatchedFilm;
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
public abstract class UserWatchedFilmMapper {

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
    public abstract UserWatchedFilmDTO toUserWatchedFilmDTO(UserWatchedFilm userWatchedFilm);

    public abstract List<UserWatchedFilmDTO> toUserWatchedFilmDTO(Collection<UserWatchedFilm> watchedFilms);


    public UserWatchedFilm toUserWatchedFilmEntity(UserWatchedFilmDTO userWatchedFilmDTO) {
        UserWatchedFilm userWatchedFilm = new UserWatchedFilm();
        Film film = filmRepository.findById(userWatchedFilmDTO.getFilmId()).orElseThrow(() -> new FilmNotFoundException("Film not found."));
        User user = userRepository.findById(userWatchedFilmDTO.getUserId()).orElseThrow(() -> new UserNotFoundException("User nor found."));
        userWatchedFilm.setFilm(film);
        userWatchedFilm.setUser(user);
        userWatchedFilm.setTimeSpentForWatching(userWatchedFilmDTO.getTimeSpentForWatching());
        userWatchedFilm.setEndedAt(userWatchedFilmDTO.getEndedAt());
        userWatchedFilm.setStartedAt(userWatchedFilmDTO.getStartedAt());
        return userWatchedFilm;
    }


}
