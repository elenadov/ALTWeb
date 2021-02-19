package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextBlock;

import java.util.Locale;

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

    @Step
    public String getTicketWinSum(){
        return actionWithWebElements.getTextFromElementSum(winSum);
    }

    @Step
    public String getWinPaymentAllowanceMessage(){
        return actionWithWebElements.getTextFromElement(winPaymentAllowanceMessage);
    }

    @Step
    public String getTicketWinStatus(){
        return actionWithWebElements.getTextFromElement(ticketWinStatus);
    }

    @Step
    public void clickWinPaymentConfirmationButton(){
        actionWithWebElements.clickOnElement(winPaymentConfirmationButton);
    }

    @Step
    public void isWinPaymentSuccessMessageIsVisible(){
        actionWithWebElements.waitVisibilityOfElement(winPaymentSuccessMessage);
    }

    @Step
    public String getMessageDescription(){
        return actionWithWebElements.getTextFromElement(messageDescription);
    }

    @Step
    public void clickContinueButton(){
        actionWithWebElements.clickOnElement(continueButton);
    }

    @Step
    public String getTicketWinSumAfterTaxRemoval(){
        String res = actionWithWebElements.getTextFromElementSum(winSumAfterTaxRemoval);
        return res;
    }

    @Step
    public String correctDBSum(String sum){
        float correctSum = Integer.valueOf(sum) / 100;
        return String.format(Locale.ROOT,"%.2f", correctSum);
    }

    @Step
    public void waitUntilWinPayPageIsLoaded(){
        actionWithWebElements.waitVisibilityOfElement(scanBarcode);
    }
}
