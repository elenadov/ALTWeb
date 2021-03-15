package megalotTest;

import abstractParentTest.AbstractParentTest;
import io.qameta.allure.*;
import org.junit.Test;

import java.sql.SQLException;

/**
 * Created by Elena Dovhaliuk
 */

@Epic("MegalotWinPay")
@Feature("MegalotWinPayment")

public class MegalotPositiveWinPayTest extends AbstractParentTest {

    @Description("MegalotWinPay")
    @Story("MegalotWinPay")
    @Link("")
    @Link(name = "allure", type = "mylink")
    @Severity(SeverityLevel.CRITICAL)

    @Test()
    public void megalotWinPayTest() throws SQLException, ClassNotFoundException {
        loginForm.openPage();
        loginForm.signIn();
        loginForm.enterSmsCodeIntoField(utilsForMySQL.getSMSCode());
        loginForm.clickSmsCodeInputConfirmation();

//        oracleSQLDBConnect();

        final String maccode = utilsForOracleSQL.getMegalotMaccodeForWinPayment();
        String winSum = utilsForOracleSQL.getMegalotTicketWinSum();


        checkExpectedResult("Page hasn't loaded yet", lotteries.isNewOSAnnouncementDisplayed());
        lotteries.clickContinueNewOSButton();

        checkExpectedResult("Page hasn't loaded yet", lotteries.isJackpotAnnouncementDisplayed());
        lotteries.clickContinueJackpotButton();

        checkExpectedResult("Page hasn't loaded yet", lotteries.isLotteriesListDisplayed());

        lotteries.clickWinPaymentMenuButton();
        winPayPage.waitUntilWinPayPageIsLoaded();
        winCheckPage.clickTicketBarcodeInput();
        winCheckPage.enterTicketMaccodeIntoInput(maccode);
        winCheckPage.clickCheckTicketWinButton();

        checkExpectedText("Ticket status is not correct", "Білет виграшний", winPayPage.getTicketWinStatus());

        winSum = winPayPage.correctDBSum(winSum);

        checkExpectedText("Ticket win sum is not correct"
                , winSum
                , winPayPage.getTicketWinSum());

        checkExpectedText("Win payment allowance message is not correct", "Виплата дозволена"
                , winPayPage.getWinPaymentAllowanceMessage());

        winPayPage.clickWinPaymentConfirmationButton();
        winPayPage.isWinPaymentSuccessMessageIsVisible();

        checkExpectedText("Successful win pay message is not correct"
                , "Виграш виплачено"
                , winPayPage.getMessageDescription());

        winSum = winPayPage.getTicketWinSumAfterTaxRemoval();
        winPayPage.clickContinueButton();
        lotteries.clickLotteryRegistrationMenuButton();

        checkExpectedResult("Page has not loaded after the registration", lotteries.isLotteriesListDisplayed());

        checkExpectedText("Operator's balance is not correct"
                , winSum
                , lotteries.getTotalBetsSum());
    }
}
