package com.dons.krohn.controller;

import com.marcinwo.youtubeapi.demo.ApiInformation;
import com.marcinwo.youtubeapi.demo.dto.UserWatchedFilmDTO;
import com.marcinwo.youtubeapi.demo.entity.UserWatchedFilm;
import com.marcinwo.youtubeapi.demo.mapper.UserWatchedFilmMapper;
import com.marcinwo.youtubeapi.demo.service.UserWatchedFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserWatchedFilmController {

    private UserWatchedFilmService userWatchedFilmService;
    private UserWatchedFilmMapper userWatchedFilmMapper;

    @Autowired
    public UserWatchedFilmController(UserWatchedFilmService userWatchedFilmService, UserWatchedFilmMapper userWatchedFilmMapper) {
        this.userWatchedFilmService = userWatchedFilmService;
        this.userWatchedFilmMapper = userWatchedFilmMapper;
    }

    @GetMapping("/watchedHistory")
    public List<UserWatchedFilmDTO> getWatchedFilms() {
        return userWatchedFilmMapper.toUserWatchedFilmDTO(userWatchedFilmService.getWatchedFilms());
    }


    @GetMapping("/users/{id}/watchedHistory")
    public List<UserWatchedFilmDTO> getWatchedFilmsByUserId(@PathVariable Long id) {
        return userWatchedFilmMapper.toUserWatchedFilmDTO(userWatchedFilmService.getWatchedFilmsByUserId(id));
    }


    @PostMapping("/watchedHistory")
    public UserWatchedFilmDTO postWatchedFilm(@RequestBody UserWatchedFilmDTO userWatchedFilmDTO){
        return userWatchedFilmMapper.toUserWatchedFilmDTO(userWatchedFilmService.postWatchedFilm(userWatchedFilmMapper.toUserWatchedFilmEntity(userWatchedFilmDTO)));
    }


    @DeleteMapping("/users/{id}/watchedHistory")
    public ApiInformation deleteWatchedFilmsByUserId(@PathVariable Long id){
        userWatchedFilmService.deleteWatchedFilmsByUserId(id);
        return new ApiInformation("Deleted all watched history.", HttpStatus.OK.value());
    }



}
