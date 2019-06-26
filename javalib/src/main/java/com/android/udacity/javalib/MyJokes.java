package com.android.udacity.javalib;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class MyJokes {

    private static List<String> jokes = Arrays.asList("Jokes 01","Jokes 02","Jokes 03","Jokes 04");

    private MyJokes(){};

    public static List<String> getJokes(){
        return jokes;
    }

    public static boolean addNewJoke(String joke){
        if(!StringUtils.isEmpty(joke)){
            return jokes.add(joke);
        }
        return false;
    }

}
