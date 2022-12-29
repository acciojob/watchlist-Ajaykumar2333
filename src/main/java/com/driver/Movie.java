package com.driver;

public class Movie {
    String name;
    int numberOfMovies;
    double imdbRating;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfMovies() {
        return numberOfMovies;
    }

    public void setNumberOfMovies(int numberOfMovies) {
        this.numberOfMovies = numberOfMovies;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public Movie(){

    }

    public  Movie(   String name,int numberOfMovies,double imdbRating){
        this.numberOfMovies = numberOfMovies;
        this.name = name;
        this.imdbRating = imdbRating;
    }
}
