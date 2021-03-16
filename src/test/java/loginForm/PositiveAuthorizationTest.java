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
        loginPage.openPage();
        loginPage.enterValidLoginPass();
        loginPage.clickVhidToSignIn();
        loginPage.clickOnPhoneNumber();
        loginPage.waitUntilSmsCodeIsReceived();
        loginPage.enterSmsCodeIntoField(utilsForMySQL.getSMSCodeForAuth());
        loginPage.clickSmsCodeInputConfirmation();

        checkExpectedResult("Page hasn't loaded yet", lotteriesPage.isNewOSAnnouncementDisplayed());
        lotteriesPage.clickContinueNewOSButton();

        checkExpectedResult("Page hasn't loaded yet", lotteriesPage.isJackpotAnnouncementDisplayed());
        lotteriesPage.clickContinueJackpotButton();

        checkExpectedResult("Page hasn't loaded yet", lotteriesPage.isLotteriesListDisplayed());
            }
}