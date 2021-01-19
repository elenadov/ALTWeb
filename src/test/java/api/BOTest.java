package api;

import apiParentTest.ApiParentTest;
import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;
import org.json.JSONObject;
import org.junit.Test;

import static endpoints.EndPoints.TEST_GS_ALT_WEB;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsNull.notNullValue;

public class BOTest extends ApiParentTest {

    @Test
    public void boGetSID() {

        JSONObject requestParams = new JSONObject();

        requestParams.put("PROTO_VER", "3");
        requestParams.put("ACTION", "BOGetSID");
        requestParams.put("CHANNEL_TYPE", "web_alt");
        requestParams.put("CLIENT_TRANS_ID", timestamp);
        requestParams.put("LANG", "ua");
        requestParams.put("LOGIN", "7600005");
        requestParams.put("PASSWD", "7600005");
        requestParams.put("PROTO_TYPE", "keyvalue-json");

        logger.info(requestParams.toString());

        ResponseBody response =
                         given()
                        .params(requestParams.toMap())
                        .contentType(ContentType.HTML)
                        .accept(ContentType.HTML)

                        .when()
                        .post(TEST_GS_ALT_WEB)

                        .then()
                        .statusCode(200)
                        .body(containsString("user_id"))
                        .body("user_id", notNullValue())
                        .body(containsString("client_id"))
                        .body("client_id", notNullValue())
                        .body(containsString("sid"))
                        .body("sid", notNullValue())
                        .body(containsString("client_trans_id"))
                        .body("client_trans_id", notNullValue())

                        .log().all()
                        .extract()
                        .response();

        boGetSID.sid = response.jsonPath().get("respond.sid").toString();
        boGetSID.user_id = response.jsonPath().get("respond.user_id").toString();
        boGetSID.client_trans_id = response.jsonPath().get("respond.client_trans_id").toString();
        boGetSID.client_id = response.jsonPath().get("respond.pos_list.pos.client_id").toString();

        logger.info(response.asString());

    }
}