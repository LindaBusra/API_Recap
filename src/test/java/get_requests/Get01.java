package get_requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Get01 {
    /*
   Given
       https://petstore.swagger.io/v2/pet/12
   When
       User sends a GET Request to the url
   Then
       HTTP Status Code should be 200
   And
       Content Type should be JSON
   And
       Status Line should be HTTP/1.1 200 OK
*/


    public static void main(String[] args) {


        //set the url
        String url = "https://petstore.swagger.io/v2/pet/112233";

        //set the expexted data

        //send the request and get the response
        Response response = given().when().get(url);   //which library do you use for API test : rest assured library
        response.prettyPrint();


        //Do assertion
        //HTTP Status Code should be 200
        if(response.statusCode()==200) {
            System.out.println("Test Passed: Status code is 200" );
        } else {
            System.out.println("Test failed: Status code " + response.statusCode());
        }

        //Content Type should be JSON
        if(response.contentType().equals("application/json")) {
            System.out.println("Test Passed: Content type is Json" );
        } else {
            System.out.println("Test failed: Content type " + response.contentType());
        }

        //Status Line should be HTTP/1.1 200 OK
        if(response.statusLine().equals("HTTP/1.1 200 OK")) {
            System.out.println("Test Passed: Status Line HTTP/1.1 200 OK" );
        } else {
            System.out.println("Test failed: Status Line " + response.statusLine());
        }


    }












}
