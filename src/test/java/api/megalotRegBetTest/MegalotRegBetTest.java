package api.megalotRegBetTest;

import apiParentTest.ApiParentTest;
import io.qameta.allure.*;
import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;
import libs.Utils;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

import static endpoints.EndPoints.TEST_BRS_MOB;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Created by Elena Dovhaliuk
 */

@Epic("Megalot")
@Feature("MegalotRegBet")
@RunWith(Parameterized.class)

public class MegalotRegBetTest extends ApiParentTest {
    private String playerPhone = "098456454";
    private int drawCount;
    private int ball1;
    private int ball2;
    private int ball3;
    private int ball4;
    private int ball5;
    private int ball6;
    private int megaBall;

    public MegalotRegBetTest (int drawCountToBeSelected, int ball1, int ball2, int ball3, int ball4, int ball5, int ball6, int megaBall){
        this.drawCount = drawCountToBeSelected;
        this.ball1 = ball1;
        this.ball2 = ball2;
        this.ball3 = ball3;
        this.ball4 = ball4;
        this.ball5 = ball5;
        this.ball6 = ball6;
        this.megaBall = megaBall;
    }

    @Parameterized.Parameters(name = "Parameters are {0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}")
    public static Collection testData(){
        return Arrays.asList(new Object[][] {
                        {1, 1, 2, 3, 4, 5, 9, 0},
                        {2, 1, 2, 3, 4, 5, 9, 1},
                        {3, 1, 2, 3, 4, 8, 9, 0},
                        {4, 1, 2, 3, 4, 8, 9, 1}
                }
        );
    }

    @Description("Megalot API test")
    @Story("MegalotRegBet API test")
    @Link("")
    @Link(name = "allure", type = "mylink")
    @Issue("")
    @Severity(SeverityLevel.CRITICAL)

    @Test
    public void MegalotRegBet() throws SQLException, ClassNotFoundException {
        paramsForRequests.boGetSID();
        paramsForRequests.boGetClientList();
        paramsForRequests.resendAuth2();
        paramsForRequests.boAuth2(database.selectValue(configProperties.GET_SMS_CODE_FOR_AUTH()));
        paramsForRequests.sendAuthCode(playerPhone);

        oracleSQLDBConnect();

        JSONObject requestParams = new JSONObject();
        requestParams.put("PROTO_VER", "3");
        requestParams.put("ACTION", "MegalotRegBet");
        requestParams.put("CHANNEL_TYPE", "web_alt");
        requestParams.put("CLIENT_TRANS_ID", Utils.getDateAndTimeFormated());
        requestParams.put("LANG", "ua");
        requestParams.put("TERM_CODE", paramsForRequests.getTerm_code());
        requestParams.put("BETS_COUNT", "1");
        requestParams.put("BETS_DATA", megalotRegBet.getMegalotTicketForSale(ball1, ball2, ball3, ball4
                , ball5, ball6, megaBall));
        requestParams.put("PROTO_TYPE", "keyvalue-json");
        requestParams.put("AMOUNT", megalotRegBet.calculateMegalotCheckSumMonets(drawCount));
        requestParams.put("CLIENT_ID", paramsForRequests.getClient_id());
        requestParams.put("DRAW_COUNT", drawCount);
        requestParams.put("GAME_CODE", "1");
        requestParams.put("PLAYER_AUTH_CODE", database.selectValue(configProperties.GET_SMS_CODE_FOR_SELL()));
        requestParams.put("PLAYER_PHONE", playerPhone);
        requestParams.put("SID", paramsForRequests.getSid());
        requestParams.put("TICKET_FORMAT", "PNG_504");
        requestParams.put("USER_ID", paramsForRequests.getUser_id());

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
                        .body("user_id", notNullValue())
                        .body(containsString("\"user_id\":\"" + paramsForRequests.getUser_id() + "\""))
                        .body("err_code", notNullValue())
                        .body(containsString("\"err_code\":0"))
                        .body(containsString("err_descr"))
                        .body("err_descr", notNullValue())
                        .body("client_id", notNullValue())
                        .body(containsString("client_id"))
                        .body("sid", notNullValue())
                        .body(containsString("\"sid\":\"" + paramsForRequests.getSid() + "\""))
                        .body(containsString("client_trans_id"))
                        .body("client_trans_id", notNullValue())
                        .body(containsString("ticket"))
                        .body("ticket", notNullValue())
                        .body(containsString("id"))
                        .body("id", notNullValue())
                        .body(containsString("description"))
                        .body("description", notNullValue())
                        .body("bet_sum", notNullValue())
                        .body(containsString("\"bet_sum\":\"" + megalotRegBet.simpleTicketSum + ".00\""))
                        .body(containsString("ticket_num"))
                        .body("ticket_num", notNullValue())
                        .body("ticket_sum", notNullValue())
                        .body(containsString("\"ticket_sum\":" +  + megalotRegBet.simpleTicketSum + "00"))
                        .body(containsString("mac_code"))
                        .body("mac_code", notNullValue())
                        .body(containsString("game_name"))
                        .body("game_name", notNullValue())
                        .body(containsString("draw_date"))
                        .body("draw_date", notNullValue())
                        .body(containsString("draw_num"))
                        .body("draw_num", notNullValue())
                        .body(containsString("regdate"))
                        .body("regdate", notNullValue())
                        .body(containsString("ticket_templ_url"))
                        .body("ticket_templ_url", notNullValue())
                        .body(containsString("slogan"))
                        .body("slogan", notNullValue())
                        .body(containsString("\"bet\":[{\"balls\":\"" + ball1 + "," + ball2 + "," + ball3 + "," + ball4 + ","
                                + ball5 + "," + ball6 + "\",\"input_mode\":2,\"megaballs\":\"" + megaBall + "\"}]"))
                        .body("bet", notNullValue())
                        .body("bet_count", notNullValue())
                        .body(containsString("\"bet_count\":1"))

                        .log().all()
                        .extract()
                        .response();

        logger.info(response.asString());
    }
}
