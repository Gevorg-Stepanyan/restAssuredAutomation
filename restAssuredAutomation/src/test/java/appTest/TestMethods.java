package appTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyData;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;

public class TestMethods {

    @Test
    public void getBookingIdsWithoutFilter(){
        //Get response with booking ids
        Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking");

        response.print();

        // Verify status code
        Assert.assertEquals(response.getStatusCode(),200,"Status code should be 200 but it is not: ");

        // Verify booking id is not empty
        List<Integer> booksId = response.jsonPath().getList("bookingid");
        String a = response.jsonPath().getString("bookingid");
        System.out.println(a);

        Assert.assertFalse(booksId.isEmpty(),"Booking ids is empty: ");
    }

    @Test
    public void helthCheckTest(){
        given().
                when().
                get("https://restful-booker.herokuapp.com/ping").
                then().
                assertThat().
                statusCode(201);
    }



    @Test
    public void requestWithParams(){

        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts");
        response.print();

        System.out.println(response.getStatusCode());
        List<Integer> rep = response.jsonPath().getList("id");

        JSONObject body = new JSONObject();
        body.put("username","admin");
        body.put("password","password123");

        Response resp = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(body.toString())
                .post("https://restful-booker.herokuapp.com/auth");
        resp.print();

        String token = resp.jsonPath().getString("token");
        System.out.println("Token is: "+ token);
    }

    @Test
    void authBasic(){
        Response rep = RestAssured.given()
                .auth()
                .preemptive()
                .basic("admin","password123").post("https://restful-booker.herokuapp.com/auth");



    }


}
