package drawingDraws;

import abstractParentTest.AbstractParentTest;
import io.qameta.allure.*;
import org.junit.Test;

import java.sql.SQLException;
import java.text.ParseException;

public class MegalotDrawInRegistrationCreation extends AbstractParentTest {

    @Description("MegalotDrawing")
    @Story("MegalotDrawing")
    @Link("")
    @Link(name = "allure", type = "mylink")
    @Severity(SeverityLevel.CRITICAL)

    @Test()
    public void megalotDrawCreation() throws SQLException, ClassNotFoundException, ParseException {
        String lastDrawInTheList = configProperties.DRAW_ID_IN_CREATED_STATUS();
        String jackpotValue = "100000";
        String megaBallValue = "50000";

        oracleSQLDBConnect();

        drawsLoginPage.openAddPage();
        drawsLoginPage.drawsAuth();
        drawsMainMenuPage.clickDrawInfoButton();
        drawsLotteryInfoPage.createNewDraw(lastDrawInTheList, jackpotValue, megaBallValue);
    }
}
