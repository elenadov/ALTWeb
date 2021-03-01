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

public class EMLPurchaseMenuPage extends ParentPage {

    public EMLPurchaseMenuPage(WebDriver webDriver) {
        super(webDriver, "/lotteries/instant-lotteries/init/1");
    }

    @FindBy(xpath = "//app-lotteries//li[3]")
    private Button emlPurchaseMenu;

    @FindBy(xpath = "//div[@id='game_index_0']")
    private Button autoLotoPurchaseMenu;

    @FindBy (xpath = "//button[@class='button']")
    private Button confirmPurchase;

    @FindBy(xpath = "//li[@value='0']//div[@class='draws-item__serie_sum']")
    private TextBlock firstSerieCost;

    @FindBy(xpath = "//li[@value='1']//div[@class='draws-item__serie_sum']")
    private TextBlock secondSerieCost;

    @FindBy(xpath = "//ul[@class='draws-items']/li[1]")
    private Button firstDrawButton;

    @FindBy(xpath = "//ul[@class='draws-items']/li[2]")
    private Button secondDrawButton;

    @FindBy(xpath = "//div[2]/button[@bg-index='0']")
    private Button oneTicketToBeBought;

    @FindBy(xpath = "//div[2]/button[@bg-index='1']")
    private Button twoTicketsToBeBought;

    @FindBy(xpath = "//div[2]/button[@bg-index='2']")
    private Button threeTicketsToBeBought;

    @FindBy(xpath = "//div[2]/button[@bg-index='3']")
    private Button fourTicketsToBeBought;

    @FindBy(xpath = "//div[2]/button[@bg-index='4']")
    private Button fiveTicketsToBeBought;

    @FindBy(xpath = "//div[2]/button[@bg-index='5']")
    private Button sixTicketsToBeBought;

    @FindBy(xpath = "//div[2]/button[@bg-index='6']")
    private Button sevenTicketsToBeBought;

    @FindBy(xpath = "//div[2]/button[@bg-index='7']")
    private Button eightTicketsToBeBought;

    @FindBy(xpath = "//div[2]/button[@bg-index='8']")
    private Button nineTicketsToBeBought;

    @FindBy(xpath = "//div[2]/button[@bg-index='9']")
    private Button tenTicketsToBeBought;

    /**
     * Created by Elena Dovhaliuk
     * Such method clicks EML purchase menu from the list of lotteries
     */
    @Step
    public void chooseEMLPurchaseMenu(){
        actionWithWebElements.clickOnElement(emlPurchaseMenu);
    }

    /**
     * Created by Elena Dovhaliuk
     * Such method clicks Auto Loto purchase menu from the list of EML games
     */
    @Step
    public void chooseAutoLotoPurchaseMenu(){
        actionWithWebElements.clickOnElement(autoLotoPurchaseMenu);
    }

