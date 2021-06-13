package io.microservices.ratingdataservices.controller;

import io.microservices.ratingdataservices.model.MovieRating;
import io.microservices.ratingdataservices.model.MovieUserRatingDataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("rating")
public class MovieRatingController {
    private final MovieUserRatingDataFactory factory;

    @Autowired
    public MovieRatingController(MovieUserRatingDataFactory factory) {
        this.factory = factory;
    }

    @RequestMapping("{userId}")
    public List<MovieRating> getMovieRatingsOfUser(@PathVariable("userId") Long userId){
        return factory.getMovieRatingListForUser(userId);
    }
}
