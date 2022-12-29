package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


@Repository

public class MovieRepository {


   HashMap<String,Movie> map1 = new HashMap<>();
    HashMap<String, Director> map2 = new HashMap<String, Director>();


    HashMap<String, ArrayList<String>> pairmap = new HashMap<>();




    public String addMovie(Movie movie){
       String key = movie.getName();
       map1.put(key,movie);
        return "added succesfully";
    }
    public String addDirector(Director director){
       String key = director.getName();
        map2.put(key,director);
        return "added Succesfully";
    }
    public void makePair(String mName, String dName) {
        if(map1.containsKey(mName) && map2.containsKey(dName)) {
            ArrayList<String> movieList = new ArrayList<>();
            if(pairmap.containsKey(dName))
            movieList = pairmap.get(dName);
            movieList.add(mName);
            pairmap.put(dName, movieList);
        }
    }

    public Movie getMovie(String mName) {
        return map1.get(mName);
    }

    public Director getDirector(String dName) {
        return map2.get(dName);
    }




    public List<String> getMovieByDirectorName(String name) {
        List<String> resList = new ArrayList<>();

        if(pairmap.containsKey(name))
            resList =  pairmap.get((name));

        return resList;
    }





    public List<String> allMovies() {
        return new ArrayList<>(map1.keySet());
    }




    public String  deleteDirector(String name) {


        ArrayList<String> list = new ArrayList<>();

        if(pairmap.containsKey(name)) {
            list = pairmap.get(name);

            for(String i: list) {
                if(map1.containsKey(i))
                    map1.remove(i);
            }

            pairmap.remove(name);
        }

        if(map2 .containsKey(name))
            map2.remove(name);


        return "removedd director succesfully";
    }



    public String deleteALlMovies() {
        HashSet<String> movies = new HashSet<>();

        for(String directors: pairmap.keySet()) {
            for(String movie: pairmap.get(directors)) {
                movies.add(movie);
            }
        }

        for(String i: movies) {
            if(map1.containsKey(i)) {
                map1.remove(i);
            }
        }
        return  "removed successfully";

    }


}

