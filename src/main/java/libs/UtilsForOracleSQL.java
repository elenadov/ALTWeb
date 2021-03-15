package libs;

import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;

import java.sql.SQLException;

public class UtilsForOracleSQL {
    protected static ConfigProperties configProperties =
            ConfigFactory.create(ConfigProperties.class);
    private Logger log = Logger.getLogger(getClass());
    private Database dBOracleSQL;

    public String getCurrentLZDraw() throws SQLException, ClassNotFoundException {
        log.info("--- Conect OracleSQL DB --------");
        dBOracleSQL = Oracle_SQL_Database.getOracleDataBase();
        log.info("--- Conected to OracleSQL --------");
        String tempCode = dBOracleSQL
                .selectValue(configProperties.GET_CURRENT_LZ_DRAW());

        dBOracleSQL.quit();
        return tempCode;
    }

    public String getSMSCodeForPurchaseConfirmation() throws SQLException, ClassNotFoundException {
        log.info("--- Conect OracleSQL DB --------");
        dBOracleSQL = Oracle_SQL_Database.getOracleDataBase();
        log.info("--- Conected to OracleSQL --------");
        String tempCode = dBOracleSQL
                .selectValue(configProperties.GET_SMS_CODE_FOR_SELL());

        dBOracleSQL.quit();
        return tempCode;
    }

    public String getDrawCountInRegistration() throws SQLException, ClassNotFoundException {
        log.info("--- Conect OracleSQL DB --------");
        dBOracleSQL = Oracle_SQL_Database.getOracleDataBase();
        log.info("--- Conected to OracleSQL --------");
        String tempCode = dBOracleSQL
                .selectValue(configProperties.DRAW_COUNT_IN_REGISTRATION_BET_STATUS());

        dBOracleSQL.quit();
        return tempCode;
    }

    public String getDrawIdInRegistration() throws SQLException, ClassNotFoundException {
        log.info("--- Conect OracleSQL DB --------");
        dBOracleSQL = Oracle_SQL_Database.getOracleDataBase();
        log.info("--- Conected to OracleSQL --------");
        String tempCode = dBOracleSQL
                .selectValue(configProperties.DRAW_ID_IN_REGISTRATION_BET_STATUS());

        dBOracleSQL.quit();
        return tempCode;
    }

    public String getDrawCountInMultyRegistration() throws SQLException, ClassNotFoundException {
        log.info("--- Conect OracleSQL DB --------");
        dBOracleSQL = Oracle_SQL_Database.getOracleDataBase();
        log.info("--- Conected to OracleSQL --------");
        String tempCode = dBOracleSQL
                .selectValue(configProperties.DRAW_COUNT_IN_MULTY_REGISTRATION_BET_STATUS());

        dBOracleSQL.quit();
        return tempCode;
    }

    public String getDrawIdInMultyRegistration() throws SQLException, ClassNotFoundException {
        log.info("--- Conect OracleSQL DB --------");
        dBOracleSQL = Oracle_SQL_Database.getOracleDataBase();
        log.info("--- Conected to OracleSQL --------");
        String tempCode = dBOracleSQL
                .selectValue(configProperties.DRAW_ID_IN_MULTY_REGISTRATION_BET_STATUS());

        dBOracleSQL.quit();
        return tempCode;
    }

    public String getDrawCountInCreatedStatus() throws SQLException, ClassNotFoundException {
        log.info("--- Conect OracleSQL DB --------");
        dBOracleSQL = Oracle_SQL_Database.getOracleDataBase();
        log.info("--- Conected to OracleSQL --------");
        String tempCode = dBOracleSQL
                .selectValue(configProperties.DRAW_COUNT_IN_CREATED_STATUS());

        dBOracleSQL.quit();
        return tempCode;
    }

    public String getDrawIdInCreatedStatus() throws SQLException, ClassNotFoundException {
        log.info("--- Conect OracleSQL DB --------");
        dBOracleSQL = Oracle_SQL_Database.getOracleDataBase();
        log.info("--- Conected to OracleSQL --------");
        String tempCode = dBOracleSQL
                .selectValue(configProperties.DRAW_ID_IN_CREATED_STATUS());

        dBOracleSQL.quit();
        return tempCode;
    }

