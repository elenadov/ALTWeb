package drawingDraws;

import abstractParentTest.AbstractParentTest;
import io.qameta.allure.*;
import org.junit.Test;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * Created by Elena Dovhaliuk
 */

public class MegalotDrawInRegistrationCreationTest extends AbstractParentTest {

    @Description("MegalotDrawingTest")
    @Story("MegalotDrawingTest")
    @Link("")
    @Link(name = "allure", type = "mylink")
    @Severity(SeverityLevel.CRITICAL)

    @Test()
    public void megalotDrawCreation() throws SQLException, ClassNotFoundException, ParseException {
//        oracleSQLDBConnect();

        String drawCode = drawsLotteryInfoPage.getDrawCodeForNewDrawForCreation(utilsForOracleSQL.getMegalotLastDrawCodeCreated());
        String jackpotSum = "1000000";
        String megaPrizeSum = "500000";
        String drawInRegistration = utilsForOracleSQL.getDrawCountInRegistration();
        String drawInMultyRegistration = utilsForOracleSQL.getDrawCountInMultyRegistration();
        String drawInCreatedStat = utilsForOracleSQL.getDrawCountInCreatedStatus();
        String drawIdForCreated = utilsForOracleSQL.getDrawIdInCreatedStatus();

        utilsForOracleSQL.createDrawInDB(drawsLotteryInfoPage.createDrawInDBScript(drawCode));

        String drawId = utilsForOracleSQL.getDrawIdOfCreatedDraw(drawsLotteryInfoPage.getDrawIdOfCreatedDraw(drawCode));

        utilsForOracleSQL.changeParamsForNewDraw(drawsLotteryInfoPage.changeParamsForNewDraw(utilsForOracleSQL.getDrawIdOfCreatedDraw(drawsLotteryInfoPage.getDrawIdOfCreatedDraw(drawCode)), drawCode, jackpotSum, megaPrizeSum));
        utilsForOracleSQL.changeCreatedDrawStatus(drawsLotteryInfoPage.changeCreatedDrawStatus(drawInRegistration, drawInMultyRegistration
                , drawInCreatedStat, drawIdForCreated, drawId));
        utilsForOracleSQL.reformBlob(drawsLotteryInfoPage.reformBlob(drawId));
    }
}
