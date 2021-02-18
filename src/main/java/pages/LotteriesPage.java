package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextBlock;

import java.util.ArrayList;

public class LotteriesPage extends ParentPage {

    public LotteriesPage(WebDriver webDriver) {
        super(webDriver, "/lotteries");
    }

    public ArrayList<String> sumOfBoughtTickets;

    @FindBy(xpath = "//div[@class='change-log-container change-log-container_only-latest']")
    private TextBlock newOSAnnouncment;

    @FindBy(xpath = "//button[@class='button button_theme_green modal-button modal-button_close-changelog ng-star-inserted']")
    private Button continueNewOSButton;

    @FindBy(xpath = "//div[@class='modal-dialog-background is-visible']")
    private TextBlock jackpot;

    @FindBy(xpath = "//app-lotteries//button[@class='button modal-button button_theme_green']")
    private Button continueJackpotButton;

    @FindBy(xpath = "/html/body/app-root/div[2]/section/app-lotteries/app-game-list/div")
    private TextBlock lotteriesList;

    @FindBy(xpath = "//app-one-button-error//div[@class='modal-dialog-container']")
    private TextBlock registrationIsSuccessfulPopUp;

    @FindBy(xpath = "//button[@class='button button_theme_green modal-button']")
    private Button continueWorkAfterRegistrationSuccess;

    @FindBy(xpath = "/html/body/app-root/div[2]/section/app-lotteries/app-total-check-info-panel/div/div[2]/div/span")
    private TextBlock allTransactionsSum;

    @FindBy(xpath = "//div[@class='tcc-list__cell tcc-list__cell_col_amount align-positive tcc-list__cell_action_register']")
    private TextBlock firstTransactionSum;

    @FindBy(xpath = "//div[@class='tc-amount']/span")
    private TextBlock totalBetsSum;

    @Step
    public boolean isNewOSAnnouncementDisplayed() {
        return actionWithWebElements.isElementDisplayed(newOSAnnouncment);
    }

    @Step
    public boolean isJackpotAnnouncementDisplayed() {
        return actionWithWebElements.isElementDisplayed(jackpot);
    }

    @Step
    public boolean isLotteriesListDisplayed() {
        return actionWithWebElements.isElementDisplayed(lotteriesList);
    }

    @Step
    public boolean isRegistrationSuccesfulPopUpVisible() {
        return actionWithWebElements.isElementDisplayed(registrationIsSuccessfulPopUp);
    }

    @Step
    public void clickContinueNewOSButton() {
        actionWithWebElements.clickOnElement(continueNewOSButton);
    }

    @Step
    public void clickContinueJackpotButton() {
        actionWithWebElements.clickOnElement(continueJackpotButton);
    }

    @Step
    public void clickContinueWorkAfterRegistrationSuccess() {
        actionWithWebElements.clickOnElement(continueWorkAfterRegistrationSuccess);
    }

    @Step
    public String autoLotoCheckSum(int ticketCount) {
        int autoLotoTicketSum = 100;
        int sum = ticketCount * autoLotoTicketSum;
        return String.valueOf(sum);
    }

    @Step
    public String getTotalBetsSum(){
        return actionWithWebElements.getTextFromElementSum(totalBetsSum);
    }
}