    public int changeDrawStatusInRegistration(String script) throws SQLException, ClassNotFoundException {
        log.info("--- Conect OracleSQL DB --------");
        dBOracleSQL = Oracle_SQL_Database.getOracleDataBase();
        log.info("--- Conected to OracleSQL --------");
        int tempCode = dBOracleSQL.changeTable(script);

        dBOracleSQL.quit();
        return tempCode;
    }

    public String getMegalotLastDrawCodeCreated() throws SQLException, ClassNotFoundException {
        log.info("--- Conect OracleSQL DB --------");
        dBOracleSQL = Oracle_SQL_Database.getOracleDataBase();
        log.info("--- Conected to OracleSQL --------");
        String tempCode = dBOracleSQL
                .selectValue(configProperties.SCRIPT_DRAW_CODE());

        dBOracleSQL.quit();
        return tempCode;
    }

    public int createDrawInDB(String script) throws SQLException, ClassNotFoundException {
        log.info("--- Conect OracleSQL DB --------");
        dBOracleSQL = Oracle_SQL_Database.getOracleDataBase();
        log.info("--- Conected to OracleSQL --------");
        int tempCode = dBOracleSQL
                .changeTable(script);

        dBOracleSQL.quit();
        return tempCode;
    }

    public String getDrawIdOfCreatedDraw(String script) throws SQLException, ClassNotFoundException {
        log.info("--- Conect OracleSQL DB --------");
        dBOracleSQL = Oracle_SQL_Database.getOracleDataBase();
        log.info("--- Conected to OracleSQL --------");
        String tempCode = dBOracleSQL
                .selectValue(script);

        dBOracleSQL.quit();
        return tempCode;
    }

    public int changeParamsForNewDraw(String script) throws SQLException, ClassNotFoundException {
        log.info("--- Conect OracleSQL DB --------");
        dBOracleSQL = Oracle_SQL_Database.getOracleDataBase();
        log.info("--- Conected to OracleSQL --------");
        int tempCode = dBOracleSQL
                .changeTable(script);

        dBOracleSQL.quit();
        return tempCode;
    }

    public int changeCreatedDrawStatus(String script) throws SQLException, ClassNotFoundException {
        log.info("--- Conect OracleSQL DB --------");
        dBOracleSQL = Oracle_SQL_Database.getOracleDataBase();
        log.info("--- Conected to OracleSQL --------");
        int tempCode = dBOracleSQL.changeTable(script);

        dBOracleSQL.quit();
        return tempCode;
    }

    public int reformBlob(String script) throws SQLException, ClassNotFoundException {
        log.info("--- Conect OracleSQL DB --------");
        dBOracleSQL = Oracle_SQL_Database.getOracleDataBase();
        log.info("--- Conected to OracleSQL --------");
        int tempCode = dBOracleSQL.changeTable(script);

        dBOracleSQL.quit();
        return tempCode;
    }

    public String getMegalotMaccodeForWinPayment() throws SQLException, ClassNotFoundException {
        log.info("--- Conect OracleSQL DB --------");
        dBOracleSQL = Oracle_SQL_Database.getOracleDataBase();
        log.info("--- Conected to OracleSQL --------");
        String tempCode = dBOracleSQL
                .selectValue(configProperties.GET_MACCODE_FOR_MEGALOT_WIN_PAYMENT());

        dBOracleSQL.quit();
        return tempCode;
    }

    public String getMegalotTicketWinSum() throws SQLException, ClassNotFoundException {
        log.info("--- Conect OracleSQL DB --------");
        dBOracleSQL = Oracle_SQL_Database.getOracleDataBase();
        log.info("--- Conected to OracleSQL --------");
        String tempCode = dBOracleSQL
                .selectValue(configProperties.GET_TICKET_WIN_SUM());

        dBOracleSQL.quit();
        return tempCode;
    }



}
