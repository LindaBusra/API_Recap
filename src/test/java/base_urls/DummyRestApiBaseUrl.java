package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;

public class DummyRestApiBaseUrl {

    protected RequestSpecification spec;

    @BeforeEach//JunitJupiter annotation
    public void setUp() {

        spec = new RequestSpecBuilder().setBaseUri("https://dummy.restapiexample.com/api/v1").build();


    }

}






