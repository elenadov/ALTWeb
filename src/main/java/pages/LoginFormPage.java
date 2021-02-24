package pages;

import io.qameta.allure.Step;
import libs.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.element.TextInput;
import java.sql.SQLException;

/**
 * Created by Elena Dovhaliuk
 */

public class LoginFormPage extends ParentPage {

    public LoginFormPage(WebDriver webDriver) {
        super(webDriver, "/auth");
    }

    @FindBy (xpath = "//*[@class='title']")
    private TextBlock title;

    @FindBy(xpath = "//div[@class='pin-title']")
    private TextBlock text;

    @FindBy(xpath = "//button[@class='button button_theme_green modal-button']")
    private Button continueButton;

    @FindBy(xpath = "//*[@class='empty-value']")
    private TextInput loginInput;

    @FindBy(xpath = "//*[@class='secured empty-value']")
    private TextInput passwordInput;

    @FindBy(xpath = "//*[@class='client-phone ng-star-inserted'][1]")
    private Button phoneNumber;

    @FindBy(xpath = "//*[@class='pin__input ng-pristine ng-valid ng-touched']")
    private TextInput smsCodeInput;

    @FindBy(xpath = "//*[@class='pin__input ng-pristine ng-valid ng-touched']")
    private By smsCodeInput1;

    @FindBy(xpath = "//button[@class='button auth-button auth-button_type_confirm button_theme_dark-green ng-star-inserted']")
    private Button enter;

    @FindBy(xpath = "//*[@class='button auth-button auth-button_type_confirm button_theme_dark-green ng-star-inserted']")
    private Button confirmSmsCodeInput;

    @FindBy(xpath = "//app-one-button-error/div/div")
    private TextBlock loginOrPasswordIsIncorrectPopUp;

    /**
     * Created by Elena Dovhaliuk
     * Such method fills in login input
     * @param login
     */
    @Step
    public void fillInLoginInput(String login){
        actionWithWebElements.enterTextIntoInput(loginInput, login);
    }

    /**
     * Created by Elena Dovhaliuk
     * Such method fills in password input
     * @param pass
     */
    @Step
    public void fillInPasswordInput(String pass){
        actionWithWebElements.enterTextIntoInput(passwordInput, pass);
    }

    /**
     * Created by Elena Dovhaliuk
     * Such method enters valid login into input
     */
    @Step
    public void enterValidLogin(){
        fillInLoginInput(configProperties.OPERATOR_LOGIN_FOR_TEST());
    }

    /**
     * Created by Elena Dovhaliuk
     * Such method enters valid password into input
     */
    @Step
    public void enterValidPassword(){
        fillInPasswordInput(configProperties.OPERATOR_PASSWORD_FOR_TEST());
    }

    /**
     * Created by Elena Dovhaliuk
     * Such method enters valid login and password into inputs
     */
    @Step
    public void enterValidLoginPass(){
        enterValidLogin();
        enterValidPassword();
    }

    /**
     * Created by Elena Dovhaliuk
     * This method clicks selected phone number
     */
    @Step
    public void clickOnPhoneNumber(){
        actionWithWebElements.clickOnElement(phoneNumber);
        actionWithWebElements.waitForText(text, "Код підтвердження з SMS:");
    }

    /**
     * Created by Elena Dovhaliuk
     * This method signs the operator in by filling valid login and password, clicking
     * selected phone number, waiting till sms code is received
     */
    @Step
    public void signIn(){
        enterValidLoginPass();
        clickVhidToSignIn();
        clickOnPhoneNumber();
        waitUntilSmsCodeIsReceived();
    }

    /**
     * Created by Elena Dovhaliuk
     * This method checks whether sms code input is displayed
     * @return
     */
    @Step
    public boolean isSmsCodeInputFieldDisplayed() {
        return actionWithWebElements.isElementDisplayed(smsCodeInput);
    }

    /**
     * Created by Elena Dovhaliuk
     * This method clicks Vhid button to continue authorization
     */
    @Step
    public void clickVhidToSignIn(){
        actionWithWebElements.clickOnElement(enter);
    }

    /**
     * Created by Elena Dovhaliuk
     * This methos waits till sms code is received
     */
    @Step
    public void waitUntilSmsCodeIsReceived(){
        Utils.waitABit(3);
        actionWithWebElements.clickOnElement(title);
    }

    /**
     * Created by Elena Dovhaliuk
     * This method enters received sms code into input
     * @param code
     */
    @Step
    public void enterSmsCodeIntoField(String code){
        actionWithWebElements.enterTextIntoInput(smsCodeInput, code);
    }

    /**
     * Created by Elena Dovhaliuk
     * This method clicks conformation button after sms code input is filled in
     */
    @Step
    public void clickSmsCodeInputConfirmation(){
        actionWithWebElements.clickOnElement(confirmSmsCodeInput);
    }

    /**
     * Created by Elena Dovhaliuk
     * This method clicks wrong login/ password pop up continue button
     */
    @Step
    public void clickContinueButton() {
        actionWithWebElements.clickOnElement(continueButton);
    }

    /**
     * Created by Elena Dovhaliuk
     * This method checks whether invalid login/ password pop up is visible
     * @return
     */
    @Step
    public boolean isLoginOrPasswordIsInvalidPopUpVisible(){
        return actionWithWebElements.isElementDisplayed(loginOrPasswordIsIncorrectPopUp);
    }
}
