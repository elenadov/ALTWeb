package api;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.json.JSONObject;
import org.junit.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static endpoints.EndPoints.TEST_GS_ALT_WEB;
import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class BoGetTest {

    @Test
    public void boGetSID() {
        Logger logger = Logger.getLogger(String.valueOf(getClass()));

        long timestamp = Instant.now().getEpochSecond();

        JSONObject requestParams = new JSONObject();
        requestParams.put("PROTO_VER", "3");
        requestParams.put("ACTION", "BOGetSID");
        requestParams.put("CHANNEL_TYPE", "web_alt");
        requestParams.put("CLIENT_TRANS_ID", timestamp);
        requestParams.put("LANG", "ua");
        requestParams.put("LOGIN", "7600005");
        requestParams.put("PASSWD", "7600005");
        requestParams.put("PROTO_TYPE", "keyvalue-json");
        logger.info("");

        ResponseBody response =
                given()
                        .params(requestParams.toMap())
//                        .contentType(ContentType.JSON)
                        .headers("Host", "test.alt.emict.net")
//                        .body(requestParams.toMap())
                        .when()
                        .post(TEST_GS_ALT_WEB)// Example POST method
                        .then()//                        .assertThat()
                        .statusCode(200)
                        .body(containsString("user_id"))
                        .body("user_id", notNullValue())
                        .body(containsString("client_id"))
                        .body("client_id", notNullValue())
                        .body(containsString("sid"))
                        .body("sid", notNullValue())
                        .body(containsString("client_trans_id"))
                        .body("client_trans_id", notNullValue())
//                        .assertThat()
//                        .body()
//                        .contentType(ContentType.JSON)
                        .log().all()
                        .extract()
                        .response();
//        Assert.assertEquals("Incorrect Success Code was returned", response.htmlPath().get("client_trans_id"), requestParams.get("CLIENT_TRANS_ID"));

        String sid = response.jsonPath().get("respond.sid").toString();
        String user_id = response.jsonPath().get("respond.user_id").toString();


//        List<String> jsonAsArrayList = from(resp).get("respond.sid");
//
//        System.out.println(jsonAsArrayList);
    }
}
