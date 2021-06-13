package io.microservices.moviecatalogservices.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovieInfo {
    private Long movieId;
    private String desc;
    private LocalDate releaseDate;
}
