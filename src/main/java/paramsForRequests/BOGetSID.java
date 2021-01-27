package paramsForRequests;

import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;
import mainParamsForRequest.MainParamsForRequest;
import org.json.JSONObject;

import static endpoints.EndPoints.TEST_AS_ALT_WEB;
import static endpoints.EndPoints.TEST_GS_ALT_WEB;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsNull.notNullValue;

public class BOGetSID extends MainParamsForRequest {
//
//    public void boGetSID() {
//
//        String obtainedSid;
//        String obtainedClient_id;
//        String obtainedClient_trans_id;
//        String obtainedUser_id;
//
//        JSONObject requestParams = new JSONObject();
//
//        requestParams.put("PROTO_VER", "3");
//        requestParams.put("ACTION", "BOGetSID");
//        requestParams.put("CHANNEL_TYPE", "web_alt");
//        requestParams.put("CLIENT_TRANS_ID", time);
//        requestParams.put("LANG", "ua");
//        requestParams.put("LOGIN", "7600005");
//        requestParams.put("PASSWD", "7600005");
//        requestParams.put("PROTO_TYPE", "keyvalue-json");
//
//        logger.info(requestParams.toString());
//
//        ResponseBody response =
//                given()
//                        .params(requestParams.toMap())
//                        .contentType(ContentType.HTML)
//                        .accept(ContentType.HTML)
//
//                        .when()
//                        .post(TEST_GS_ALT_WEB)
//
//                        .then()
//                        .statusCode(200)
//                        .body(containsString("\"err_code\":0"))
//                        .body("err_code", notNullValue())
//
//                        .body(containsString("user_id"))
//                        .body("user_id", notNullValue())
//
//                        .body(containsString("client_id"))
//                        .body("client_id", notNullValue())
//
//                        .body(containsString("sid"))
//                        .body("sid", notNullValue())
//
//                        .body(containsString("client_trans_id"))
//                        .body("client_trans_id", notNullValue())
//
//                        .log().all()
//                        .extract()
//                        .response();
//
//        setSid(response.jsonPath().get("respond.sid").toString());
//        logger.info(sid);
//        setUser_id(response.jsonPath().get("respond.user_id").toString());
//        logger.info(user_id);
//        setClient_id(response.jsonPath().get("respond.pos_list.pos.client_id").toString().replaceAll("\\[", "").replaceAll("\\]",""));
//        logger.info(response.asString());
//
//    }
//
//    public void boGetClientList() {
//
//        JSONObject requestParams = new JSONObject();
//
//        logger.info(sid);
//        logger.info(user_id);
//        logger.info(client_id);
//
//        requestParams.put("PROTO_VER", "3");
//        requestParams.put("ACTION", "BOGetClientList");
//        requestParams.put("CHANNEL_TYPE", "web_alt");
//        requestParams.put("CLIENT_TRANS_ID", time);
//        requestParams.put("LANG", "ua");
//        requestParams.put("SID", getSid());
//        requestParams.put("USER_ID", getUser_id());
//        requestParams.put("PROTO_TYPE", "keyvalue-json");
//        requestParams.put("CLIENT_ID", getClient_id());
//
//        logger.info(requestParams.toString());
//
//
//        ResponseBody response =
//                given()
//                        .params(requestParams.toMap())
//                        .contentType(ContentType.HTML)
//                        .accept(ContentType.HTML)
//
//                        .when()
//                        .post(TEST_AS_ALT_WEB)
//
//                        .then()
//                        .statusCode(200)
//                        .body(containsString("\"err_code\":0"))
//                        .body("err_code", notNullValue())
//
//                        .body(containsString("user_id"))
//                        .body("user_id", notNullValue())
//
//                        .body(containsString("client_id"))
//                        .body("client_id", notNullValue())
//
//                        .body(containsString("sid"))
//                        .body("sid", notNullValue())
//
//                        .body(containsString("client_trans_id"))
//                        .body("client_trans_id", notNullValue())
//
//                        .body(containsString("err_descr"))
//                        .body("err_descr", notNullValue())
//
//                        .body(containsString("client_list"))
//                        .body("client_list", notNullValue())
//
//                        .body(containsString("client_id"))
//                        .body("client_id", notNullValue())
//
//                        .body(containsString("login"))
//                        .body("login", notNullValue())
//
//                        .log().all()
//                        .extract()
//                        .response();
//
//        setSid(response.jsonPath().get("respond.sid").toString());
//        setUser_id(user_id = response.jsonPath().get("respond.user_id").toString());
//        setClient_id(client_id = response.jsonPath().get("respond.client_list.client_id[1]").toString().replaceAll("\\[", "").replaceAll("\\]",""));
//
//        logger.info(response.asString());
//    }
//
//    public void resendAuth2() {
//
//        JSONObject requestParams = new JSONObject();
//
//        requestParams.put("PROTO_VER", "3");
//        requestParams.put("ACTION", "ResendAuth2");
//        requestParams.put("CHANNEL_TYPE", "web_alt");
//        requestParams.put("CLIENT_TRANS_ID", time);
//        requestParams.put("LANG", "ua");
//        requestParams.put("SID", getSid());
//        requestParams.put("USER_ID", getUser_id());
//        requestParams.put("PROTO_TYPE", "keyvalue-json");
//        requestParams.put("CLIENT_ID", getClient_id());
//
//        logger.info(requestParams.toString());
//
//        ResponseBody response =
//                given()
//                        .params(requestParams.toMap())
//                        .contentType(ContentType.HTML)
//                        .accept(ContentType.HTML)
//
//                        .when()
//                        .post(TEST_AS_ALT_WEB)
//
//                        .then()
//                        .statusCode(200)
//                        .body(containsString("\"err_code\":0"))
//                        .body("err_code", notNullValue())
//
//                        .body(containsString("client_id"))
//                        .body("client_id", notNullValue())
//
//                        .body(containsString("client_trans_id"))
//                        .body("client_trans_id", notNullValue())
//
//                        .body(containsString("err_descr"))
//                        .body("err_descr", notNullValue())
//
//                        .log().all()
//                        .extract()
//                        .response();
//
//        logger.info(response.asString());
//    }
}