    /**
     * Created by Elena Dovhaliuk
     * This method clicks confirmation button after all selections are done
     */
    @Step
    public void confirmPurchase(){
        actionWithWebElements.clickOnElement(confirmPurchase);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method selects first draw of lottery to make a bet on
     */
    @Step
    private void selectFirstDrawFromTheList(){
        actionWithWebElements.clickOnElement(firstDrawButton);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method selects second draw of lottery to make a bet on
     */
    @Step
    private void selectSecondDrawFromTheList(){
        actionWithWebElements.clickOnElement(secondDrawButton);
    }

    /**
     * Created by Elena Dovhaliuk
     * This method chooses necessary draw from the list to make a bet on
     * @param drawNum
     */
    @Step
    public void chooseDrawFromTheList(int drawNum) {
        if (drawNum > 0 && drawNum < 3) {
            if (drawNum == 1) {
                selectFirstDrawFromTheList();
                logger.info("You have chosen the first draw");
            } else if (drawNum == 2) {
                selectSecondDrawFromTheList();
                logger.info("You have chosen the second draw");
            }
        }
    }

    /**
     * Created by Elena Dovhaliuk
     * Such private method gets first selected series cost
     * @return
     */
    @Step
    public String getFirstSeriesCost(){
        return actionWithWebElements.getTextFromElementSum(firstSerieCost);
    }

    /**
     * Created by Elena Dovhaliuk
     * Such private method gets second selected series cost
     * @return
     */
    @Step
    public String getSecondSeriesCost(){
        return actionWithWebElements.getTextFromElementSum(secondSerieCost);
    }

    /**
     * Created by Elena Dovhaliuk
     * Such metod gets selected lottery series cost
     * @param drawNumCount
     * @return
     */
    @Step
    public int getSeriesCost(int drawNumCount){
        String seriesCost = "0.00";
        if (drawNumCount > 0 && drawNumCount < 3) {
            if (drawNumCount == 1) {
                seriesCost = getFirstSeriesCost();
            } else if (drawNumCount == 2) {
                seriesCost = getSecondSeriesCost();
            }
        }
        logger.info("You have chosen draw with the cost: " + seriesCost);
        return Integer.valueOf(seriesCost);
    }

    /**
     * Created by Elena Dovhaliuk
     * This method counts sum of the bet
     * @param seriesCount
     * @param ticketCount
     * @return
     */
    @Step
    public String betSumCount(int seriesCount, int ticketCount){
        float betSum = seriesCount * ticketCount;
        return String.format(Locale.ROOT,"%.2f", betSum);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method clicks one ticket selector for purchase
     */
    @Step
    private void selectOneTicketToBuy(){
        actionWithWebElements.clickOnElement(oneTicketToBeBought);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method clicks two tickets selector for purchase
     */
    @Step
    private void selectTwoTicketsToBuy(){
        actionWithWebElements.clickOnElement(twoTicketsToBeBought);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method clicks three tickets selector for purchase
     */
    @Step
    private void selectThreeTicketsToBuy(){
        actionWithWebElements.clickOnElement(threeTicketsToBeBought);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method clicks four tickets selector for purchase
     */
    @Step
    private void selectFourTicketsToBuy(){
        actionWithWebElements.clickOnElement(fourTicketsToBeBought);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method clicks five tickets selector for purchase
     */
    @Step
    private void selectFiveTicketsToBuy(){
        actionWithWebElements.clickOnElement(fiveTicketsToBeBought);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method clicks six tickets selector for purchase
     */
    @Step
    private void selectSixTicketsToBuy(){
        actionWithWebElements.clickOnElement(sixTicketsToBeBought);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method clicks seven tickets selector for purchase
     */
    @Step
    private void selectSevenTicketsToBuy(){
        actionWithWebElements.clickOnElement(sevenTicketsToBeBought);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method clicks eight tickets selector for purchase
     */
    @Step
    private void selectEightTicketsToBuy(){
        actionWithWebElements.clickOnElement(eightTicketsToBeBought);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method clicks nine tickets selector for purchase
     */
    @Step
    private void selectNineTicketsToBuy(){
        actionWithWebElements.clickOnElement(nineTicketsToBeBought);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method clicks ten tickets selector for purchase
     */
    @Step
    private void selectTenTicketsToBuy(){
        actionWithWebElements.clickOnElement(tenTicketsToBeBought);
    }

    /**
     * Created by Elena Dovhaliuk
     * This method clicks selected ticket count to be bought
     * @param ticketCount
     */
    @Step
    public void chooseEMLTicketCount(int ticketCount){
        if(ticketCount >0 && ticketCount <11){
            if(ticketCount == 1){
                selectOneTicketToBuy();
            }
            else if(ticketCount == 2){
                selectTwoTicketsToBuy();
            }
            else if(ticketCount == 3){
                selectThreeTicketsToBuy();
            }
            else if(ticketCount == 4){
                selectFourTicketsToBuy();
            }
            else if(ticketCount == 5){
                selectFiveTicketsToBuy();
            }
            else if(ticketCount == 6){
                selectSixTicketsToBuy();
            }
            else if(ticketCount == 7){
                selectSevenTicketsToBuy();
            }
            else if(ticketCount == 8){
                selectEightTicketsToBuy();
            }
            else if(ticketCount == 9){
                selectNineTicketsToBuy();
            }
            else if(ticketCount == 10) {
                selectTenTicketsToBuy();
            }
            logger.info("You have chosen " + ticketCount + " ticket/s");
        }
        else {
            logger.error("You have not chosen any ticket");
        }
    }

    /**
     * Created by Elena Dovhaliuk
     * This method gets sum of the bet to be compared with
     * @return
     */
    @Step
    public String getBetSum(){
        return actionWithWebElements.getTextFromElementSum(confirmPurchase);
    }
}
