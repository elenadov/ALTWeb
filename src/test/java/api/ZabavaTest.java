package api;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ZabavaTest {
        @Test
        public void googleTest() {
            given().when().get("http://www.google.com").then().statusCode(200);
        }

        String urlApi = "https://test.cs.emict.net/BrsTest";
        @Test
        public void getSid(){
            String requestBody =
                    "ACTION=ZabavaRegBet" +
                    "&BETS_COUNT=1" +
                    "&BETS_DATA={\"tickets\":[{\"t\":1,\"f\":0,\"e\":[{\"c\":1,\"n\":0},{\"c\":2,\"n\":0}]}]}" +
                    "&CHANNEL_TYPE=web" +
                    "&CLIENT_ID=1" +
                    "&CLIENT_INFO=Mozilla%2F5.0+%28X11%3B+Linux+x86_64%29+AppleWebKit%2F537.36+%28KHTML%2C+like+Gecko%29+Chrome%2F63.0.3239.108+Safari%2F537.36" +
                    "&CLIENT_TRANS_ID=1511961816748" +
                    "&CODE_PAGE=UTF-8" +
                    "&DRAW_COUNT=1" +
                    "&DRAW_NUM=1772" +
                    "&GAME_CODE=3" +
                    "&IP_ADDRESS=10.31.18.38" +
                    "&LANG=UTF-ua" +
                    "&MULTIUSER_ID=10637" +
                    "&OPER_CODE=1001906" +
                    "&PASSWORD=1" +
                    "&PROTO_TYPE=keyvalue" +
                    "&PROTO_VER=2" +
                    "&SALE_TYPE=1" +
                    "&SID=6522818b-e58a-4797-87d2-1e2e272f5e35" +
                    "&TERM_CODE=59000" +
                    "&USER_ID=10637" ;
            Response response = null;

            response = given().
                    contentType(ContentType.HTML)
                    .accept(ContentType.HTML)
                    .body(requestBody)
                    .when()
                    .post(urlApi);
            String res = response.asString();
            String mac_code = res.substring(res.indexOf("<mac_code>") + 10, res.indexOf("</mac_code>"));
            System.out.println("Post Response :" + response.asString());
            System.out.println("Status Code: " + response.getStatusCode());
            System.out.println("mac_code: " + mac_code);
        }
    }
