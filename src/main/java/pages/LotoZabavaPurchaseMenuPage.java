package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;
import ru.yandex.qatools.htmlelements.element.Button;

public class LotoZabavaPurchaseMenuPage extends ParentPage {

    public LotoZabavaPurchaseMenuPage(WebDriver webDriver) {
        super(webDriver, "/lotteries/zabava-lottery/init");}

    @FindBy(xpath = "//li[@class='game-list__item ng-tns-c122-2 ng-trigger ng-trigger-scaleAnimation ng-star-inserted' and @value='0']")
    private Button lotoZabavaPurchaseButton;

    @FindBy(xpath = "//button[@class='button dbc-draw button_theme_yellow ng-star-inserted']")
    private Button lotoZabavaFirstDrawInRegistrationButton;

    @FindBy(xpath = "//button[@class='button dbc-draw dbc-draw_gold ng-star-inserted']")
    private Button lotoZabavaSecondDrawInRegistrationButton;

//html/body/app-root/div[2]/section/ng-component/app-zabava-lottery-init/div/div/div[4]/div/div/app-buttons-group/div/div[2]/button[1]
    //app-zabava-lottery-init/div/div/div[4]/div/div/app-buttons-group/div/div[2]/button[1]
//app-buttons-group[@class='zc-bg-tickets']//button[@bg-index='1']
    //app-zabava-lottery-init//div[4]/div/div/app-buttons-group//button[1]
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

    @Step
    public void chooseLZFromTheListOfLotteries(){
        actionWithWebElements.clickOnElement(lotoZabavaPurchaseButton);
    }

    @Step
    public void chooseFirstLZDrawInRegistration(){
        actionWithWebElements.clickOnElement(lotoZabavaFirstDrawInRegistrationButton);
    }

    @Step
    public void chooseSecondLZDrawInRegistration(){
        actionWithWebElements.clickOnElement(lotoZabavaSecondDrawInRegistrationButton);
    }

    @Step
    public void chooseOneTicketToBuy(){
        actionWithWebElements.clickOnElement(oneLotoZabavaTicketToBuy);
    }

    @Step
    public void chooseTwoTicketToBuy(){
        actionWithWebElements.clickOnElement(twoLotoZabavaTicketToBuy);
    }

    @Step
    public void chooseThreeTicketToBuy(){
        actionWithWebElements.clickOnElement(threeLotoZabavaTicketToBuy);
    }

    @Step
    public void chooseFourTicketToBuy(){
        actionWithWebElements.clickOnElement(fourLotoZabavaTicketToBuy);
    }

    @Step
    public void chooseFiveTicketToBuy(){
        actionWithWebElements.clickOnElement(fiveLotoZabavaTicketToBuy);
    }

    @Step
    public void chooseSixTicketToBuy(){
        actionWithWebElements.clickOnElement(sixLotoZabavaTicketToBuy);
    }

    @Step
    public void chooseEightTicketToBuy(){
        actionWithWebElements.clickOnElement(eightLotoZabavaTicketToBuy);
    }

    @Step
    public void chooseSevenTicketToBuy(){
        actionWithWebElements.clickOnElement(sevenLotoZabavaTicketToBuy);
    }

    @Step
    public void chooseNineTicketToBuy(){
        actionWithWebElements.clickOnElement(nineLotoZabavaTicketToBuy);
    }

    @Step
    public void chooseTenTicketToBuy(){
        actionWithWebElements.clickOnElement(tenLotoZabavaTicketToBuy);
    }

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

    @Step
    public void chooseOneParochkaCombination(){
        actionWithWebElements.clickOnElement(oneParochkaCount);
    }

    @Step
    public void chooseTwoParochkaCombinations(){
        actionWithWebElements.clickOnElement(twoParochkaCount);
    }

    @Step
    public void chooseThreeParochkaCombinations(){
        actionWithWebElements.clickOnElement(threeParochkaCount);
    }

    @Step
    public void chooseFourParochkaCombinations(){
        actionWithWebElements.clickOnElement(fourParochkaCount);
    }

    @Step
    public void chooseFiveParochkaCombinations(){
        actionWithWebElements.clickOnElement(fiveParochkaCount);
    }

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

    @Step
    public void chooseBahatyTaVidomyContest(){
        actionWithWebElements.clickOnElement(bahatyTaVidomyContest);
    }

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

    @Step
    public void clickBuyLZButton(){
        actionWithWebElements.clickOnElement(buyLotoZabavaButton);
    }

    @Step
    public String getLZCheckSum(){
        return actionWithWebElements.getTextFromElement(buyLotoZabavaButton);
    }

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
        int betSum = mainTicketSum + parochkaSum + (richAndPopular * ticketCount);
        return String.valueOf(betSum);
    }
}
