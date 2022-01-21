package appTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetBooking {

    @Test
    void getBooking(){

        Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking/5");

        response.print();

        Assert.assertEquals(response.getStatusCode(),200);
    }
}
