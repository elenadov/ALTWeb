package api.zabavaRegBetTest;

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

public class ZabavaRegBetTest extends ApiParentTest {
    @Test
    public void ZabavaRegBet() throws SQLException, ClassNotFoundException {
        mySQLDBConnect();

        paramsForRequests.boGetSID();
        paramsForRequests.boGetClientList();
        paramsForRequests.resendAuth2();
        paramsForRequests.boAuth2(database.selectValue(configProperties.GET_SMS_CODE_FOR_AUTH()));

        oracleSQLDBConnect();

        JSONObject requestParams = new JSONObject();
            requestParams.put("PROTO_VER", "3");
            requestParams.put("ACTION", "ZabavaRegBet");
            requestParams.put("CHANNEL_TYPE", "web_alt");
            requestParams.put("CLIENT_TRANS_ID", paramsForRequests.time);
            requestParams.put("LANG", "ua");
            requestParams.put("TERM_CODE", paramsForRequests.term_code);
            requestParams.put("BETS_COUNT", "1");
            requestParams.put("BETS_DATA", "{\"tickets\":[{\"t\":1,\"f\":0,\"e\":[{\"c\":1,\"n\":1},{\"c\":2,\"n\":0}]}]}");
            requestParams.put("PROTO_TYPE", "keyvalue-json");
            requestParams.put("BET_SUM", "2500");
            requestParams.put("CLIENT_ID", paramsForRequests.client_id);
            requestParams.put("DRAW_COUNT", "1");
            requestParams.put("DRAW_NUM", "1772");
            requestParams.put("GAME_CODE", "3");
            requestParams.put("PLAYER_AUTH_CODE", database.selectValue(configProperties.GET_SMS_CODE_FOR_SELL()));
            requestParams.put("PLAYER_PHONE", "856756868");
            requestParams.put("SALE_TYPE", "1");
            requestParams.put("SID", paramsForRequests.sid);
            requestParams.put("TICKET_FORMAT", "PNG_504");
            requestParams.put("USER_ID", paramsForRequests.user_id);

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
                            .body(containsString("user_id"))
                            .body("user_id", notNullValue())
                            .body(containsString("\"err_code\":0"))
                            .body("err_code", notNullValue())
                            .body(containsString("err_descr"))
                            .body("err_descr", notNullValue())
                            .body(containsString("client_id"))
                            .body("client_id", notNullValue())
                            .body(containsString("sid"))
                            .body("sid", notNullValue())
                            .body(containsString("client_trans_id"))
                            .body("client_trans_id", notNullValue())
                            .body(containsString("ticket"))
                            .body("ticket", notNullValue())
                            .body(containsString("id"))
                            .body("id", notNullValue())
                            .body(containsString("description"))
                            .body("description", notNullValue())
                            .body(containsString("bet_sum"))
                            .body("bet_sum", notNullValue())
                            .body(containsString("ticket_num"))
                            .body("ticket_num", notNullValue())
                            .body(containsString("ticket_snum"))
                            .body("ticket_snum", notNullValue())
                            .body(containsString("draw_num"))
                            .body("draw_num", notNullValue())
                            .body(containsString("regdate"))
                            .body("regdate", notNullValue())
                            .body(containsString("mac_code"))
                            .body("mac_code", notNullValue())
                            .body(containsString("url"))
                            .body("url", notNullValue())
                            .body(containsString("game_comb"))
                            .body("game_comb", notNullValue())
                            .body(containsString("game_field"))
                            .body("game_field", notNullValue())

                            .log().all()
                            .extract()
                            .response();

            logger.info(response.asString());
    }
}
