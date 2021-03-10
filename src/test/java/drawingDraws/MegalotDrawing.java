package drawingDraws;

import abstractParentTest.AbstractParentTest;

import io.qameta.allure.*;
import org.junit.Test;

import java.sql.SQLException;
import java.text.ParseException;

public class MegalotDrawing extends AbstractParentTest {

    @Description("MegalotDrawing")
    @Story("MegalotDrawing")
    @Link("")
    @Link(name = "allure", type = "mylink")
    @Severity(SeverityLevel.CRITICAL)

    @Test()
    public void megalotDrawingDraw() throws SQLException, ClassNotFoundException, ParseException {
        oracleSQLDBConnect();

        String drawInRegistration = database.selectValue(configProperties.DRAW_COUNT_IN_REGISTRATION_BET_STATUS());
        String drawIdForRegisatration = database.selectValue(configProperties.DRAW_ID_IN_REGISTRATION_BET_STATUS());
        String drawInMultyRegistration = database.selectValue(configProperties.DRAW_COUNT_IN_MULTY_REGISTRATION_BET_STATUS());
        String drawIdForMultyRegistration = database.selectValue(configProperties.DRAW_ID_IN_MULTY_REGISTRATION_BET_STATUS());
        String drawInCreatedStat = database.selectValue(configProperties.DRAW_COUNT_IN_CREATED_STATUS());
        String drawIdForCreated = database.selectValue(configProperties.DRAW_ID_IN_CREATED_STATUS());
        String jackpotValue = "100000";
        String megaBallValue = "50000";
        String ball1Value = "1";
        String ball2Value = "2";
        String ball3Value = "3";
        String ball4Value = "4";
        String ball5Value = "5";
        String ball6Value = "6";
        String ball7Value = "7";

        drawsLoginPage.openAddPage();
        drawsLoginPage.drawsAuth();
        drawsMainMenuPage.clickDrawInfoButton();
        drawsLotteryInfoPage.determineDrawForDrawing(drawInRegistration
                , drawIdForRegisatration
                ,drawInMultyRegistration
                ,drawIdForMultyRegistration
                ,drawInCreatedStat
                ,drawIdForCreated
                ,jackpotValue, megaBallValue, ball1Value, ball2Value, ball3Value, ball4Value
                , ball5Value, ball6Value, ball7Value
                , database.changeTable(drawsLotteryInfoPage.getScriptForChangingDrawStatusInRegistrationBet(
                        drawsLotteryInfoPage.searchForDrawId(drawInRegistration
                                ,drawIdForRegisatration
                                ,drawInMultyRegistration
                                ,drawIdForMultyRegistration
                                ,drawInCreatedStat
                                ,drawIdForCreated))));
    }
}
