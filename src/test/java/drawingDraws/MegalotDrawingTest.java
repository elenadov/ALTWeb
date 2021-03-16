package drawingDraws;

import abstractParentTest.AbstractParentTest;

import io.qameta.allure.*;
import org.junit.Test;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * Created by Elena Dovhaliuk
 */

public class MegalotDrawingTest extends AbstractParentTest {

    @Description("MegalotDrawingTest")
    @Story("MegalotDrawingTest")
    @Link("")
    @Link(name = "allure", type = "mylink")
    @Severity(SeverityLevel.CRITICAL)

    @Test()
    public void megalotDrawingDraw() throws SQLException, ClassNotFoundException, ParseException {
//        oracleSQLDBConnect();

        String drawInRegistration = utilsForOracleSQL.getDrawCountInRegistration();
        String drawIdForRegisatration = utilsForOracleSQL.getDrawIdInRegistration();
        String drawInMultyRegistration = utilsForOracleSQL.getDrawCountInMultyRegistration();
        String drawIdForMultyRegistration = utilsForOracleSQL.getDrawIdInMultyRegistration();
        String drawInCreatedStat = utilsForOracleSQL.getDrawCountInCreatedStatus();
        String drawIdForCreated = utilsForOracleSQL.getDrawIdInCreatedStatus();
        String jackpotValue = "100000";
        String megaBallValue = "50000";
        String ball1Value = "1";
        String ball2Value = "2";
        String ball3Value = "3";
        String ball4Value = "4";
        String ball5Value = "5";
        String ball6Value = "6";
        String ball7Value = "0";

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
                , utilsForOracleSQL.changeDrawStatusInRegistration(
                        drawsLotteryInfoPage.getScriptForChangingDrawStatusInRegistrationBet(
                        drawsLotteryInfoPage.searchForDrawId(drawInRegistration
                                ,drawIdForRegisatration
                                ,drawInMultyRegistration
                                ,drawIdForMultyRegistration
                                ,drawInCreatedStat
                                ,drawIdForCreated))));

        String drawInRegistrationContinue = utilsForOracleSQL.getDrawCountInRegistration();
        String drawIdForRegisatrationContinue = utilsForOracleSQL.getDrawIdInRegistration();
        String drawInMultyRegistrationContinue = utilsForOracleSQL.getDrawCountInMultyRegistration();
        String drawIdForMultyRegistrationContinue = utilsForOracleSQL.getDrawIdInMultyRegistration();
        String drawInCreatedStatContinue = utilsForOracleSQL.getDrawCountInCreatedStatus();
        String drawIdForCreatedContinue = utilsForOracleSQL.getDrawIdInCreatedStatus();

        drawsLotteryInfoPage.selectDrawForRegChange(drawInRegistrationContinue, drawInMultyRegistrationContinue
                , drawIdForMultyRegistrationContinue, drawInCreatedStatContinue, drawIdForCreatedContinue
                ,utilsForOracleSQL.changeDrawStatusInRegistration(drawsLotteryInfoPage.getScriptForChangingDrawStatusInRegistrationBet(
                        drawsLotteryInfoPage.searchForDrawId(drawInRegistrationContinue
                                ,drawIdForRegisatrationContinue
                                ,drawInMultyRegistrationContinue
                                ,drawIdForMultyRegistrationContinue
                                ,drawInCreatedStatContinue
                                ,drawIdForCreatedContinue))));
    }
}
