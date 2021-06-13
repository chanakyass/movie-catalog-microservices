package io.microservices.ratingdataservices.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovieRating {
    private Long movieId;
    private Long userid;
    private Double rating;

}
