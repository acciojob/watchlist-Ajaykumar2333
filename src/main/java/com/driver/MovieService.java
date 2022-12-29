package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class MovieService {
    @Autowired
    MovieRepository movieRepository;



    //  add a movie
    String addMovie(Movie movie){
        String result = movieRepository.addMovie(movie);
        return  result;
    }

    //Add a director
    String addDirector(Director director){
        String result2 = movieRepository.addDirector(director);
        return result2;
    }

    //getmovie by movie name
    Movie getMovie(String moviename){
        Movie mov = movieRepository.getMovie(moviename);
        return mov;
    }

    //get director by director name
    Director getDirector(String directorName){
        Director dir = movieRepository.getDirector(directorName);
        return dir;
    }

    //making pair of director and movie

    public void makePair(String mov, String dir){
        movieRepository.makePair(mov,dir);
    }


    //Get List of movies name for a given director name
    public List<String> findMoviebydirector(String dir) {

        return movieRepository.getMovieByDirectorName(dir);
    }

    //get all movies
    public  List<String>  getAllmovies(){
        return movieRepository.allMovies();
    }

    //delete directors and there movies
    public  String deleteDirector(String  name){
       return movieRepository.deleteDirector(name);
    }

    //delete all directrors and all movies

    public String deleteallDirectorsMovies(){
        return movieRepository.deleteALlMovies();
    }



}
