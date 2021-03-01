package paramsForRequests;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;
import libs.Utils;
import mainParamsForRequest.MainParamsForRequest;
import org.json.JSONObject;

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

    /**
     * Created by Elena Dovhaliuk
     * This method executes BOGetSID action to obtain actual values of sid, user_id, client_id
     */
    @Step
    public void boGetSID() {

        JSONObject requestParams = new JSONObject();

        try {
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

    /**
     * Created by Elena Dovhaliuk
     * This method executes BOGetClientList action to obtain actual values of sid, user_id, client_id
     */
    @Step
    public void boGetClientList() {

        JSONObject requestParams = new JSONObject();

        try{

        requestParams.put("PROTO_VER", "3");
        requestParams.put("ACTION", "BOGetClientList");
        requestParams.put("CHANNEL_TYPE", "web_alt");
        requestParams.put("CLIENT_TRANS_ID", Utils.getDateAndTimeFormated());
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

    /**
     * Created by Elena Dovhaliuk
     * This method executes ResendAuth2 action to send sms code for the further authentication
     */
    @Step
    public void resendAuth2() {

        JSONObject requestParams = new JSONObject();

        try {
            requestParams.put("PROTO_VER", "3");
            requestParams.put("ACTION", "ResendAuth2");
            requestParams.put("CHANNEL_TYPE", "web_alt");
            requestParams.put("CLIENT_TRANS_ID", Utils.getDateAndTimeFormated());
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

    /**
     * Created by Elena Dovhaliuk
     * This method executes BOAuth2 action to confirm obtained sms code and get actual
     * value of term_code
     * @param code
     */
    @Step
    public void boAuth2(String code){

        JSONObject requestParams = new JSONObject();

        try {
            requestParams.put("PROTO_VER", "3");
            requestParams.put("ACTION", "BOAuth2");
            requestParams.put("CHANNEL_TYPE", "web_alt");
            requestParams.put("CLIENT_TRANS_ID", Utils.getDateAndTimeFormated());
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

    /**
     * Created by Elena Dovhaliuk
     * This method executes SendAuthCode action to send sms code and continue purchase
     * @param playerPhone
     */
    @Step
    public void sendAuthCode(String playerPhone){
        JSONObject requestParams = new JSONObject();

        try {
            requestParams.put("PROTO_VER", "3");
            requestParams.put("ACTION", "SendAuthCode");
            requestParams.put("CHANNEL_TYPE", "web_alt");
            requestParams.put("CLIENT_TRANS_ID", Utils.getDateAndTimeFormated());
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
}

