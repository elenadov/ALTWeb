package paramsForRequests;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;
import mainParamsForRequest.MainParamsForRequest;
import org.json.JSONObject;

import java.util.Locale;

import static endpoints.EndPoints.TEST_AS_ALT_WEB;
import static endpoints.EndPoints.TEST_BRS_MOB;
import static endpoints.EndPoints.TEST_GS_ALT_WEB;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Created by Elena Dovhaliuk
 */

public class ParamsForRequests extends MainParamsForRequest {

    @Step
    public void boGetSID() {

        JSONObject requestParams = new JSONObject();

        try {
            requestParams.put("PROTO_VER", "3");
            requestParams.put("ACTION", "BOGetSID");
            requestParams.put("CHANNEL_TYPE", "web_alt");
            requestParams.put("CLIENT_TRANS_ID", time + "0001");
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
                            .body(containsString("\"err_code\":0"))
                            .body("err_code", notNullValue())

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

            setSid(response.jsonPath().get("respond.sid").toString());
            setUser_id(response.jsonPath().get("respond.user_id").toString());
            setClient_id(response.jsonPath().get("respond.pos_list.pos.client_id").toString().replaceAll("\\[", "").replaceAll("\\]", ""));

            logger.info(response.asString());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Step
    public void boGetClientList() {

        JSONObject requestParams = new JSONObject();

        try{

        requestParams.put("PROTO_VER", "3");
        requestParams.put("ACTION", "BOGetClientList");
        requestParams.put("CHANNEL_TYPE", "web_alt");
        requestParams.put("CLIENT_TRANS_ID", time + "0002");
        requestParams.put("LANG", "ua");
        requestParams.put("SID", getSid());
        requestParams.put("USER_ID", getUser_id());
        requestParams.put("PROTO_TYPE", "keyvalue-json");
        requestParams.put("CLIENT_ID", getClient_id());

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

                        .body(containsString("user_id"))
                        .body("user_id", notNullValue())

                        .body(containsString("client_id"))
                        .body("client_id", notNullValue())

                        .body(containsString("sid"))
                        .body("sid", notNullValue())

                        .body(containsString("client_trans_id"))
                        .body("client_trans_id", notNullValue())

                        .body(containsString("err_descr"))
                        .body("err_descr", notNullValue())

                        .body(containsString("client_list"))
                        .body("client_list", notNullValue())

                        .body(containsString("client_id"))
                        .body("client_id", notNullValue())

                        .body(containsString("login"))
                        .body("login", notNullValue())

                        .log().all()
                        .extract()
                        .response();

        setSid(response.jsonPath().get("respond.sid").toString());
        setUser_id(user_id = response.jsonPath().get("respond.user_id").toString());
        setClient_id(client_id = response.jsonPath().get("respond.client_list.client_id[1]").toString().replaceAll("\\[", "").replaceAll("\\]",""));

        logger.info(response.asString());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Step
    public void resendAuth2() {

        JSONObject requestParams = new JSONObject();

        try {
            requestParams.put("PROTO_VER", "3");
            requestParams.put("ACTION", "ResendAuth2");
            requestParams.put("CHANNEL_TYPE", "web_alt");
            requestParams.put("CLIENT_TRANS_ID", time + "0003");
            requestParams.put("LANG", "ua");
            requestParams.put("SID", getSid());
            requestParams.put("USER_ID", getUser_id());
            requestParams.put("PROTO_TYPE", "keyvalue-json");
            requestParams.put("CLIENT_ID", getClient_id());

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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step
    public void boAuth2(String code){

        JSONObject requestParams = new JSONObject();

        try {
            requestParams.put("PROTO_VER", "3");
            requestParams.put("ACTION", "BOAuth2");
            requestParams.put("CHANNEL_TYPE", "web_alt");
            requestParams.put("CLIENT_TRANS_ID", time + "0004");
            requestParams.put("LANG", "ua");
            requestParams.put("SID", getSid());
            requestParams.put("USER_ID", getUser_id());
            requestParams.put("PROTO_TYPE", "keyvalue-json");
            requestParams.put("CLIENT_ID", getClient_id());
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

//                            .body(containsString("client_id".))
//                            .body("client_id", notNullValue())

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
            setTerm_code(term_code = response.jsonPath().get("respond.pos_list.pos.client_id").toString().replaceAll("\\[", "").replaceAll("\\]",""));

            logger.info(response.asString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step
    public void sendAuthCode(String playerPhone){
        JSONObject requestParams = new JSONObject();

        try {
            requestParams.put("PROTO_VER", "3");
            requestParams.put("ACTION", "SendAuthCode");
            requestParams.put("CHANNEL_TYPE", "web_alt");
            requestParams.put("CLIENT_TRANS_ID", time + "0005");
            requestParams.put("LANG", "ua");
            requestParams.put("SID", getSid());
            requestParams.put("USER_ID", getUser_id());
            requestParams.put("PROTO_TYPE", "keyvalue-json");
            requestParams.put("CLIENT_ID", getUser_id());
            requestParams.put("PLAYER_PHONE", playerPhone);
            requestParams.put("TERM_CODE", getTerm_code());

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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step
    public String getLZTicketForSale(int ticketCount, int parochkaCount, String bTV){
        String ticketPart1 = "{\"tickets\":[{\"t\":";
        String ticketPart2 = ",\"f\":0,\"e\":[{\"c\":1,\"n\":";
        String ticketPart3 = "},{\"c\":2,\"n\":";
        String ticketPart4 = "}]}]}";
        String richAndPopular;
        boolean isStateCheck = bTV.toLowerCase().equals("check");
        boolean isStateUncheck = bTV.toLowerCase().equals("uncheck");
        if (isStateCheck) {
            richAndPopular = "1";
        }
        else if (isStateUncheck) {
            richAndPopular = "0";
        }
        else{
            richAndPopular = "0";
        }
        return  ticketPart1 + ticketCount + ticketPart2 + parochkaCount
                + ticketPart3 + richAndPopular + ticketPart4;
    }

    //"{\"tickets\":[{\"t\":1,\"f\":0,\"e\":[{\"c\":1,\"n\":";
    //        String ticketPart3 = "},{\"c\":2,\"n\":0}]}]}";

    @Step
    private String calculateOneBetSum(int ticketCount, int parochkaCount, String bTV){
        int richAndPopular;
        boolean isStateCheck = bTV.toLowerCase().equals("check");
        boolean isStateUncheck = bTV.toLowerCase().equals("uncheck");
        if (isStateCheck) {
            richAndPopular = 2;
        }
        else if (isStateUncheck) {
            richAndPopular = 0;
        }
        else{
            richAndPopular = 0;
        }
        int mainTicketSum = 20;
        int parochkaSum = (ticketCount * parochkaCount * 5) / ticketCount;
        int sumOfOneTicket = mainTicketSum + parochkaSum + richAndPopular;
        return String.valueOf(sumOfOneTicket);
    }

//    @Step
//    public String calculateCheckSum(int ticketCount, int parochkaCount, int bTV){
//        int oneBetSum = Integer.parseInt(calculateOneBetSum(ticketCount, parochkaCount, bTV));
//        int result = oneBetSum * ticketCount;
//        return result + "00";
//    }

    @Step
    public String calculateLZCheckSumHrn(int ticketCount, int parochkaCount, String bTV){
        int richAndPopular = 0;
        boolean isStateCheck = bTV.toLowerCase().equals("check");
        boolean isStateUncheck = bTV.toLowerCase().equals("uncheck");
        if (isStateCheck) {
            richAndPopular = 2;
        }
        else if (isStateUncheck) {
            richAndPopular = 0;
        }
        int mainTicketSum = ticketCount * 20;
        int parochkaSum = ticketCount * parochkaCount * 5;
        float betSum = mainTicketSum + parochkaSum + (richAndPopular * ticketCount);
        return String.format(Locale.ROOT,"%.2f", betSum);
    }

    @Step
    public String calculateLZCheckSumMonets(int ticketCount, int parochkaCount, String bTV){
        int richAndPopular = 0;
        boolean isStateCheck = bTV.toLowerCase().equals("check");
        boolean isStateUncheck = bTV.toLowerCase().equals("uncheck");
        if (isStateCheck) {
            richAndPopular = 2;
        }
        else if (isStateUncheck) {
            richAndPopular = 0;
        }
        int mainTicketSum = ticketCount * 20;
        int parochkaSum = ticketCount * parochkaCount * 5;
        return String.valueOf(mainTicketSum + parochkaSum + (richAndPopular * ticketCount)) + "00";
    }
}

