package com.example.khaiapp.dataHandling;

import android.util.Log;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


/*
* All handling(receiving, parsing) with data from a server
*
* @ author Vinchester
* @ version 1.0
* @ from 27/04/2023
* */

public class dataHandling {

    /*
    * Getting List of subjects(type: String) from server
    *
    * @ Currently: unused
    * @ from 27/04/2023
    * */
    public static List<String> getSubjects() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/subjects";
        String response = restTemplate.getForObject(url, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        List<String> subjects = objectMapper.readValue(response, new TypeReference<List<String>>(){});
        Log.d("SubjectsTest", String.valueOf(subjects));
        return subjects;
    }

    /*
    * Getting List of tasks(type: List<String>) from server by giving subject name as argument
    *
    * @ currently: unused
    * @ from 28/04/2023
    */

    public static List<List<String>> getSubjectTasks(String subject) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format("http://localhost:8081/subjects/getTasks?subject=%s", subject);
        String response = restTemplate.getForObject(url, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        List<List<String>> tasks = objectMapper.readValue(response, (TypeReference<List<List<String>>>) new TypeReference<List<List<String>>>() {});
        Log.d("SubjectsTest", String.valueOf(tasks));
        return tasks;

    }

    /*
    * Giving same thing as getSubjectTasks would give
    *
    * @ currently: used
    * @ from 28/04/2023
    */


    public static List<List<String>> testGetSubjectTasks(String name){
        List<List<String>> tasks = new ArrayList<>();

        ArrayList<String> testTask1 = new ArrayList<>();
        testTask1.add(name);
        testTask1.add("Matrix");
        testTask1.add("http://518theBest");

        ArrayList<String> testTask2 = new ArrayList<>();
        testTask2.add(name);
        testTask2.add("Binary Tree");
        testTask2.add("http://518theBest");

        ArrayList<String> testTask3 = new ArrayList<>();
        testTask3.add(name);
        testTask3.add("Sorting");
        testTask3.add("http://518theBest");

        tasks.add(testTask1);
        tasks.add(testTask2);
        tasks.add(testTask3);

        return tasks;
    }

}
