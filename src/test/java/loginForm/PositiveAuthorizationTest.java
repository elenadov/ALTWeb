package loginForm;

import abstractParentTest.AbstractParentTest;
import io.qameta.allure.*;
import org.junit.Test;

import java.sql.SQLException;

/**
 * Created by Elena Dovhaliuk
 */

@Epic("Login")
@Feature("Authorization")
public class PositiveAuthorizationTest extends AbstractParentTest {

    @Description("Valid authorization")
    @Story("Authorization")
    @Link("")
    @Link(name = "allure", type = "mylink")
    @Severity(SeverityLevel.CRITICAL)

    @Test()
    public void authorization() throws SQLException, ClassNotFoundException {
        loginForm.openPage();
        loginForm.enterValidLoginPass();
        loginForm.clickVhidToSignIn();
        loginForm.clickOnPhoneNumber();
        loginForm.waitUntilSmsCodeIsReceived();
        loginForm.enterSmsCodeIntoField(utilsForMySQL.getSMSCode());
        loginForm.clickSmsCodeInputConfirmation();

        checkExpectedResult("Page hasn't loaded yet",lotteries.isNewOSAnnouncementDisplayed());
        lotteries.clickContinueNewOSButton();

        checkExpectedResult("Page hasn't loaded yet",lotteries.isJackpotAnnouncementDisplayed());
        lotteries.clickContinueJackpotButton();

        checkExpectedResult("Page hasn't loaded yet",lotteries.isLotteriesListDisplayed());
            }
}