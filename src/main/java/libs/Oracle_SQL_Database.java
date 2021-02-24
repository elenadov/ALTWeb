package libs;

import org.aeonbits.owner.ConfigFactory;

import java.sql.SQLException;

/**
 * Created by Elena Dovhaliuk
 */

public class Oracle_SQL_Database {
    private static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);

    public static Database getOracleDataBase() throws SQLException, ClassNotFoundException {
        return new Database(
                configProperties.Oracle()
                , configProperties.ORACLE_SQL_DB()
                , configProperties.ORACLE_SQL_DB_USER()
                , configProperties.ORACLE_SQL_DB_PASSWORD());
    }
}
