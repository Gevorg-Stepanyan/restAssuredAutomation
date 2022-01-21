package mobileId;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Requests {

    @Test
    public void authorize(){
       /* Response response = RestAssured.
                get("https://tyesem.am:8643/idp/mtsarmenia/oidc/mc/authorize?redirect_uri=http://balik.arag.club/mts/webhook&client_id=barevbalik&MSISDN=+37493217866&scope=openid&response_type=code&acr_values=4&state=fc865611-5c6b-435d-bcde-ad311a3811c7&nonce=fc865611-5c6b-435d-bcde-ad311a3811c8&version_parameter=mc_v2.0&login_hint=MSISDN:+37493217866");
    response.print();*/


    given().
            when().
            get("https://tyesem.am:8643/idp/mtsarmenia/oidc/mc/authorize?redirect_uri=http://balik.arag.club/mts/webhook&client_id=barevbalik&MSISDN=+37493217866&scope=openid&response_type=code&acr_values=4&state=fc865611-5c6b-435d-bcde-ad311a3811c7&nonce=fc865611-5c6b-435d-bcde-ad311a3811c8&version_parameter=mc_v2.0&login_hint=MSISDN:+37493217866").
            then().
            assertThat().
            statusCode(200);
    }
}
