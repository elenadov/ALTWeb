package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextBlock;

import java.util.Locale;

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
    private Button seconfDrawButton;

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

    @Step
    public void chooseEMLPurchaseMenu(){
        actionWithWebElements.clickOnElement(emlPurchaseMenu);
    }

    @Step
    public void chooseAutoLotoPurchaseMenu(){
        actionWithWebElements.clickOnElement(autoLotoPurchaseMenu);
    }

    @Step
    public void confirmPurchase(){
        actionWithWebElements.clickOnElement(confirmPurchase);
    }

    @Step
    private void selectFirstDrawFromTheList(){
        actionWithWebElements.clickOnElement(firstDrawButton);
    }

    @Step
    private void selectSecondDrawFromTheList(){
        actionWithWebElements.clickOnElement(seconfDrawButton);
    }

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

    @Step
    public String getFirstSerieCost(){
        return actionWithWebElements.getTextFromElementSum(firstSerieCost);
    }

    @Step
    public String getSecondSerieCost(){
        return actionWithWebElements.getTextFromElementSum(secondSerieCost);
    }

    @Step
    public int getSerieCost(int drawNumCount){
        String serieCost = "0.00";
        if (drawNumCount > 0 && drawNumCount < 3) {
            if (drawNumCount == 1) {
                serieCost = getFirstSerieCost();
            } else if (drawNumCount == 2) {
                serieCost = getSecondSerieCost();
            }
        }
        logger.info("You have chosen draw with the cost: " + serieCost);
        return Integer.valueOf(serieCost);
    }

    @Step
    public String betSumCount(int serieCount, int ticketCount){
        float betSum = serieCount * ticketCount;
        return String.format(Locale.ROOT,"%.2f", betSum);
    }

    @Step
    private void selectOneTicketToBuy(){
        actionWithWebElements.clickOnElement(oneTicketToBeBought);
    }

    @Step
    private void selectTwoTicketsToBuy(){
        actionWithWebElements.clickOnElement(twoTicketsToBeBought);
    }

    @Step
    private void selectThreeTicketsToBuy(){
        actionWithWebElements.clickOnElement(threeTicketsToBeBought);
    }

    @Step
    private void selectFourTicketsToBuy(){
        actionWithWebElements.clickOnElement(fourTicketsToBeBought);
    }

    @Step
    private void selectFiveTicketsToBuy(){
        actionWithWebElements.clickOnElement(fiveTicketsToBeBought);
    }

    @Step
    private void selectSixTicketsToBuy(){
        actionWithWebElements.clickOnElement(oneTicketToBeBought);
    }

    @Step
    private void selectSevenTicketsToBuy(){
        actionWithWebElements.clickOnElement(sevenTicketsToBeBought);
    }

    @Step
    private void selectEightTicketsToBuy(){
        actionWithWebElements.clickOnElement(eightTicketsToBeBought);
    }

    @Step
    private void selectNineTicketsToBuy(){
        actionWithWebElements.clickOnElement(nineTicketsToBeBought);
    }

    @Step
    private void selectTenTicketsToBuy(){
        actionWithWebElements.clickOnElement(tenTicketsToBeBought);
    }

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

    @Step
    public String getBetSum(){
        return actionWithWebElements.getTextFromElementSum(confirmPurchase);
    }
}
