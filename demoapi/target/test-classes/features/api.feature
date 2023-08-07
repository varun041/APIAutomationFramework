Feature: Validating place API's
    @AddPlace  @API
    Scenario Outline: Verify if Add Place is being successfully added using AddPlaceAPI
        Given Add Place Payload with "<name>" "<language>"  "<address>"
        When User Calls "AddPlaceAPI" with "Post" Http Request
        Then API call is success with status code 200
        And "status" in response body is "OK"
        And "scope" in response body is "APP"


        Examples:
            | name        | language  | address                   |
            | Varun house | French-IN | 29, side layout, cohen 09 |


    @UpdatePlace @API
    Scenario Outline: Verify if Update Place is being successfully added using UpdatePlaceAPI
        Given Update Place Payload with "<address>"  "<key>"
        When User Calls "UpdatePlaceAPI" with "Put" Http Request
        Then API call is success with status code 200
        And "msg" in response body is "Address successfully updated"


        Examples:
            | address             | key        |
            | 70 Summer walk, USA | qaclick123 |


    @GetPlace @API
    Scenario Outline: Verify if Get Place is being successfully added using GetPlaceAPI
        Given Get Place Payload
        When User Calls "GetPlaceAPI" with "GET" Http Request
        Then API call is success with status code 200
        And "name" in response body is "Varun house"