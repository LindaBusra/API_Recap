package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PetStoreAuthentication {

    public static void main(String[] args) {
        System.out.println(generateToken());
    }

    public static String generateToken(){

        Map<String ,Object> json = new HashMap<>();
        json.put("password","John.123");
        json.put("rememberMe",true);
        json.put("username","john_doe");

        Response response = given().contentType(ContentType.JSON).body(json).when().post("https://petstore.swagger.io/v2");
        return response.jsonPath().getString("id_token");
    }
}


