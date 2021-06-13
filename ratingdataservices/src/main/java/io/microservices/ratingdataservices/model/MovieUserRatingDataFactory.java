package io.microservices.ratingdataservices.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@AllArgsConstructor
@NoArgsConstructor
@Data
class MovieUserPair{
    private Long movieId;
    private Long userId;
}

@Service
public class MovieUserRatingDataFactory {
    private final Map<MovieUserPair, Double> movieUserRating;

    public MovieUserRatingDataFactory() {

        movieUserRating = new HashMap<>();
        for(long j = 1; j<=5; j++) {
            for (long i = 1; i <= 10; i++) {
                MovieUserPair mu = new MovieUserPair(i, j);
                movieUserRating.put(mu, 0.5 * i);
            }
        }
    }

    public List<MovieRating> getMovieRatingListForUser(Long userId){
        return movieUserRating.entrySet().stream().filter((entrySet -> entrySet.getKey().getUserId().equals(userId))).map(entrySet -> {
            MovieUserPair mu = entrySet.getKey();
            Double rating = entrySet.getValue();

            return new MovieRating(mu.getMovieId(), mu.getUserId(), rating);
        }).collect(Collectors.toList());
    }

}
