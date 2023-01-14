package get_requests;

import base_urls.AutomationExerciseBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Get05 extends AutomationExerciseBaseUrl {


/*
        Given
	   	    https://automationexercise.com/api/productsList
		When
			 I send GET Request to the URL
		Then
			 1)Status code is 200
			 2)Print all ids greater than 30 on the console
			   Assert that there are 10 ids greater than 30
			 3)Print all brands whose usertype is Women on the console
			   Assert that the number of brands whose usertype is Women is 12
			 4)Total price of all product is 41864
     */


    @Test
    public void gest05(){

        //set the url
        spec.pathParams("first", "productsList");


        //set the expected data


        //send request and get the response
        Response response = given().spec(spec).when().get("/{first}");
        response.jsonPath().prettyPrint();  //to see in json format

        //do assertion

        assertEquals(200, response.statusCode());

    //Print all ids greater than 30 on the console
    //Assert that there are 10 ids greater than 30

        List<Integer> ids = response.jsonPath().getList("products.findAll{it.id>30}.id");  //Grovy  t->t   it means each elements
        System.out.println("ids: " + ids);

        assertEquals(10, ids.size());

    //Print all brands whose usertype is Women on the console
    //Assert that the number of brands whose usertype is Women is 12

        List<Integer> brands = response.jsonPath().getList("products.findAll{it.category.usertype.usertype=='Women'}.brand");  //Grovy  t->t   it means each elements
        System.out.println("brands: " + brands);

        assertEquals(12, brands.size());


    // 4)Total price of all product is 41864

        List<String> prices = response.jsonPath().getList("products.price");
        System.out.println(prices);

        //1.way
        int sum = 0;
        for(String w:prices) {

            sum +=  Integer.valueOf(w.replaceAll("[^0-9]",""));
        }
        System.out.println("sum :" + sum);
        assertEquals(41864, sum);


        //2. way
        int sum2 = prices.stream().map(t->Integer.parseInt(t.replaceAll("[^0-9]",""))).reduce(0, Math::addExact);
        System.out.println("sum :" + sum2);
        assertEquals(41864, sum2);

        //3. way  (hard coding)
        int sum3 = 0;
        for(String w:prices) {

            sum3 +=  Integer.valueOf(w.substring(4));
        }

        assertEquals(41864, sum3);
        System.out.println("sum :" + sum3);



    }

}
