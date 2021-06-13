package io.microservices.moviecatalogservices.controller;

import io.microservices.moviecatalogservices.model.CatalogItem;
import io.microservices.moviecatalogservices.model.MovieInfo;
import io.microservices.moviecatalogservices.model.MovieRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("catalog")
public class MovieCatalogController {

    private final RestTemplate restTemplate;

    @Autowired
    public MovieCatalogController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping("{userId}")
    public List<CatalogItem> getCatalogItemsOfUser(@PathVariable("userId") Long userId){
        ParameterizedTypeReference<List<MovieRating>> typeReference = new ParameterizedTypeReference<>() {
        };
        List<MovieRating> movieRatings = restTemplate.exchange("http://rating-data-service/rating/"+userId, HttpMethod.GET,
                null, typeReference).getBody();

        if(movieRatings == null){
            throw new IllegalStateException("Empty movies collection");
        }

        return movieRatings.stream().map(movieRating -> {
            MovieInfo movieInfo = restTemplate.exchange("http://movie-info-service/info/"+movieRating.getMovieId(),
                    HttpMethod.GET, null, MovieInfo.class).getBody();

            return movieInfo != null? new CatalogItem(movieInfo.getMovieId(), movieInfo.getDesc(), movieInfo.getReleaseDate(), userId, movieRating.getRating()) : null;
        }).collect(Collectors.toList());
    }
}
