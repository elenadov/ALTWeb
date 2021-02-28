package api.sendAuthCode;

import apiParentTest.ApiParentTest;
import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;
import org.json.JSONObject;
import org.junit.Test;

import java.sql.SQLException;

import static endpoints.EndPoints.TEST_BRS_MOB;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Created by Elena Dovhaliuk
 */

public class SendAuthCode extends ApiParentTest {
    private String playerPhone = "098456454";

    @Test
    public void sendAuthCodeMinRequiredParams() throws SQLException, ClassNotFoundException {
        paramsForRequests.boGetSID();
        paramsForRequests.boGetClientList();
        paramsForRequests.resendAuth2();
        paramsForRequests.boAuth2(database.selectValue(configProperties.GET_SMS_CODE_FOR_AUTH()));

        JSONObject requestParams = new JSONObject();

            requestParams.put("PROTO_VER", "3");
            requestParams.put("ACTION", "SendAuthCode");
            requestParams.put("CHANNEL_TYPE", "web_alt");
            requestParams.put("CLIENT_TRANS_ID", timestamp);
            requestParams.put("SID", paramsForRequests.getSid());
            requestParams.put("USER_ID", paramsForRequests.getUser_id());
            requestParams.put("CLIENT_ID", paramsForRequests.getUser_id());
            requestParams.put("PLAYER_PHONE", playerPhone);
            requestParams.put("TERM_CODE", paramsForRequests.getTerm_code());

            logger.info(requestParams.toString());

            ResponseBody response =
                    given()
                            .params(requestParams.toMap())
                            .contentType(ContentType.HTML)
                            .accept(ContentType.HTML)

                            .when()
                            .post(TEST_BRS_MOB)

                            .then()
                            .statusCode(200)
                            .body(containsString("<err_code>0</err_code>"))
                            .body("err_code", notNullValue())

//                            .body(containsString("client_id"))
//                            .body("client_id", notNullValue())

                            .body(containsString("client_trans_id"))
                            .body("client_trans_id", notNullValue())

                            .body(containsString("err_descr"))
                            .body("err_descr", notNullValue())

                            .log().all()
                            .extract()
                            .response();

            logger.info(response.asString());
    }

    @Test
    public void sendAuthCode() throws SQLException, ClassNotFoundException {
        mySQLDBConnect();

        paramsForRequests.boGetSID();
        paramsForRequests.boGetClientList();
        paramsForRequests.resendAuth2();
        paramsForRequests.boAuth2(database.selectValue(configProperties.GET_SMS_CODE_FOR_AUTH()));

        JSONObject requestParams = new JSONObject();

            requestParams.put("PROTO_VER", "3");
            requestParams.put("ACTION", "SendAuthCode");
            requestParams.put("CHANNEL_TYPE", "web_alt");
            requestParams.put("CLIENT_TRANS_ID", timestamp);
            requestParams.put("LANG", "ua");
            requestParams.put("SID", paramsForRequests.getSid());
            requestParams.put("USER_ID", paramsForRequests.getUser_id());
            requestParams.put("PROTO_TYPE", "keyvalue-json");
            requestParams.put("CLIENT_ID", paramsForRequests.getUser_id());
            requestParams.put("PLAYER_PHONE", playerPhone);
            requestParams.put("TERM_CODE", paramsForRequests.getTerm_code());

            logger.info(requestParams.toString());

            ResponseBody response =
                    given()
                            .params(requestParams.toMap())
                            .contentType(ContentType.HTML)
                            .accept(ContentType.HTML)

                            .when()
                            .post(TEST_BRS_MOB)

                            .then()
                            .statusCode(200)
                            .body(containsString("\"err_code\":0"))
                            .body("err_code", notNullValue())

//                            .body(containsString("client_id"))
//                            .body("client_id", notNullValue())

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
