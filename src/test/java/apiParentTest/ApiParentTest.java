package apiParentTest;

import io.qameta.allure.Step;
import libs.*;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import paramsForRequests.MegalotRegBet;
import paramsForRequests.ParamsForRequests;
import paramsForRequests.ZabavaRegBet;

import java.sql.SQLException;

/**
 * Created by Elena Dovhaliuk
 */

public class ApiParentTest {
    protected Database database;
    protected Logger logger = Logger.getLogger(getClass());
    protected ParamsForRequests paramsForRequests = new ParamsForRequests();
    protected static ConfigProperties configProperties =
            ConfigFactory.create(ConfigProperties.class);
    protected ZabavaRegBet zabavaRegBet = new ZabavaRegBet();
    protected MegalotRegBet megalotRegBet = new MegalotRegBet();
    protected UtilsForMySQL utilsForMySQL = new UtilsForMySQL();

    @Before
    public void mySQLDBConnect() throws SQLException, ClassNotFoundException {
        database = MySQL_Database.getDataBase();
    }

    @Step
    public void oracleSQLDBConnect() throws SQLException, ClassNotFoundException {
        database = Oracle_SQL_Database.getOracleDataBase();
    }

    @After
    public void tearDown() throws SQLException {
        database.quit();
    }
}
