package com.movie.service.movieService.service;

import com.movie.service.movieService.model.Movie;
import com.movie.service.movieService.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public String saveMovie(Movie movie){
        Movie savedMovie = movieRepository.save(movie);

        return "{" +
                "\"message\":"+"\"Successfully added Movie\",\n"+
                "\"data\":"+savedMovie+",\n"+
                "}";
    }

    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }

}

