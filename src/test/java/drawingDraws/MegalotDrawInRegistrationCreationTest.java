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
        oracleSQLDBConnect();

        String drawCode = drawsLotteryInfoPage.getDrawCodeForNewDrawForCreation(database.selectValue(configProperties.SCRIPT_DRAW_CODE()));
        String jackpotSum = "1000000";
        String megaPrizeSum = "500000";
        String drawInRegistration = database.selectValue(configProperties.DRAW_COUNT_IN_REGISTRATION_BET_STATUS());
        String drawInMultyRegistration = database.selectValue(configProperties.DRAW_COUNT_IN_MULTY_REGISTRATION_BET_STATUS());
        String drawInCreatedStat = database.selectValue(configProperties.DRAW_COUNT_IN_CREATED_STATUS());
        String drawIdForCreated = database.selectValue(configProperties.DRAW_ID_IN_CREATED_STATUS());

        database.changeTable(drawsLotteryInfoPage.createDrawInDBScript(drawCode));

        String drawId = database.selectValue(drawsLotteryInfoPage.getDrawIdOfCreatedDraw(drawCode));

        database.changeTable(drawsLotteryInfoPage.changeParamsForNewDraw(database.selectValue(drawsLotteryInfoPage.getDrawIdOfCreatedDraw(drawCode)), drawCode, jackpotSum, megaPrizeSum));
        database.changeTable(drawsLotteryInfoPage.changeCreatedDrawStatus(drawInRegistration, drawInMultyRegistration
                , drawInCreatedStat, drawIdForCreated, drawId));
        database.changeTable(drawsLotteryInfoPage.reformBlob(drawId));
    }
}
