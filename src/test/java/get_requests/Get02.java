package get_requests;

import groovyjarjarantlr4.v4.runtime.atn.SemanticContext;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;  //i stedet of given-->*

public class Get02 {

    //Print all "available" pets on console by using"https://petstore.swagger.io/" documentation.


/*
    Given
        https://petstore.swagger.io/v2/pet/findByStatus?status=available
    When
        User sends Get request to url
    Then
        HTTP status code is 200
    And
        Print all "available" path

    */

    @Test
    public void get02(){

   //set the url
    String url ="https://petstore.swagger.io/v2/pet/findByStatus?status=available";

    //set the expected data

    //send the request and get the response
        Response response = given().when().get(url);        //I am importing it from rest assure. It works just with get(url)

    //Print all "available" pets on the console
        response.prettyPrint();

    //Do assertion
    response.then().assertThat().statusCode(200);














    }

}
