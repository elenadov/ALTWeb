package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextBlock;

import java.util.ArrayList;

/**
 * Created by Elena Dovhaliuk
 */

public class LotteriesPage extends ParentPage {

    public LotteriesPage(WebDriver webDriver) {
        super(webDriver, "/lotteries");
    }

    public ArrayList<String> sumOfBoughtTickets;
    //div[@class='change-log-container change-log-container_only-latest']
    @FindBy(xpath = "//app-change-log/div")
    private TextBlock newOSAnnouncment;
    //button[@class='button button_theme_green modal-button modal-button_close-changelog ng-star-inserted']
    @FindBy(xpath = "//app-change-log/div/button")
    private Button continueNewOSButton;
    //div[@class='modal-dialog-background is-visible']
    @FindBy(xpath = "//app-lotteries/app-one-button-custom/div/div")
    private TextBlock jackpot;
    //app-lotteries//button[@class='button modal-button button_theme_green']
    @FindBy(xpath = "//app-lotteries/app-one-button-custom//button")
    private Button continueJackpotButton;
    //app-root/div[2]/section/app-lotteries/app-game-list/div
    @FindBy(xpath = "//app-game-list/div")
    private TextBlock lotteriesList;

    @FindBy(xpath = "//app-one-button-error//div[@class='modal-dialog-container']")
    private TextBlock registrationIsSuccessfulPopUp;

    @FindBy(xpath = "//button[@class='button button_theme_green modal-button']")
    private Button continueWorkAfterRegistrationSuccess;

    @FindBy(xpath = "//div[@class='tc-amount']/span")
    private TextBlock totalBetsSum;

    @FindBy(xpath = "//ul[@class='central-menu']/li[2]")
    private Button winPaymentMenuButton;

    @FindBy(xpath = "//ul[@class='central-menu']/li[1]")
    private Button lotteryRegistrationMenuButton;

    /**
     * Created by Elena Dovhaliuk
     * This method checks if announcement of the new OS version is displayed
     * @return
     */
    @Step
    public boolean isNewOSAnnouncementDisplayed() {
        return actionWithWebElements.isElementDisplayed(newOSAnnouncment);
    }

    /**
     * Created by Elena Dovhaliuk
     * This method checks if announcement of current jackpots is displayed
     * @return
     */
    @Step
    public boolean isJackpotAnnouncementDisplayed() {
        return actionWithWebElements.isElementDisplayed(jackpot);
    }

    /**
     * Created by Elena Dovhaliuk
     * This method checks whether main menu with lottery list is displayed
     * @return
     */
    @Step
    public boolean isLotteriesListDisplayed() {
        return actionWithWebElements.isElementDisplayed(lotteriesList);
    }

    /**
     * Created by Elena Dovhaliuk
     * This method checks if successful registration pop up is visible
     * @return
     */
    @Step
    public boolean isRegistrationSuccesfulPopUpVisible() {
        return actionWithWebElements.isElementDisplayed(registrationIsSuccessfulPopUp);
    }

    /**
     * Created by Elena Dovhaliuk
     * Such method clicks continue button of new OS pop up
     */
    @Step
    public void clickContinueNewOSButton() {
        actionWithWebElements.clickOnElement(continueNewOSButton);
    }

    /**
     * Created by Elena Dovhaliuk
     * This method clicks continue button on jackpot pop up
     */
    @Step
    public void clickContinueJackpotButton() {
        actionWithWebElements.clickOnElement(continueJackpotButton);
    }

    /**
     * Created by Elena Dovhaliuk
     * Such method clicks continue button after registration is successful
     */
    @Step
    public void clickContinueWorkAfterRegistrationSuccess() {
        actionWithWebElements.clickOnElement(continueWorkAfterRegistrationSuccess);
    }

    /**
     * Created by Elena Dovhaliuk
     * Such method returns sum of check (from the main menu) to be compared with
     * @return
     */
    @Step
    public String getTotalBetsSum(){
        return actionWithWebElements.getTextFromElementSum(totalBetsSum);
    }

    /**
     * Created by Elena Dovhaliuk
     * This method selects win payment menu
     */
    @Step
    public void clickWinPaymentMenuButton(){
        actionWithWebElements.clickOnElement(winPaymentMenuButton);
    }

    /**
     * Created by Elena Dovhaliuk
     * This method selects main (registration) menu
     */
    @Step
    public void clickLotteryRegistrationMenuButton(){
        actionWithWebElements.clickOnElement(lotteryRegistrationMenuButton);
    }
}