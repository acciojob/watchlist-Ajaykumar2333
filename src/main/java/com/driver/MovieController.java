package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping(value = "/addMovie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie) {
        String newMovie = movieService.addMovie(movie);
        return new ResponseEntity<>(newMovie, HttpStatus.CREATED);

    }

    @PostMapping(value = "/addDirector")
    public ResponseEntity<String> addDirector(@RequestBody Director director) {
        String newDirector = movieService.addDirector(director);
        return new ResponseEntity<>(newDirector, HttpStatus.CREATED);

    }


    @GetMapping("get_by_path/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String moviename) {
        Movie movie = movieService.getMovie(moviename);
        if (movie == null) {
            return new ResponseEntity<>(movie, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(movie, HttpStatus.OK);
        }

    }


    @GetMapping("getbypath/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String directorName) {
        Director dir = movieService.getDirector(directorName);
        if (dir == null) {
            return new ResponseEntity<>(dir, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(dir, HttpStatus.OK);
        }


    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie") String mName, @RequestParam("director")String dName) {
        movieService.makePair(mName,dName);

        return new ResponseEntity("new movie-pair added succesfully", HttpStatus.CREATED);
    }
    @GetMapping("/get-movies-by-director-name")
    public ResponseEntity <List<String>> getMoviesByDirectorName(@RequestParam String dirname)
    {

        List<String> movies=movieService.findMoviebydirector(dirname);
        return new ResponseEntity<>(movies,HttpStatus.OK);

    }


    @GetMapping("get-all-movies")
    public ResponseEntity <List<String>> findAllMovies  ()
    {

        List<String> movies=movieService.getAllmovies();
        return new ResponseEntity<>(movies,HttpStatus.OK);

    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String>deleteDirectorByName(@RequestParam String name) {
        String str = movieService.deleteDirector(name);
        return new ResponseEntity(name+" "+ str, HttpStatus.CREATED);
    }
    @DeleteMapping("/deleteAllDirectors")
    public ResponseEntity deleteAllDirectors() {
       String str =  movieService.deleteallDirectorsMovies();
        return new ResponseEntity(str, HttpStatus.OK);
    }





}
