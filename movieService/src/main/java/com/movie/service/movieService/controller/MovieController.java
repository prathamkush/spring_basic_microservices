package com.movie.service.movieService.controller;

import com.movie.service.movieService.model.Movie;
import com.movie.service.movieService.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("movie")
public class MovieController {

    private MovieService service;

    @Autowired
    public MovieController(MovieService service){
        this.service = service;
    }

    @PostMapping("/add-movie")
    public String saveMovie(@RequestBody Movie movie){
        return service.saveMovie(movie);
    }

    @GetMapping("/get-movies")
    public List<Movie> getMovies(){
        return service.getMovies();
    }
}

