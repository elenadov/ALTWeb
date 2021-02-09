package api.boAuth2;

import apiParentTest.ApiParentTest;
import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;
import org.json.JSONObject;
import org.junit.Test;

import java.sql.SQLException;

import static endpoints.EndPoints.TEST_GS_ALT_WEB;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsNull.notNullValue;

public class BOAuth2GsAltWebPositiveTest extends ApiParentTest {

    @Test
    public void boAuth2MinRequiredParams() throws SQLException {
        String code;
        paramsForRequests.boGetSID();
        paramsForRequests.boGetClientList();
        paramsForRequests.resendAuth2();
        code = database.selectValue(configProperties.GET_SMS_CODE_FOR_AUTH());

        JSONObject requestParams = new JSONObject();

        try {
            requestParams.put("PROTO_VER", "3");
            requestParams.put("ACTION", "BOAuth2");
            requestParams.put("CHANNEL_TYPE", "web_alt");
            requestParams.put("CLIENT_TRANS_ID", timestamp);
            requestParams.put("SID", paramsForRequests.getSid());
            requestParams.put("USER_ID", paramsForRequests.getUser_id());
            requestParams.put("CLIENT_ID", paramsForRequests.getClient_id());
            requestParams.put("AUTH2_SECRET", code);

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
                            .body(containsString("<err_code>0</err_code>"))
                            .body("err_code", notNullValue())

                            .body(containsString("client_id"))
                            .body("client_id", notNullValue())

                            .body(containsString("client_trans_id"))
                            .body("client_trans_id", notNullValue())

                            .body(containsString("err_descr"))
                            .body("err_descr", notNullValue())

//                            .body(containsString("sid"))
//                            .body("sid", notNullValue())
//
//                            .body(containsString("user_id"))
//                            .body("user_id", notNullValue())

                            .body(containsString("pos_list"))
                            .body("pos_list", notNullValue())

                            .body(containsString("access_level"))
                            .body("access_level", notNullValue())

                            .body(containsString("pos_code"))
                            .body("pos_code", notNullValue())

                            .body(containsString("pos_name"))
                            .body("pos_name", notNullValue())

                            .body(containsString("pos_addr"))
                            .body("pos_addr", notNullValue())

                            .log().all()
                            .extract()
                            .response();
            logger.info(response.asString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void boAuth2() throws SQLException {
        String code;
        paramsForRequests.boGetSID();
        paramsForRequests.boGetClientList();
        paramsForRequests.resendAuth2();
        code = database.selectValue(configProperties.GET_SMS_CODE_FOR_AUTH());

        JSONObject requestParams = new JSONObject();

        try {
            requestParams.put("PROTO_VER", "3");
            requestParams.put("ACTION", "BOAuth2");
            requestParams.put("CHANNEL_TYPE", "web_alt");
            requestParams.put("CLIENT_TRANS_ID", timestamp);
            requestParams.put("LANG", "ua");
            requestParams.put("SID", paramsForRequests.getSid());
            requestParams.put("USER_ID", paramsForRequests.getUser_id());
            requestParams.put("PROTO_TYPE", "keyvalue-json");
            requestParams.put("CLIENT_ID", paramsForRequests.getClient_id());
            requestParams.put("AUTH2_SECRET", code);

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
                            .body(containsString("\"err_code\":0"))
                            .body("err_code", notNullValue())

                            .body(containsString("client_id"))
                            .body("client_id", notNullValue())

                            .body(containsString("client_trans_id"))
                            .body("client_trans_id", notNullValue())

                            .body(containsString("err_descr"))
                            .body("err_descr", notNullValue())

//                            .body(containsString("sid"))
//                            .body("sid", notNullValue())
//
//                            .body(containsString("user_id"))
//                            .body("user_id", notNullValue())

                            .body(containsString("pos_list"))
                            .body("pos_list", notNullValue())

                            .body(containsString("access_level"))
                            .body("access_level", notNullValue())

                            .body(containsString("pos_code"))
                            .body("pos_code", notNullValue())

                            .body(containsString("pos_name"))
                            .body("pos_name", notNullValue())

                            .body(containsString("pos_addr"))
                            .body("pos_addr", notNullValue())

                            .log().all()
                            .extract()
                            .response();
            logger.info(response.asString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
