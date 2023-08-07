package com.example.demo.Enum;

public enum LocationAPI {
    
    AddPlaceAPI("/maps/api/place/add/json"),
    GetPlaceAPI("/maps/api/place/get/json"),
    UpdatePlaceAPI("/maps/api/place/update/json");

    private String api;


    LocationAPI(String api){
this.api = api;
    }


    public String getresource(){
        return api;
    }
}
