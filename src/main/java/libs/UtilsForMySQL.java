package libs;

import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;

import java.sql.SQLException;

public class UtilsForMySQL {
    protected static ConfigProperties configProperties =
            ConfigFactory.create(ConfigProperties.class);
    private Logger log = Logger.getLogger(getClass());
    private Database dBMySQL;

    public String getSMSCode() throws SQLException, ClassNotFoundException {
        log.info("--- Conect MySQL DB --------");
        dBMySQL = MySQL_Database.getDataBase();
        log.info("--- Conected to MySQL --------");
        String tempCode = dBMySQL
                .selectValue(configProperties.GET_SMS_CODE_FOR_AUTH());

        dBMySQL.quit();
        return tempCode;

    }
}
