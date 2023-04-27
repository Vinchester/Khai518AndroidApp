package com.example.khaiapp.dataHandling;

import android.util.Log;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.client.RestTemplate;

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

}
