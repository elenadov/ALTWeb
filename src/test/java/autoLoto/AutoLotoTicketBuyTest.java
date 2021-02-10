package autoLoto;

import abstractParentTest.AbstractParentTest;
import io.qameta.allure.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

@Epic("Login")
@Feature("Authorization")
@RunWith(Parameterized.class)

public class AutoLotoTicketBuyTest extends AbstractParentTest {
    int ticketCount;
    private String playerPhone = "684353443";

    public AutoLotoTicketBuyTest (int ticketCountToBuy) {
        this.ticketCount = ticketCountToBuy;
    }

    @Parameterized.Parameters(name = "Parameters are {0}")
    public static Collection testData(){
        return Arrays.asList(new Object[][] {
                        {1},
                        {2},
                        {3},
                        {4},
                        {5},
                        {6},
                        {7},
                        {8},
                        {9},
                        {10}
                }
        );
    }

    @Description("Authorization")
    @Story("Authorization")
    @Link("")
    @Link(name = "allure", type = "mylink")
    @Severity(SeverityLevel.CRITICAL)

    @Test()
    public void autoLoto1TicketPurchase() throws SQLException, ClassNotFoundException {

        loginForm.openPage();
        loginForm.signIn();
        loginForm.enterSmsCodeIntoField(database.selectValue(configProperties.GET_SMS_CODE_FOR_AUTH()));
        loginForm.clickSmsCodeInputConfirmation();

        checkExpectedResult("Page hasn't loaded yet",lotteries.isNewOSAnnouncementDisplayed());
        lotteries.clickContinueNewOSButton();

        checkExpectedResult("Page hasn't loaded yet",lotteries.isJackpotAnnouncementDisplayed());
        lotteries.clickContinueJackpotButton();

        checkExpectedResult("Page hasn't loaded yet",lotteries.isLotteriesListDisplayed());

        oracleSQLDBConnect();
        emlPurchaseMenuPage.chooseEMLPurchaseMenu();
        emlPurchaseMenuPage.chooseAutoLotoPurchaseMenu();
        emlPurchaseMenuPage.selectOneTicketAutoLotoPurchase();
        emlPurchaseMenuPage.confirmPurchase();

        checkExpectedText("The sum of Auto Loto check is incorrect!",emlPurchaseRegistrationPage.autoLotocheckSum(ticketCount),
                emlPurchaseRegistrationPage.getCheckSum());

        emlPurchaseRegistrationPage.enterPhoneNumberForPurchase(playerPhone);
        emlPurchaseRegistrationPage.clickSendSMSButton();
        emlPurchaseRegistrationPage.waitUntilSmsCodeWillBeSent();
        emlPurchaseRegistrationPage.enterSmsIntoInput(database.selectValue((configProperties.GET_SMS_CODE_FOR_SELL())));
        emlPurchaseRegistrationPage.clickRegistrationButton();
        lotteries.isRegistrationSuccesfulPopUpVisible();
        lotteries.clickContinueWorkAfterRegistrationSuccess();

        checkExpectedResult("Page has not loaded after the registration", lotteries.isLotteriesListDisplayed());
//        lotteries.isAutoLotoCheckSumIsCorrect(ticketCount);
        lotteries.isAllTransactionsSumIsCorrect(ticketCount);
    }
}
