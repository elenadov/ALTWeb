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

public class LotoZabavaPurchaseMenuPage extends ParentPage {

    public LotoZabavaPurchaseMenuPage(WebDriver webDriver) {
        super(webDriver, "/lotteries/zabava-lottery/init");}

    @FindBy(xpath = "//li[@class='game-list__item ng-tns-c122-2 ng-trigger ng-trigger-scaleAnimation ng-star-inserted' and @value='0']")
    private Button lotoZabavaPurchaseButton;

    @FindBy(xpath = "//button[@class='button dbc-draw button_theme_yellow ng-star-inserted']")
    private Button lotoZabavaFirstDrawInRegistrationButton;

    @FindBy(xpath = "//button[@class='button dbc-draw dbc-draw_gold ng-star-inserted']")
    private Button lotoZabavaSecondDrawInRegistrationButton;

    @FindBy(xpath = "//app-buttons-group[@class='zc-bg-tickets']//button[@bg-index='0']")
    private Button oneLotoZabavaTicketToBuy;

    @FindBy(xpath = "//app-buttons-group[@class='zc-bg-tickets']//button[@bg-index='1']")
    private Button twoLotoZabavaTicketToBuy;

    @FindBy(xpath = "//app-buttons-group[@class='zc-bg-tickets']//button[@bg-index='2']")
    private Button threeLotoZabavaTicketToBuy;

    @FindBy(xpath = "//app-buttons-group[@class='zc-bg-tickets']//button[@bg-index='3']")
    private Button fourLotoZabavaTicketToBuy;

    @FindBy(xpath = "//app-buttons-group[@class='zc-bg-tickets']//button[@bg-index='4']")
    private Button fiveLotoZabavaTicketToBuy;

    @FindBy(xpath = "//app-buttons-group[@class='zc-bg-tickets']//button[@bg-index='5']")
    private Button sixLotoZabavaTicketToBuy;

    @FindBy(xpath = "//app-buttons-group[@class='zc-bg-tickets']//button[@bg-index='6']")
    private Button sevenLotoZabavaTicketToBuy;

    @FindBy(xpath = "//app-buttons-group[@class='zc-bg-tickets']//button[@bg-index='7']")
    private Button eightLotoZabavaTicketToBuy;

    @FindBy(xpath = "//app-buttons-group[@class='zc-bg-tickets']//button[@bg-index='8']")
    private Button nineLotoZabavaTicketToBuy;

    @FindBy(xpath = "//app-buttons-group[@class='zc-bg-tickets']//button[@bg-index='9']")
    private Button tenLotoZabavaTicketToBuy;

    @FindBy(xpath = "//app-buttons-group[@class='zc-bg-pairs']//button[@bg-index='0']")
    private Button oneParochkaCount;

    @FindBy(xpath = "//app-buttons-group[@class='zc-bg-pairs']//button[@bg-index='1']")
    private Button twoParochkaCount;

    @FindBy(xpath = "//app-buttons-group[@class='zc-bg-pairs']//button[@bg-index='2']")
    private Button threeParochkaCount;

    @FindBy(xpath = "//app-buttons-group[@class='zc-bg-pairs']//button[@bg-index='3']")
    private Button fourParochkaCount;

    @FindBy(xpath = "//app-buttons-group[@class='zc-bg-pairs']//button[@bg-index='4']")
    private Button fiveParochkaCount;

    @FindBy(xpath = "//button[@class='buttons-group__item buttons-group__item_first buttons-group__item_last buttons-group__item_theme_square-radial ng-star-inserted']")
    private Button bahatyTaVidomyContest;

    @FindBy(xpath = "//button[@class='button']")
    private Button buyLotoZabavaButton;

    @FindBy(xpath = "//button[1]//div[@class='dbc-number']")
    private TextBlock firstLZDraw;

    @FindBy(xpath = "//button[2]//div[@class='dbc-number']")
    private TextBlock secondLZDraw;

    @FindBy(xpath = "//app-check-information//div[10]")
    private TextBlock betSum;

    /**
     * Created by Elena Dovhaliuk
     * Such method clicks Loto Zabava purchase button form the main menu
     */
    @Step
    public void chooseLZFromTheListOfLotteries(){
        actionWithWebElements.clickOnElement(lotoZabavaPurchaseButton);
    }

