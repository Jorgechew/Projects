package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        Pojo pojo = mapper.readValue(new URL("https://ipinfo.io/json"), Pojo.class);

        String jsonString = mapper.writeValueAsString(pojo);

        System.out.println(jsonString);




    }
}