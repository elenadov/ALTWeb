package lotoZabavaTest;

import abstractParentTest.AbstractParentTest;
import io.qameta.allure.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

@Epic("LotoZabava")
@Feature("PurchaseTicket")
@RunWith(Parameterized.class)

public class LotoZabavaTicketBuyTest extends AbstractParentTest {
    private int ticketCount;
    private int parochkaCount;
    private String richAndFamousContest;
    private String playerPhone = "684353443";

    public LotoZabavaTicketBuyTest (int ticketCountToBuy, int parochkaCount, String richAndFamousContest) {
        this.ticketCount = ticketCountToBuy;
        this.parochkaCount = parochkaCount;
        this.richAndFamousContest = richAndFamousContest;
    }

    @Parameterized.Parameters(name = "Parameters are {0}, {1}, {2}")
    public static Collection testData(){
        return Arrays.asList(new Object[][] {
                {1, 1, "check"},
                {2, 2, "uncheck"},
                {3, 3, "check"},
                {4, 4, "uncheck"},
                {5, 5, "check"},
                {6, 0, "uncheck"},
                {7, 1, "check"},
                {8, 2, "uncheck"},
                {9, 3, "check"},
                {10, 4, "uncheck"}
                }
        );
    }

    @Description("Authorization")
    @Story("Authorization")
    @Link("")
    @Link(name = "allure", type = "mylink")
    @Severity(SeverityLevel.CRITICAL)

    @Test()
    public void lotoZabavaBuyOneTicket() throws SQLException, ClassNotFoundException {
        loginForm.openPage();
        loginForm.signIn();
        loginForm.enterSmsCodeIntoField(database.selectValue(configProperties.GET_SMS_CODE_FOR_AUTH()));
        loginForm.clickSmsCodeInputConfirmation();

        oracleSQLDBConnect();

        checkExpectedResult("Page hasn't loaded yet",lotteries.isNewOSAnnouncementDisplayed());
        lotteries.clickContinueNewOSButton();

        checkExpectedResult("Page hasn't loaded yet",lotteries.isJackpotAnnouncementDisplayed());
        lotteries.clickContinueJackpotButton();

        checkExpectedResult("Page hasn't loaded yet",lotteries.isLotteriesListDisplayed());

        lotoZabavaPurchaseMenuPage.chooseLZFromTheListOfLotteries();
        lotoZabavaPurchaseMenuPage.chooseFirstLZDrawInRegistration();
        lotoZabavaPurchaseMenuPage.chooseLZTicketCount(ticketCount);
        lotoZabavaPurchaseMenuPage.chooseParochkaCount(parochkaCount);
        lotoZabavaPurchaseMenuPage.selectRichAndFamousContest(richAndFamousContest);

        checkExpectedText("Bet sum is not correct", "ДО СПЛАТИ: " + (lotoZabavaPurchaseMenuPage.calculateLZBetSum(ticketCount, parochkaCount, richAndFamousContest)) + ".00 ГРН"
        , lotoZabavaPurchaseMenuPage.getLZCheckSum());

        lotoZabavaPurchaseMenuPage.clickBuyLZButton();

        checkExpectedText("Bet sum is not correct", (lotoZabavaPurchaseMenuPage.calculateLZBetSum(ticketCount, parochkaCount, richAndFamousContest)) + ".00 грн"
        , purchaseRegistrationPage.getBetSum());

        purchaseRegistrationPage.enterPhoneNumberForPurchase(playerPhone);
        purchaseRegistrationPage.clickSendSMSButton();
        purchaseRegistrationPage.waitUntilSmsCodeWillBeSent();
        purchaseRegistrationPage.enterSmsIntoInput(database.selectValue((configProperties.GET_SMS_CODE_FOR_SELL())));
        purchaseRegistrationPage.clickRegistrationButton();
        lotteries.isRegistrationSuccesfulPopUpVisible();
        lotteries.clickContinueWorkAfterRegistrationSuccess();

        checkExpectedResult("Page has not loaded after the registration", lotteries.isLotteriesListDisplayed());
    }
}
