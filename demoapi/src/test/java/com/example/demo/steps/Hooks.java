package com.example.demo.steps;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
    @Before("@UpdatePlace")
    public void beforeScenario() throws IOException{
        StepsDefinition sf = new StepsDefinition();
        if(StepsDefinition.placeid==null){
        sf.add_place_payload_with("Rajat House", "English", "India");
        sf.user_calls_with_post_http_request("AddPlaceAPI",  "Post");
        }
    }
}
