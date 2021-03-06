package autoLoto;

import abstractParentTest.AbstractParentTest;
import io.qameta.allure.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Elena Dovhaliuk
 */

@Epic("AutoLoto")
@Feature("PurchaseTicket")
@RunWith(Parameterized.class)

public class AutoLotoTicketBuyTest extends AbstractParentTest {
    private int ticketCount;
    private int drawNumCount;
    private String playerPhone = "684353443";
    private String betSum;

    public AutoLotoTicketBuyTest (int ticketCountToBuy, int drawNumCount) {
        this.ticketCount = ticketCountToBuy;
        this.drawNumCount = drawNumCount;
    }

    @Parameterized.Parameters(name = "Parameters are {0}, {1}")
    public static Collection testData(){
        return Arrays.asList(new Object[][] {
                        {1, 2}
                        , {2, 2}
                        , {3, 2}
                        , {4, 2}
                        , {5, 2}
                        , {6, 2}
                        , {7, 2}
                        , {8, 2}
                        , {9, 2}
                        , {10, 2}
                }
        );
    }

    @Description("Authorization")
    @Story("Authorization")
    @Link("")
    @Link(name = "allure", type = "mylink")
    @Severity(SeverityLevel.CRITICAL)

    @Test()
    public void autoLotoTicketPurchase() throws SQLException, ClassNotFoundException {

        loginForm.openPage();
        loginForm.signIn();
        loginForm.isSmsCodeInputFieldDisplayed();
        loginForm.enterSmsCodeIntoField(utilsForMySQL.getSMSCode());
        loginForm.clickSmsCodeInputConfirmation();

        checkExpectedResult("Page hasn't loaded yet",lotteries.isNewOSAnnouncementDisplayed());
        lotteries.clickContinueNewOSButton();

        checkExpectedResult("Page hasn't loaded yet",lotteries.isJackpotAnnouncementDisplayed());
        lotteries.clickContinueJackpotButton();

        checkExpectedResult("Page hasn't loaded yet",lotteries.isLotteriesListDisplayed());

//        oracleSQLDBConnect();
        emlPurchaseMenuPage.chooseEMLPurchaseMenu();
        emlPurchaseMenuPage.chooseAutoLotoPurchaseMenu();
        emlPurchaseMenuPage.chooseEMLTicketCount(ticketCount);
        emlPurchaseMenuPage.chooseDrawFromTheList(drawNumCount);
        betSum = emlPurchaseMenuPage.betSumCount(emlPurchaseMenuPage.getSeriesCost(drawNumCount), ticketCount);

        checkExpectedText("The sum of Auto Loto check is incorrect!"
                , betSum
                , emlPurchaseMenuPage.getBetSum());

        emlPurchaseMenuPage.confirmPurchase();

        checkExpectedText("The sum of Auto Loto check is incorrect!"
                , betSum
                , purchaseRegistrationPage.getBetSum());

        purchaseRegistrationPage.enterPhoneNumberForPurchase(playerPhone);
        purchaseRegistrationPage.clickSendSMSButton();
        purchaseRegistrationPage.waitUntilSmsCodeWillBeSent();
        purchaseRegistrationPage.enterSmsIntoInput(utilsForOracleSQL.getSMSCodeForPurchaseConfirmation());
        purchaseRegistrationPage.clickRegistrationButton();
        lotteries.isRegistrationSuccesfulPopUpVisible();
        lotteries.clickContinueWorkAfterRegistrationSuccess();

        checkExpectedResult("Page has not loaded after the registration", lotteries.isLotteriesListDisplayed());

        checkExpectedText("Total bets sum is not correct"
                , betSum
                , lotteries.getTotalBetsSum());

    }
}
