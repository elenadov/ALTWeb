package api.boGetSidTest;

import apiParentTest.ApiParentTest;
import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;
import libs.Utils;
import org.json.JSONObject;
import org.junit.Test;

import static endpoints.EndPoints.TEST_AS_ALT_WEB;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Created by Elena Dovhaliuk
 */

public class BOGetSIDAsTermPositiveTest extends ApiParentTest {
    @Test
    public void boGetSID() {
        JSONObject requestParams = new JSONObject();

        requestParams.put("PROTO_VER", "3");
        requestParams.put("ACTION", "BOGetSID");
        requestParams.put("CHANNEL_TYPE", "web_alt");
        requestParams.put("CLIENT_TRANS_ID", Utils.getDateAndTimeFormated());
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
                        .post(TEST_AS_ALT_WEB)

                        .then()
                        .statusCode(200)
                        .body(containsString("user_id"))
                        .body("user_id", notNullValue())
                        .body(containsString("\"err_code\":0"))
                        .body("err_code", notNullValue())
                        .body(containsString("err_descr"))
                        .body("err_descr", notNullValue())
                        .body(containsString("sid"))
                        .body("sid", notNullValue())

                        .log().all()
                        .extract()
                        .response();

        logger.info(response.asString());
    }

    @Test
    public void boGetSIDJustRequiredParameters() {
        JSONObject requestParams = new JSONObject();

        requestParams.put("PROTO_VER", "3");
        requestParams.put("ACTION", "BOGetSID");
        requestParams.put("LOGIN", "7600005");
        requestParams.put("PASSWD", "7600005");

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
                        .body(containsString("user_id"))
                        .body("user_id", notNullValue())
                        .body(containsString("<err_code>0</err_code>"))
                        .body("err_code", notNullValue())
                        .body(containsString("err_descr"))
                        .body("err_descr", notNullValue())
                        .body(containsString("sid"))
                        .body("sid", notNullValue())

                        .log().all()
                        .extract()
                        .response();

        logger.info(response.asString());
    }

    @Test
    public void boGetSIDAllParametersDescribedInProtocol() {
        JSONObject requestParams = new JSONObject();

        requestParams.put("PROTO_VER", "3");
        requestParams.put("ACTION", "BOGetSID");
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
                        .post(TEST_AS_ALT_WEB)

                        .then()
                        .statusCode(200)
                        .body(containsString("user_id"))
                        .body("user_id", notNullValue())
                        .body(containsString("\"err_code\":0"))
                        .body("err_code", notNullValue())
                        .body(containsString("err_descr"))
                        .body("err_descr", notNullValue())
                        .body(containsString("sid"))
                        .body("sid", notNullValue())

                        .log().all()
                        .extract()
                        .response();

        logger.info(response.asString());
    }
}
