package com.example.demo.TestData;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.pojo.AddPlace;
import com.example.demo.pojo.Location;
import com.example.demo.pojo.UpdatePlace;

public class TestDataBuilder {

    public AddPlace addPlacePayload(String name, String language, String address) {
        AddPlace p = new AddPlace();
        p.setAccuracy(50);
        p.setAddress(address);
        p.setLanguage(language);
        p.setPhone_number("(+91) 983 893 3937");
        p.setWebsite("https://rahulshettyacademy.com");
        p.setName(name);
        List<String> myList = new ArrayList<String>();
        myList.add("shoe park");
        myList.add("shop");

        p.setTypes(myList);
        Location l = new Location();
        l.setLat(-38.383494);
        l.setLng(33.427362);
        p.setLocation(l);
        return p;
    }

    public UpdatePlace updateplace(String address, String key, String placeid) {
        UpdatePlace up = new UpdatePlace();
        up.setPlace_id(placeid);
        up.setAddress(address);
        up.setKey(key);
        return up;
    }

}
