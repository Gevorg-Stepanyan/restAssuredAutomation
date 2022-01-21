package appTest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class HelthCheckTest {

    @Test
    public void helthCheckTest(){

        given().
                when().
                get("https://restful-booker.herokuapp.com/ping").
                then().
                assertThat().
                statusCode(201);
    }
}
