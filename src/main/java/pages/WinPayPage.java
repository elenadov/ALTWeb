package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextBlock;

import java.util.Locale;

/**
 * Created by Elena Dovhaliuk
 */

public class WinPayPage extends ParentPage {
    public WinPayPage(WebDriver webDriver) {
        super(webDriver, "/tickets/payment");
    }

    @FindBy(xpath = "//div[1]/label[@class='tpc-info-value']")
    private TextBlock winSum;

    @FindBy(xpath = "//label[@class='tpc-payment-state allowed-payment']")
    private TextBlock winPaymentAllowanceMessage;

    @FindBy(xpath = "//label[@class='tpc-header']")
    private TextBlock ticketWinStatus;

    @FindBy(xpath = "//div[@class='tpc-bottom-panel']//button[2]")
    private Button winPaymentConfirmationButton;

    @FindBy(xpath = "//app-one-button-error//div[@class='modal-dialog-container']")
    private TextBlock winPaymentSuccessMessage;

    @FindBy(xpath = "//app-one-button-error//div[@class='modal-alt-message']")
    private TextBlock messageDescription;

    @FindBy(xpath = "//div[@class='modal-buttons-container']/button")
    private Button continueButton;

    @FindBy(xpath = "//div[2]/label[@class='tpc-info-value']")
    private TextBlock winSumAfterTaxRemoval;

    @FindBy(xpath = "//div[@class='spoiler-header']")
    private Button scanBarcode;

    /**
     * Created by Elena Dovhaliuk
     * This method returns ticket win sum (displayed on the page)
     * @return
     */
    @Step
    public String getTicketWinSum(){
        return actionWithWebElements.getTextFromElementSum(winSum);
    }

    /**
     * Created by Elena Dovhaliuk
     * Such method returns win payment allowance message (displayed on the page) for the further comparison
     * @return
     */
    @Step
    public String getWinPaymentAllowanceMessage(){
        return actionWithWebElements.getTextFromElement(winPaymentAllowanceMessage);
    }

    /**
     * Created by Elena Dovhaliuk
     * Such method returns ticket win status (displayed on the page)
     * @return
     */
    @Step
    public String getTicketWinStatus(){
        return actionWithWebElements.getTextFromElement(ticketWinStatus);
    }

    /**
     * Created by Elena Dovhaliuk
     * This method clicks confirmation button to check ticket win by barcode (WinCheck)
     */
    @Step
    public void clickWinPaymentConfirmationButton(){
        actionWithWebElements.clickOnElement(winPaymentConfirmationButton);
    }

    /**
     * Created by Elena Dovhaliuk
     * This method checks the visibility of successful win payment message
     */
    @Step
    public void isWinPaymentSuccessMessageIsVisible(){
        actionWithWebElements.waitVisibilityOfElement(winPaymentSuccessMessage);
    }

    /**
     * Created by Elena Dovhaliuk
     * This method returns win payment message description for the further comparison
     * @return
     */
    @Step
    public String getMessageDescription(){
        return actionWithWebElements.getTextFromElement(messageDescription);
    }

    /**
     * Created by Elena Dovhaliuk
     * This method clicks continue button to continue win payment process (WinPay)
     */
    @Step
    public void clickContinueButton(){
        actionWithWebElements.clickOnElement(continueButton);
    }

    /**
     * Created by Elena Dovhaliuk
     * This method returns ticket win sum after tax removal for the further comparison
     * @return
     */
    @Step
    public String getTicketWinSumAfterTaxRemoval(){
        String res = actionWithWebElements.getTextFromElementSum(winSumAfterTaxRemoval);
        return res;
    }

    /**
     * Created by Elena Dovhaliuk
     * This method returns correct ticket win sum from DB (in kopecks) and converts it into hryvnas
     * (with hundredths = 2 symbols after the dot)
     * @param sum
     * @return
     */
    @Step
    public String correctDBSum(String sum){
        float correctSum = Integer.valueOf(sum) / 100;
        return String.format(Locale.ROOT,"%.2f", correctSum);
    }

    /**
     * Created by Elena Dovhaliuk
     * This method makes the test wait until win pay page is loaded
     */
    @Step
    public void waitUntilWinPayPageIsLoaded(){
        actionWithWebElements.waitVisibilityOfElement(scanBarcode);
    }

//    @Step
//    public boolean isTicketPaid(String winSumWithTax, String payTermDate
//            , String operatorWinPay, String terminalWinPay, String canceled){
//        logger.info(winSumWithTax + " ");
//        if (winSumWithTax != null && !winSumWithTax.trim().isEmpty()
//// && !payTermDate.isEmpty() && !operatorWinPay.isEmpty()
////                && !terminalWinPay.isEmpty() && canceled.equals("0")
// ){
//            logger.info("Win sum is paid successfully");
//            return true;
//        }
//        else{return false;}
//    }

//    @Step
//    public String getPayOperId(String maccode){
//        return configProperties.PAY_OPER_ID_SCRIPT() + maccode + "'";
//    }
//
//    @Step
//    public String getPayTermId(String maccode){
//        return configProperties.PAY_TERM_ID_SCRIPT() + maccode + "'";
//    }
//
//    @Step
//    public String getPayDate(String maccode){
//        return configProperties.PAY_DATE_SCRIPT() + maccode + "'";
//    }
//
//    @Step
//    public String getWinSumWithTax(String maccode){
//        return configProperties.WIN_SUM_WITH_TAX_SCRIPT() + maccode + "'";
//    }
//
//    @Step
//    public String getCanceledType(String maccode){
//        return configProperties.CANCELED_TYPE_SCRIPT() + maccode + "'";
//    }

}
