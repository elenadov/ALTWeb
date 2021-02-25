package pages;

import io.qameta.allure.Step;
import libs.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by Elena Dovhaliuk
 */

public class PurchaseRegistrationPage extends ParentPage {
    public PurchaseRegistrationPage(WebDriver webDriver) {
        super(webDriver, "/lotteries/instant-lotteries/registry");
    }

    @FindBy(xpath = "//input[@class='masked-input']")
    private TextInput phoneNumberInput;

    @FindBy(xpath = "//button[@class='button ci-button ci-button_sms ci-button_under button_theme_green ng-star-inserted']")
    private Button sendSMSButton;

    @FindBy(xpath = "//ng-component/app-check-information//app-msl-input-pin//input")
    private TextInput confirmationSmsCodeInput;

    @FindBy(xpath = "//div[@class='pin-title ng-star-inserted']")
    private TextBlock confirmationCodeFromSmsHeader;

    @FindBy(xpath = "//button[@class='button button_theme_green ci-button ci-button_reg ng-star-inserted']")
    private Button registrationButton;

    @FindBy(xpath = "//app-check-information//div[8]")
    private TextBlock betSum;

    /**
     * Created by Elena Dovhaliuk
     * This method enters phone number into input
     * @param number
     */
    @Step
    public void enterPhoneNumberForPurchase(String number){
        actionWithWebElements.enterTextIntoInput(phoneNumberInput, number);
    }

    /**
     * Created by Elena Dovhaliuk
     * Such method clicks send SMS button
     */
    @Step
    public void clickSendSMSButton(){
        actionWithWebElements.clickOnElement(sendSMSButton);
    }

    /**
     * Created by Elena Dovhaliuk
     * This method waits a bit till sms code is received
     */
    @Step
    public void waitUntilSmsCodeWillBeSent(){
        Utils.waitABit(3);
        actionWithWebElements.waitVisibilityOfElement(confirmationCodeFromSmsHeader);
        actionWithWebElements.waitVisibilityOfElement(confirmationSmsCodeInput);
    }

    /**
     * Created by Elena Dovhaliuk
     * This method enters received sms code into input
     * @param smsCode
     */
    @Step
    public void enterSmsIntoInput(String smsCode){
        actionWithWebElements.enterTextIntoInput(confirmationSmsCodeInput, smsCode);
    }

    /**
     * Created by Elena Dovhaliuk
     * This method clicks registration button to continue the process of purchase
     */
    @Step
    public void clickRegistrationButton(){
        actionWithWebElements.clickOnElement(registrationButton);
    }

    /**
     * Created by Elena Dovhaliuk
     * Such method returns sum of the check (at the end of the purchase)
     * @return
     */
    @Step
    public String getBetSum(){
        return actionWithWebElements.getTextFromElementSum(betSum);
    }

}
