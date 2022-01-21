package appTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;


public class GetBookingIds {

    @Test
    public void getBookingIdsWithoutFilter(){
        //Get response with booking ids
        Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking");

        response.print();

        // Verify status code
        Assert.assertEquals(response.getStatusCode(),200,"Status code should be 200 but it is not: ");

        // Verify booking id is not empty
        List<Integer> booksId = response.jsonPath().getList("bookingid");
        Assert.assertFalse(booksId.isEmpty(),"Booking ids is empty: ");
    }
}
