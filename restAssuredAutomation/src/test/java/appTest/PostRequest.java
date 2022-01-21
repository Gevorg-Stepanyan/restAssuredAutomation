package appTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class PostRequest {

    @Test
    void createBookingTest(){

        //Create JSon body
        JSONObject body = new JSONObject();
        body.put("firstname","Gevorg");
        body.put("lastname","Stepanyan");
        body.put("totalprice",999);
        body.put("depositpaid",false);

        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin","2018-01-01");
        bookingdates.put("checkout","2019-01-01");
        body.put("bookingdates",bookingdates);
        body.put("additionalneeds","breakfast");

        //Get response
        Response response = RestAssured.given().contentType(ContentType.JSON)
                .body(body.toString())
                .post("https://restful-booker.herokuapp.com/booking");

        response.print();
        //Verification

    }
}
