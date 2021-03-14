package mainParamsForRequest;

import libs.ConfigProperties;
import libs.Database;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;

/**
 * Created by Elena Dovhaliuk
 */

public class MainParamsForRequest{
    protected Logger logger = Logger.getLogger(getClass());
    protected Database database;

    protected static ConfigProperties configProperties =
            ConfigFactory.create(ConfigProperties.class);

    public String sid;
    public String client_id;
    public String client;
    public String client_trans_id;
    public String user_id;
    public String term_code;

    /**
     * Created by Elena Dovhaliuk
     * This setter sets SID parameter value
     * @param newSid
     */
    public void setSid (String newSid){
        this.sid = newSid;
    }

    /**
     * Created by Elena Dovhaliuk
     * This setter sets USER_ID parameter value
     * @param user_id
     */
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    /**
     * Created by Elena Dovhaliuk
     * This setter sets CLIENT_ID parameter value
     * @param client_id
     */
    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    /**
     * Created by Elena Dovhaliuk
     * This setter sets TERM_CODE parameter value
     * @param term_code
     */
    public void setTerm_code(String term_code) {
        this.term_code = term_code;
    }

    public void setClient(String client){
        this.client = client;
    }

    /**
     * Created by Elena Dovhaliuk
     * This method gets SID param value
     * @return
     */
    public String getSid() {
        return sid;
    }

    /**
     * Created by Elena Dovhaliuk
     * This method gets CLIENT_ID param value
     * @return
     */
    public String getClient_id() {
        return client_id;
    }

    /**
     * Created by Elena Dovhaliuk
     * This method gets USER_ID param value
     * @return
     */
    public String getUser_id() {
        return user_id;
    }

    /**
     * Created by Elena Dovhaliuk
     * This method gets TERM_CODE param value
     * @return
     */
    public String getTerm_code() {
        return term_code;
    }

    public String getClient(){
        return client;
    }
}
