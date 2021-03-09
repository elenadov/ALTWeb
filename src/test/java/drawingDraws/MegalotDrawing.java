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
        String drawInRegistration = configProperties.DRAW_COUNT_IN_REGISTRATION_BET_STATUS();
        String drawIdForRegisatration = configProperties.DRAW_ID_IN_REGISTRATION_BET_STATUS();
        String drawInMultyRegistration = configProperties.DRAW_COUNT_IN_MULTY_REGISTRATION_BET_STATUS();
        String drawIdForMultyRegistration = configProperties.DRAW_ID_IN_MULTY_REGISTRATION_BET_STATUS();
        String drawInCreatedStat = configProperties.DRAW_COUNT_IN_CREATED_STATUS();
        String drawIdForCreated = configProperties.DRAW_ID_IN_CREATED_STATUS();
        String jackpotValue = "100000";
        String megaBallValue = "50000";
        String ball1Value = "1";
        String ball2Value = "2";
        String ball3Value = "3";
        String ball4Value = "4";
        String ball5Value = "5";
        String ball6Value = "6";
        String ball7Value = "7";



        oracleSQLDBConnect();

        drawsLoginPage.openAddPage();
        drawsLoginPage.drawsAuth();
        drawsMainMenuPage.clickDrawInfoButton();
        drawsLotteryInfoPage.determineDrawForDrawing(
         database.selectValue(drawInRegistration)
                ,database.selectValue(drawIdForRegisatration)
                ,database.selectValue(drawInMultyRegistration)
                ,database.selectValue(drawIdForMultyRegistration)
                ,database.selectValue(drawInCreatedStat)
                ,database.selectValue(drawIdForCreated)
                ,jackpotValue, megaBallValue, ball1Value, ball2Value, ball3Value, ball4Value
                , ball5Value, ball6Value, ball7Value
                , database.changeTable(drawsLotteryInfoPage.getScriptForChangingDrawStatusInRegistrationBet(
                        drawsLotteryInfoPage.searchForDrawId(database.selectValue(drawInRegistration)
                                ,database.selectValue(drawIdForRegisatration)
                                ,database.selectValue(drawInMultyRegistration)
                                ,database.selectValue(drawIdForMultyRegistration)
                                ,database.selectValue(drawInCreatedStat)
                                ,database.selectValue(drawIdForCreated)))));
    }
}