    /**
     * Created by Elena Dovhaliuk
     * Such private method chooses first draw in the list
     */
    @Step
    private void chooseFirstLZDrawInRegistration(){
        actionWithWebElements.clickOnElement(lotoZabavaFirstDrawInRegistrationButton);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method chooses second draw in the list
     */
    @Step
    private void chooseSecondLZDrawInRegistration(){
        actionWithWebElements.clickOnElement(lotoZabavaSecondDrawInRegistrationButton);
    }

    /**
     * Created by Elena Dovhaliuk
     * Such method returns first draw number
     * @return
     */
    @Step
    private String getFirstDrawNum(){
        return actionWithWebElements.getTextFromElementNumInt(firstLZDraw);
    }

    /**
     * Created by Elena Dovhaliuk
     * Such method returns second draw number
     * @return
     */
    @Step
    private String getSecondDrawNum(){
        return actionWithWebElements.getTextFromElementNumInt(secondLZDraw);
    }

    /**
     * Created by Elena Dovhaliuk
     * This method chooses draw from the list and prints selected draw number
     * @param draw
     */
    @Step
    public void chooseDrawFromList(int draw){
        String drawNum = "0";
        if (draw >0 && draw <3) {
            if (draw == 1) {
                chooseFirstLZDrawInRegistration();
                drawNum = getFirstDrawNum();
            } else if (draw == 2) {
                chooseSecondLZDrawInRegistration();
                drawNum = getSecondDrawNum();
            }
            logger.info("You have chosen " + drawNum + " draw");
        } else {
            logger.error("You have not chosen any draw");
        }
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method selects one ticket for purchase
     */
    @Step
    private void chooseOneTicketToBuy(){
        actionWithWebElements.clickOnElement(oneLotoZabavaTicketToBuy);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method selects two tickets for purchase
     */
    @Step
    private void chooseTwoTicketToBuy(){
        actionWithWebElements.clickOnElement(twoLotoZabavaTicketToBuy);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method selects three tickets for purchase
     */
    @Step
    private void chooseThreeTicketToBuy(){
        actionWithWebElements.clickOnElement(threeLotoZabavaTicketToBuy);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method selects four tickets for purchase
     */
    @Step
    private void chooseFourTicketToBuy(){
        actionWithWebElements.clickOnElement(fourLotoZabavaTicketToBuy);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method selects five tickets for purchase
     */
    @Step
    private void chooseFiveTicketToBuy(){
        actionWithWebElements.clickOnElement(fiveLotoZabavaTicketToBuy);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method selects six tickets for purchase
     */
    @Step
    private void chooseSixTicketToBuy(){
        actionWithWebElements.clickOnElement(sixLotoZabavaTicketToBuy);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method selects seven tickets for purchase
     */
    @Step
    private void chooseEightTicketToBuy(){
        actionWithWebElements.clickOnElement(eightLotoZabavaTicketToBuy);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method selects eight tickets for purchase
     */
    @Step
    private void chooseSevenTicketToBuy(){
        actionWithWebElements.clickOnElement(sevenLotoZabavaTicketToBuy);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method selects nine tickets for purchase
     */
    @Step
    private void chooseNineTicketToBuy(){
        actionWithWebElements.clickOnElement(nineLotoZabavaTicketToBuy);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method selects ten tickets for purchase
     */
    @Step
    private void chooseTenTicketToBuy(){
        actionWithWebElements.clickOnElement(tenLotoZabavaTicketToBuy);
    }

    /**
     * Created by Elena Dovhaliuk
     * This method selects ticket/s for purchase
     * @param ticketCount
     */
    @Step
    public void chooseLZTicketCount(int ticketCount){
        if(ticketCount >0 && ticketCount <11){
            if(ticketCount == 1){
                chooseOneTicketToBuy();
            }
            else if(ticketCount == 2){
                chooseTwoTicketToBuy();
            }
            else if(ticketCount == 3){
                chooseThreeTicketToBuy();
            }
            else if(ticketCount == 4){
                chooseFourTicketToBuy();
            }
            else if(ticketCount == 5){
                chooseFiveTicketToBuy();
            }
            else if(ticketCount == 6){
                chooseSixTicketToBuy();
            }
            else if(ticketCount == 7){
                chooseSevenTicketToBuy();
            }
            else if(ticketCount == 8){
                chooseEightTicketToBuy();
            }
            else if(ticketCount == 9){
                chooseNineTicketToBuy();
            }
            else if(ticketCount == 10) {
                chooseTenTicketToBuy();
            }
            logger.info("You have chosen " + ticketCount + " ticket/s");
        }
        else {
        logger.error("You have not chosen any ticket");
        }
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method selects one parochka combination for purchase
     */
    @Step
    public void chooseOneParochkaCombination(){
        actionWithWebElements.clickOnElement(oneParochkaCount);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method selects two parochka combinations for purchase
     */
    @Step
    public void chooseTwoParochkaCombinations(){
        actionWithWebElements.clickOnElement(twoParochkaCount);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method selects three parochka combinations for purchase
     */
    @Step
    public void chooseThreeParochkaCombinations(){
        actionWithWebElements.clickOnElement(threeParochkaCount);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method selects four parochka combinations for purchase
     */
    @Step
    public void chooseFourParochkaCombinations(){
        actionWithWebElements.clickOnElement(fourParochkaCount);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method selects five parochka combinations for purchase
     */
    @Step
    public void chooseFiveParochkaCombinations(){
        actionWithWebElements.clickOnElement(fiveParochkaCount);
    }

    /**
     * Created by Elena Dovhaliuk
     * This method selects parochka combination/s for purchase
     * @param parochkaCount
     */
    @Step
    public void chooseParochkaCount(int parochkaCount) {
        if (parochkaCount >0 && parochkaCount <6) {
            if (parochkaCount == 1) {
                chooseOneParochkaCombination();
            } else if (parochkaCount == 2) {
                chooseTwoParochkaCombinations();
            } else if (parochkaCount == 3) {
                chooseThreeParochkaCombinations();
            } else if (parochkaCount == 4) {
                chooseFourParochkaCombinations();
            } else if (parochkaCount == 5) {
                chooseFiveParochkaCombinations();
            }
            logger.info("You have chosen " + parochkaCount + " parochka combination/s");
        } else {
            logger.error("You have not chosen any parochka combination");
        }
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method selects rich and famous combination for purchase
     */
    @Step
    public void chooseBahatyTaVidomyContest(){
        actionWithWebElements.clickOnElement(bahatyTaVidomyContest);
    }

    /**
     * Created by Elena Dovhaliuk
     * This method selects rich and famous combination for purchase
     * @param state
     */
    @Step
    public void selectRichAndFamousContest(String state){
        boolean isStateCheck = state.toLowerCase().equals("check");
        boolean isStateUncheck = state.toLowerCase().equals("uncheck");
        if (isStateCheck || isStateUncheck) {
            if (isStateCheck) {
                chooseBahatyTaVidomyContest();
                logger.info("Rich and Famous Contest is selected");
            } else if (isStateUncheck) {
                logger.info("Rich and Famous Contest isn't selected");
            }
        }
    }

    /**
     * Created by Elena Dovhaliuk
     * This method clicks continue button to purchase Loto Zabava
     */
    @Step
    public void clickBuyLZButton(){
        actionWithWebElements.clickOnElement(buyLotoZabavaButton);
    }

    /**
     * Created by Elena Dovhaliuk
     * This method returns formed sum of Loto Zabava check (from the purchase menu) to be compared with
     * @return
     */
    @Step
    public String getLZCheckSum(){
        return actionWithWebElements.getTextFromElementSum(buyLotoZabavaButton);
    }

    /**
     * Created by Elena Dovhaliuk
     * Such method calculates and returns correct sum of Loto Zabava check to be compared with
     * @param ticketCount
     * @param parochkaCount
     * @param bTV
     * @return
     */
    @Step
    public String calculateLZBetSum(int ticketCount, int parochkaCount, String bTV){
        int richAndPopular = 0;
        boolean isStateCheck = bTV.toLowerCase().equals("check");
        boolean isStateUncheck = bTV.toLowerCase().equals("uncheck");
            if (isStateCheck) {
                richAndPopular = 2;
            }
            else if (isStateUncheck) {
                richAndPopular = 0;
            }
        int mainTicketSum = ticketCount * 20;
        int parochkaSum = ticketCount * parochkaCount * 5;
        float betSum = mainTicketSum + parochkaSum + (richAndPopular * ticketCount);
        return String.format(Locale.ROOT,"%.2f", betSum);
    }

    /**
     * Created by Elena Dovhaliuk
     * This method returns formed sum of Loto Zabava check (from the registration check menu) to be compared with
     * @return
     */
    @Step
    public String getLZBetSum(){
        return actionWithWebElements.getTextFromElementSum(betSum);
    }
}
