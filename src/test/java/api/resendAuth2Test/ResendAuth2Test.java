package api.resendAuth2Test;

import apiParentTest.ApiParentTest;
import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;
import org.json.JSONObject;
import org.junit.Test;

import static endpoints.EndPoints.TEST_AS_ALT_WEB;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsNull.notNullValue;

public class ResendAuth2Test extends ApiParentTest {

    @Test
    public void resendAuth2(){
        paramsForRequests.boGetSID();
        paramsForRequests.boGetClientList();

        JSONObject requestParams = new JSONObject();

        requestParams.put("PROTO_VER", "3");
        requestParams.put("ACTION", "ResendAuth2");
        requestParams.put("CHANNEL_TYPE", "web_alt");
        requestParams.put("CLIENT_TRANS_ID", paramsForRequests.time);
        requestParams.put("LANG", "ua");
        requestParams.put("SID", paramsForRequests.getSid());
        requestParams.put("USER_ID", paramsForRequests.getUser_id());
        requestParams.put("PROTO_TYPE", "keyvalue-json");
        requestParams.put("CLIENT_ID", paramsForRequests.getClient_id());

        logger.info(requestParams.toString());

        ResponseBody response =
                given()
                        .params(requestParams.toMap())
                        .contentType(ContentType.HTML)
                        .accept(ContentType.HTML)

                        .when()
                        .post(TEST_AS_ALT_WEB)

                        .then()
                        .statusCode(200)
                        .body(containsString("\"err_code\":0"))
                        .body("err_code", notNullValue())

//                        .body(containsString("client_id"))
//                        .body("client_id", notNullValue())

                        .body(containsString("client_trans_id"))
                        .body("client_trans_id", notNullValue())

                        .body(containsString("err_descr"))
                        .body("err_descr", notNullValue())

                        .log().all()
                        .extract()
                        .response();

        logger.info(response.asString());
    }
}
