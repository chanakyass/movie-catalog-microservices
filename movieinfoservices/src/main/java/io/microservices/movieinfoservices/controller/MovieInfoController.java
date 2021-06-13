package io.microservices.movieinfoservices.controller;

import io.microservices.movieinfoservices.model.MovieInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("info")
public class MovieInfoController {
    @RequestMapping("{movieId}")
    public MovieInfo getMovieInfo(@PathVariable("movieId") Long movieId){
        int day = Math.toIntExact(movieId);
        return new MovieInfo(movieId, "Movie desc" + movieId, LocalDate.of(1990, 12, day));
    }
}
