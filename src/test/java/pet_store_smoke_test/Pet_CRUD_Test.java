package pet_store_smoke_test;

import base_urls.PetStoreBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import pojos.Category;
import pojos.PetStorePet;
import pojos.PetStoreUserResponsePojo;
import pojos.Tags;
import java.io.IOException;
import java.util.ArrayList;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Pet_CRUD_Test  extends PetStoreBaseUrl {
    /*
  Given
      https://petstore.swagger.io/v2/pet
  And
      {
        "id": 1234321,
        "category": {
                  "id": 0,
                  "name": "Cat"
                },
        "name": "Pamuk",
        "photoUrls": [
          "string"
        ],
        "tags": [
          {
            "id": 0,
            "name": "My cute cat"
          }
        ],
        "status": "available"
      }
  When
      User sends Post request
  Then
      Http Status code is 200
  And
      Response body is like: {
                              "id": 1234321,
                              "category": {
                                  "id": 0,
                                  "name": "Cat"
                              },
                              "name": "Pamuk",
                              "photoUrls": [
                                  "string"
                              ],
                              "tags": [
                                  {
                                      "id": 0,
                                      "name": "My cute cat"
                                  }
                              ],
                              "status": "available"
                          }
   */
    @Test
    @Order(1)
    public void post01() throws IOException {
        //Set the url
        spec.pathParam("first","pet");

        //Set the expected data
        Category category = new Category(0,"Cat");
        Tags tags = new Tags(0,"My cute cat");
        ArrayList<String > arrayList = new ArrayList<>();
        arrayList.add("string");
        ArrayList<Tags> arrayListTags = new ArrayList<>();
        arrayListTags.add(tags);

        PetStorePet expectedData = new PetStorePet(1234321,category,"Pamuk",arrayList,arrayListTags,"available");
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();

        //Do assertion
        PetStorePet actualData = new ObjectMapper().readValue(response.asString(),PetStorePet.class);
        System.out.println("actualData = " + actualData);
        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getId(),actualData.getId());
        assertEquals(category.getId(),actualData.getCategory().getId());
        assertEquals(category.getName(),actualData.getCategory().getName());
        assertEquals(expectedData.getName(),actualData.getName());
        assertEquals(expectedData.getPhotoUrls(),expectedData.getPhotoUrls());
        assertEquals(tags.getId(),expectedData.getTags().get(0).getId());
        assertEquals(tags.getName(),expectedData.getTags().get(0).getName());
        assertEquals(expectedData.getStatus(),expectedData.getStatus());


    }

    /*
Given
   https://petstore.swagger.io/v2/pet
And
   {
     "id": 1234321,
     "category": {
       "id": 0,
       "name": "Cat"
     },
     "name": "Cotton",
     "photoUrls": [
       "string"
     ],
     "tags": [
       {
         "id": 0,
         "name": "My lovely cat"
       }
     ],
     "status": "available"
   }
When
   User sends Put request
Then
   Http Status code is 200
And
   Response body is like: {
                           "id": 1234321,
                           "category": {
                               "id": 0,
                               "name": "Cat"
                           },
                           "name": "Cotton",
                           "photoUrls": [
                               "string"
                           ],
                           "tags": [
                               {
                                   "id": 0,
                                   "name": "My lovely cat"
                               }
                           ],
                           "status": "available"
                       }
*/
    @Test
    @Order(2)
    public void put01() throws IOException {
        //Set the url
        spec.pathParam("first","pet");

        //Set the expected data
        Category category = new Category(0,"Cat");
        Tags tags = new Tags(0,"My lovely cat");
        ArrayList<String > arrayList = new ArrayList<>();
        arrayList.add("string");
        ArrayList<Tags> arrayListTags = new ArrayList<>();
        arrayListTags.add(tags);

        PetStorePet expectedData = new PetStorePet(1234321,category,"Cotton",arrayList,arrayListTags,"available");
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();

        //Do assertion
        PetStorePet actualData = new ObjectMapper().readValue(response.asString(),PetStorePet.class);

        System.out.println("actualData = " + actualData);
        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getId(),actualData.getId());
        assertEquals(category.getId(),actualData.getCategory().getId());
        assertEquals(category.getName(),actualData.getCategory().getName());
        assertEquals(expectedData.getName(),actualData.getName());
        assertEquals(expectedData.getPhotoUrls(),expectedData.getPhotoUrls());
        assertEquals(tags.getId(),expectedData.getTags().get(0).getId());
        assertEquals(tags.getName(),expectedData.getTags().get(0).getName());
        assertEquals(expectedData.getStatus(),expectedData.getStatus());

    }
    /*
     Given
         https://petstore.swagger.io/v2/pet/1234321
     When
         User sends Get request
     Then
         Http Status code is 200
     And
         Response body is like: {
                                 "id": 1234321,
                                 "category": {
                                     "id": 0,
                                     "name": "Cat"
                                 },
                                 "name": "Cotton",
                                 "photoUrls": [
                                     "string"
                                 ],
                                 "tags": [
                                     {
                                         "id": 0,
                                         "name": "My lovely cat"
                                     }
                                 ],
                                 "status": "available"
                             }
      */
    @Test
    @Order(3)
    public void get01() throws IOException {
        //Set the url
        spec.pathParams("first","pet","second",1234321);

        //Set the expected data
        Category category = new Category(0,"Cat");
        Tags tags = new Tags(0,"My lovely cat");
        ArrayList<String > arrayList = new ArrayList<>();
        arrayList.add("string");
        ArrayList<Tags> arrayListTags = new ArrayList<>();
        arrayListTags.add(tags);

        PetStorePet expectedData = new PetStorePet(1234321,category,"Cotton",arrayList,arrayListTags,"available");
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do assertion
        PetStorePet actualData = new ObjectMapper().readValue(response.asString(),PetStorePet.class);

        System.out.println("actualData = " + actualData);
        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getId(),actualData.getId());
        assertEquals(category.getId(),actualData.getCategory().getId());
        assertEquals(category.getName(),actualData.getCategory().getName());
        assertEquals(expectedData.getName(),actualData.getName());
        assertEquals(expectedData.getPhotoUrls(),expectedData.getPhotoUrls());
        assertEquals(tags.getId(),expectedData.getTags().get(0).getId());
        assertEquals(tags.getName(),expectedData.getTags().get(0).getName());
        assertEquals(expectedData.getStatus(),expectedData.getStatus());

    }
    /*
  Given
      https://petstore.swagger.io/v2/pet/1234321
  When
      User sends Delete request
  Then
      Http Status code is 200
  And
      Response body is like:{
                              "code": 200,
                              "type": "unknown",
                              "message": "1234321"
                            }
   */
    @Test
    @Order(4)
    public void delete01() throws IOException {
        //Set the url
        spec.pathParams("first", "pet", "second", 1234321);

        //Set the expected data
        PetStoreUserResponsePojo expectedData = new PetStoreUserResponsePojo(200,"unknown","1234321");
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given().spec(spec).when().delete("/{first}/{second}");
        response.prettyPrint();

        //Do assertion
        PetStoreUserResponsePojo actualData = new ObjectMapper().readValue(response.asString(), PetStoreUserResponsePojo.class);

        System.out.println("actualData = " + actualData);
        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getCode(),actualData.getCode());
        assertEquals(expectedData.getType(),actualData.getType());
        assertEquals(expectedData.getMessage(),actualData.getMessage());


    }
    /*
  Given
      https://petstore.swagger.io/v2/pet/1234321
  When
      User sends Delete request
  Then
      Http Status code is 200
  And
      Response body is like:{
                              "code": 200,
                              "type": "unknown",
                              "message": "1234321"
                            }
   */
    @Test
    @Order(5)
    public void get02() throws IOException {
        //Set the url
        spec.pathParams("first", "pet", "second", 1234321);

        //Set the expected data
        PetStoreUserResponsePojo expectedData = new PetStoreUserResponsePojo(1,"error","Pet not found");
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do assertion
        PetStoreUserResponsePojo actualData = new ObjectMapper().readValue(response.asString(), PetStoreUserResponsePojo.class);

        System.out.println("actualData = " + actualData);
        assertEquals(404, response.statusCode());
        assertEquals(expectedData.getCode(),actualData.getCode());
        assertEquals(expectedData.getType(),actualData.getType());
        assertEquals(expectedData.getMessage(),actualData.getMessage());

    }
}