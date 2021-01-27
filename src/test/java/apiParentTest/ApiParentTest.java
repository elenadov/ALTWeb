package apiParentTest;

import libs.ConfigProperties;
import libs.Database;
import libs.Oracle_SQL_Database;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Before;
import paramsForRequests.ParamsForRequests;

import java.sql.SQLException;
import java.time.Instant;

public class ApiParentTest {
    protected Database database;
    protected Logger logger = Logger.getLogger(getClass());
    protected ParamsForRequests paramsForRequests = new ParamsForRequests();

    protected static ConfigProperties configProperties =
            ConfigFactory.create(ConfigProperties.class);

    public long currentTime = Instant.now().getEpochSecond();
    public String timestamp = currentTime + "12345";

    @Before
    public void oracleSQLDBConnect() throws SQLException, ClassNotFoundException {
        database = Oracle_SQL_Database.getOracleDataBase();
    }

}
