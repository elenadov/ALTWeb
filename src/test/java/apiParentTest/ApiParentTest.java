package apiParentTest;

import io.qameta.allure.Step;
import libs.ConfigProperties;
import libs.Database;
import libs.MySQL_Database;
import libs.Oracle_SQL_Database;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import paramsForRequests.ParamsForRequests;

import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;

public class ApiParentTest {
    protected Database database;
    protected Logger logger = Logger.getLogger(getClass());
    protected ParamsForRequests paramsForRequests = new ParamsForRequests();

    protected static ConfigProperties configProperties =
            ConfigFactory.create(ConfigProperties.class);

    public long currentTime = Instant.now().getEpochSecond();
    public String timestamp = currentTime + "12345";

    @Before
    public void mySQLDBConnect() throws SQLException, ClassNotFoundException {
        database = MySQL_Database.getDataBase();
    }

    @Step
    public void oracleSQLDBConnect() throws SQLException, ClassNotFoundException {
        database = Oracle_SQL_Database.getOracleDataBase();
    }

    @Step
    protected void checkExpectedResult(String message, boolean actualResult) {
        Assert.assertEquals(message, true, actualResult);
    }

    @Step
    protected void checkExpectedText(String message, String expectedResult, String actualResult) {
        Assert.assertEquals(message, expectedResult, actualResult);
    }

    @Step
    protected void checkExpectedText(String message, ArrayList<String> expectedResult, ArrayList<String> actualResult){
        Assert.assertEquals(message,expectedResult,actualResult);
    }

}
