package apiParentTest;

import io.qameta.allure.Step;
import libs.ConfigProperties;
import libs.Database;
import libs.MySQL_Database;
import libs.Oracle_SQL_Database;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Before;
import pages.lotteriesDrawing.DrawsLoginPage;
import pages.lotteriesDrawing.DrawsLotteryInfoPage;
import pages.lotteriesDrawing.DrawsMainMenuPage;
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
    protected ZabavaRegBet zabavaRegBet = new ZabavaRegBet();
    protected static ConfigProperties configProperties =
            ConfigFactory.create(ConfigProperties.class);

    @Before
    public void mySQLDBConnect() throws SQLException, ClassNotFoundException {
        database = MySQL_Database.getDataBase();
    }

    @Step
    public void oracleSQLDBConnect() throws SQLException, ClassNotFoundException {
        database = Oracle_SQL_Database.getOracleDataBase();
    }

}
