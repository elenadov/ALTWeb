package drawingDraws;

import abstractParentTest.AbstractParentTest;

import io.qameta.allure.*;
import org.junit.Test;

import java.sql.SQLException;
import java.text.ParseException;

public class MegalotDrawing extends AbstractParentTest {

    @Description("MegalotWinPay")
    @Story("MegalotWinPay")
    @Link("")
    @Link(name = "allure", type = "mylink")
    @Severity(SeverityLevel.CRITICAL)

    @Test()
    public void megalotDrawingDraw() throws SQLException, ClassNotFoundException, ParseException {
        oracleSQLDBConnect();

        drawsLoginPage.openAddPage();
        drawsLoginPage.drawsAuth();
        drawsMainMenuPage.clickDrawInfoButton();
        drawsLotteryInfoPage.determineDrawForDrawing(
         database.selectValue(configProperties.DRAW_COUNT_IN_REGISTRATION_BET_STATUS())
                ,database.selectValue(configProperties.DRAW_ID_IN_REGISTRATION_BET_STATUS())
        ,database.selectValue(configProperties.DRAW_COUNT_IN_MULTY_REGISTRATION_BET_STATUS())
                ,database.selectValue(configProperties.DRAW_ID_IN_MULTY_REGISTRATION_BET_STATUS())
        ,database.selectValue(configProperties.DRAW_COUNT_IN_CREATED_STATUS())
                ,database.selectValue(configProperties.DRAW_ID_IN_CREATED_STATUS()));
    }
}
