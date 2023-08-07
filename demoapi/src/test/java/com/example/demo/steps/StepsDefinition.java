package com.example.demo.steps;

import java.io.IOException;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import com.example.demo.Enum.LocationAPI;
import com.example.demo.TestData.TestDataBuilder;
import com.example.demo.Utils.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class StepsDefinition extends Utils {
    RequestSpecification res;
    ResponseSpecification resspec;
    Response response;
    TestDataBuilder tdb = new TestDataBuilder();
    static String placeid;

    @Given("Add Place Payload with {string} {string}  {string}")
    public void add_place_payload_with(String name, String language, String address) throws IOException {
        // Write code here that turns the phrase above into concrete actions
        resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        res = given().spec(requestspecification())
                .body(tdb.addPlacePayload(name, language, address));
    }

    @Given("Update Place Payload with {string}  {string}")
    public void update_place_payload_with(String address, String key) throws IOException {
        // Write code here that turns the phrase above into concrete actions
        resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        res = given().spec(requestspecification())
                .body(tdb.updateplace(address, key, placeid));

    }

    @Given("Get Place Payload")
    public void get_place_payload() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        res = given().spec(requestspecification()).queryParam("place_id", placeid);
    }

    @When("User Calls {string} with {string} Http Request")
    public void user_calls_with_post_http_request(String api, String requesttype) {

        LocationAPI lap = LocationAPI.valueOf(api);
        System.out.println(lap.getresource());

        // Write code here that turns the phrase above into concrete actions
        if (requesttype.equalsIgnoreCase("POST") && api.equalsIgnoreCase("AddPlaceAPI")) {
            response = res.when().post(lap.getresource()).then().spec(resspec).extract().response();
            placeid = getJsonPath(response, "place_id");
        } else if (requesttype.equalsIgnoreCase("PUT")) {
            response = res.when().put(lap.getresource()).then().spec(resspec).extract().response();
        } else {
            response = res.when().get(lap.getresource()).then().spec(resspec).extract().response();
        }
    }

    @Then("API call is success with status code {int}")
    public void api_call_is_success_with_status_code(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        int code = response.getStatusCode();
        System.out.println(code);
        assertEquals(response.getStatusCode(), 200);
        String check = response.asString();
        System.out.println(check);

    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(String key, String value) {
        // Write code here that turns the phrase above into concrete actions
        String actualname = getJsonPath(response, key);
        System.out.println(actualname);
        assertEquals(actualname, value);
        System.out.println("Step Ended");
    }

}
