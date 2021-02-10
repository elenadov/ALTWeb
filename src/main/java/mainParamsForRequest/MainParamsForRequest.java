package mainParamsForRequest;

import libs.ConfigProperties;
import libs.Database;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import java.time.Instant;

public class MainParamsForRequest{
    protected Logger logger = Logger.getLogger(getClass());
    protected Database database;

    protected static ConfigProperties configProperties =
            ConfigFactory.create(ConfigProperties.class);

    public long curTime = Instant.now().getEpochSecond();
    public String time = curTime + "12345";

    public String sid;
    public String client_id;
    public String client_trans_id;
    public String user_id;
    public String maccode;
    public String term_code;

    public void setSid (String newSid){
        this.sid = newSid;
    }

    public void setClient_trans_id(String client_trans_id) {
        this.client_trans_id = client_trans_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public void setTerm_code(String term_code) {
        this.term_code = term_code;
    }

    public String genClientTransId(){
        return String.valueOf(curTime) + String.valueOf((int)Math.random()*432432);
    }

    public String getSid() {
        return sid;
    }

    public String getClient_id() {
        return client_id;
    }

    public String getClient_trans_id() {
        return client_trans_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getTerm_code() {
        return term_code;
    }
}
