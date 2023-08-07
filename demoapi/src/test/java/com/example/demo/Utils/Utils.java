package com.example.demo.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
   public static RequestSpecification req;

    public RequestSpecification requestspecification() throws IOException {
        if (req == null) {
            PrintStream log = new PrintStream(new FileOutputStream("log.txt"));
            req = new RequestSpecBuilder().setBaseUri(getglobalvalue("baseURL"))
                    .addQueryParam("key", "qaclick123")
                    .setContentType(ContentType.JSON)
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .build();
            return req;
        }
        return req;
    }

    public String getglobalvalue(String key) throws IOException {
        Properties prop = new Properties();
        FileInputStream fs = new FileInputStream(
                "/Users/varunoberoi/Java/demoapi/demoapi/src/main/java/com/example/demo/global/global.properties");
        prop.load(fs);
        return prop.getProperty(key);

    }

    public String getJsonPath(Response response, String key){
  String responsebody = response.asPrettyString();
        JsonPath js = new JsonPath(responsebody);
        String b = js.getString(key).toString();
       System.out.println(b);
        return b;
    }
}
