package pages.lotteriesDrawing;

import io.qameta.allure.Step;
import libs.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.element.TextInput;

import java.text.ParseException;

public class DrawsLotteryInfoPage extends ParentPage {
    public DrawsLotteryInfoPage(WebDriver webDriver) {
        super(webDriver, "/draws.do");
    }

    @FindBy(name = "lotteryId")
    private Button lotteryTypesDropDown;

    @FindBy(xpath = "//td[5]//input[@name='action']")
    private Button searchButton;

    @FindBy(xpath = "//select[@name='statusSys']/option[contains(text(),'Регистрация ставок')]")
    private Button selectRegistrationBetStatusButton;

    @FindBy(xpath = "//select[@name='statusSys']/option[contains(text(),'Регистрация многотиражных ставок')]")
    private Button selectMultyRegistrationBetStatusButton;

    @FindBy(xpath = "//select[@name='statusSys']/option[contains(text(),'Создан')]")
    private Button selectCreatedStatusButton;

    @FindBy(xpath = "//p[contains(text(),'Регистрация ставок')]//..//..//td[6]")
    private Button registrationBetDrawSelection;

    @FindBy(xpath = "//tr[@class='list']/td[6]/p/a")
    private Button multyRegistrationBetDrawSelection;

    @FindBy(xpath = "//table[@class='form'][2]//td[6]")
    private Button continueWorkWithDraw;

    @FindBy(xpath = "//h1")
    private TextBlock drawDetailInformationHeader;

    @FindBy(name = "info.endGameDateString")
    private TextInput endRegistrationBetDate;

    @FindBy(name = "info.beginBetDateString")
    private TextInput startDrawingDrawDate;

    @FindBy(name = "info.endBetDateString")
    private TextInput endDrawingDrawDate;

    @FindBy(name = "info.beginWinsDateString")
    private TextInput startWinPayDate;

    @FindBy(name = "info.endWinsDateString")
    private TextInput endWinPayDate;

    @FindBy(xpath = "//*[@onclick='return jackpotValidator()']")
    private Button saveButton;

    @FindBy (xpath = "//table[5]//tr[2]//input")
    private Button closeButton;

    @FindBy (xpath = "//table[2]//tr[1]/td[2]")
    private TextBlock drawStatus;

    @FindBy (xpath = "//table[5]//tr[2]/td[1]/input")
    private Button indexCreationButton;

    @FindBy (xpath = "//table[5]//tr[2]/td[2]/input")
    private Button drawingDrawButton;

    @FindBy (xpath = "//*[@name='info.jackpot']")
    private TextInput jackpot;

    @FindBy (xpath = "//*[@name='info.megaprize']")
    private TextInput megaPrize;

    @FindBy (xpath = "//table[5]//td[3]/a")
    private Button enterResultsButton;

    @FindBy (xpath = "//*[@name='ball1']")
    private TextInput ball1;

    @FindBy (xpath = "//*[@name='ball2']")
    private TextInput ball2;

    @FindBy (xpath = "//*[@name='ball3']")
    private TextInput ball3;

    @FindBy (xpath = "//*[@name='ball4']")
    private TextInput ball4;

    @FindBy (xpath = "//*[@name='ball5']")
    private TextInput ball5;

    @FindBy (xpath = "//*[@name='ball6']")
    private TextInput ball6;

    @FindBy (xpath = "//*[@name='ball7']")
    private TextInput ball7;

    @FindBy (xpath = "//tr[11]//input")
    private Button saveResultsButton;

    @FindBy (xpath = "//font[@class='error']")
    private TextBlock resultsAreSavesSuccessfullyMessage;

    @FindBy (xpath = "//form//td[1]/a")
    private Button parametersMenuButton;

    @FindBy (xpath = "//table[5]//tr[2]/td[2]/input")
    private Button winTableCreationButton;

    @FindBy (xpath = "//table[5]//tr[2]//input")
    private Button winPayButton;

    @FindBy (xpath = "//table[5]//tr[1]/td[1]/input")
    private Button parametersExportButton;

    @FindBy (xpath = "//table[5]//tr[1]/td[2]/input")
    private Button resultsExportButton;

    @FindBy (xpath = "//table[5]//tr[2]//input")
    private Button notifyBRS;

    @FindBy (xpath = "//*[@id='alert']")
    private TextBlock successMessage;

    @Step
    private void selectMegalotValueFromLotteryTypesDropDown() {
        actionWithWebElements.selectVisibleTextInDropDown(lotteryTypesDropDown, "МЕГАЛОТ");
    }

    @Step
    private void clickSearchButton() {
        actionWithWebElements.clickOnElement(searchButton);
    }

    @Step
    private void selectRegistrationBetDrawStatusFilter() {
        actionWithWebElements.clickOnElement(selectRegistrationBetStatusButton);
    }

    @Step
    private String searchForDraw(String rowCount) {
        String drawStatus = "0";
        int rowCountDraws = Integer.valueOf(rowCount);
        if (rowCountDraws >= 1) {
            drawStatus = "1";
        }
        return String.valueOf(drawStatus);
    }

    @Step
    public String searchForDrawId(String drawInRegistration, String drawIdForRegisatration
            , String drawInMultyRegistration, String drawIdForMultyRegistration
            , String drawInCreatedStat, String drawIdForCreated){
        String drawId = "0";
        if (searchForDraw(drawInRegistration).equals("1")) {
            drawId = drawIdForRegisatration;
        } else if (searchForDraw(drawInMultyRegistration).equals("1")) {
            drawId = drawIdForMultyRegistration;
        } else if (searchForDraw(drawInCreatedStat).equals("1")) {
            drawId = drawIdForCreated;
        }
        return drawId;
    }

    @Step
    public String getScriptForChangingDrawStatusInRegistrationBet(String drawId){
        String script = configProperties.SCRIPT_FOR_CHANGING_DDRAW_STATUS_INTO_REGISTRATION_1()
                + drawId + configProperties.SCRIPT_FOR_CHANGING_DDRAW_STATUS_INTO_REGISTRATION_2();
        return script;
    }

    @Step
    private void changeDrawStatusIntoRegistration(String drawId, int change){
        logger.info("Draw # " + drawId + " is changed into registration. Status = " + change);
    }

    @Step
    private void selectDrawAndClickIt() {
        actionWithWebElements.clickOnElement(continueWorkWithDraw);
    }

    @Step
    private void waitUtilDrawDetailsAreVisible(){
        actionWithWebElements.waitForText(drawDetailInformationHeader, "Детальная информация о тираже");
    }

    @Step
    private void enterEndRegistrationEndDateForDrawing() throws ParseException {
        actionWithWebElements.enterTextIntoInput(endRegistrationBetDate, Utils.getDateAndTimeCurrectChangedMin(3));
    }

    @Step
    private void enterStartDrawingDrawDateForDrawing() throws ParseException {
        actionWithWebElements.enterTextIntoInput(startDrawingDrawDate, Utils.getDateAndTimeCurrentChangedMinSec(3, 2));
    }

    @Step
    private void enterEndDrawingDrawDateForDrawing() throws ParseException {
        actionWithWebElements.enterTextIntoInput(endDrawingDrawDate, Utils.getDateAndTimeCurrentChangedMinSec(3, 4));
    }

    @Step
    private void enterStartWinPayDateForDrawing() throws ParseException {
        actionWithWebElements.enterTextIntoInput(startWinPayDate, Utils.getDateAndTimeCurrentChangedMinSec(3, 6));
    }
//
//    @Step
//    private void enterEndRegistrationEndDateForCreationNewDraw() throws ParseException {
//        actionWithWebElements.enterTextIntoInput(endRegistrationBetDate, Utils.getDateAndTimeCurrentChangedHourMinSec(3));
//    }
//
//    @Step
//    private void enterStartDrawingDrawDateForCreationNewDraw() throws ParseException {
//        actionWithWebElements.enterTextIntoInput(startDrawingDrawDate, Utils.getDateAndTimeCurrentChangedMinSec(3, 2));
//    }
//
//    @Step
//    private void enterEndDrawingDrawDateForCreationNewDraw() throws ParseException {
//        actionWithWebElements.enterTextIntoInput(endDrawingDrawDate, Utils.getDateAndTimeCurrentChangedHourMinSec(3, 4));
//    }
//
//    @Step
//    private void enterStartWinPayDateForCreationNewDraw() throws ParseException {
//        actionWithWebElements.enterTextIntoInput(startWinPayDate, Utils.getDateAndTimeCurrentChangedMinSec(3, 6));
//    }
//
//    @Step
//    private void enterEndWinPayDateForCreationNewDraw() throws ParseException {
//        actionWithWebElements.enterTextIntoInput(startWinPayDate, Utils.getDateAndTimeCurrentChangedMinSec(3, 6));
//    }

    @Step
    private void clickSaveButton(){
        actionWithWebElements.clickOnElement(saveButton);
    }

    @Step
    private void clickCloseButton(){
        actionWithWebElements.clickOnElement(closeButton);
    }

    @Step
    private void waitUntilDrawStatusIsRegBetClosing(){
        actionWithWebElements.waitForTextLonger(drawStatus, "Закрытие регистрации ставок");
    }

    @Step
    private void clickIndexCreationButton(){
        actionWithWebElements.clickOnElement(indexCreationButton);
    }

    @Step
    private void waitUntilIndexIsCreated(){
        actionWithWebElements.waitForTextLonger(drawStatus, "Подготовка к розыгрышу");
    }

    @Step
    private void clickDrawingDrawButton(){
        actionWithWebElements.clickOnElement(drawingDrawButton);
    }

    @Step
    private void waitUntilDrawIsDrawn(){
        actionWithWebElements.waitForTextLonger(drawStatus, "Розыгрыш тиража");
    }

    @Step
    private void enterJackpotSum(String summa){
        actionWithWebElements.enterTextIntoInput(jackpot, summa);
    }

    @Step
    private void enterMegaPrizeSum(String summa){
        actionWithWebElements.enterTextIntoInput(jackpot, summa);
    }

    @Step
    private void enterResults(){
        actionWithWebElements.clickOnElement(enterResultsButton);
    }

    @Step
    private void enterFirstBallResult(String ballValue){
        actionWithWebElements.enterTextIntoInput(ball1, ballValue);
    }

    @Step
    private void enterSecondBallResult(String ballValue){
        actionWithWebElements.enterTextIntoInput(ball2, ballValue);
    }

    @Step
    private void enterThirdBallResult(String ballValue){
        actionWithWebElements.enterTextIntoInput(ball3, ballValue);
    }

    @Step
    private void enterFourthBallResult(String ballValue){
        actionWithWebElements.enterTextIntoInput(ball4, ballValue);
    }

    @Step
    private void enterFifthBallResult(String ballValue){
        actionWithWebElements.enterTextIntoInput(ball5, ballValue);
    }

    @Step
    private void enterSixthBallResult(String ballValue){
        actionWithWebElements.enterTextIntoInput(ball6, ballValue);
    }

    @Step
    private void enterAddBallResult(String ballValue){
        actionWithWebElements.enterTextIntoInput(ball7, ballValue);
    }

    @Step
    private void clickSaveResultsButton(){
        actionWithWebElements.clickOnElement(saveResultsButton);
    }

    @Step
    private void waitUntilResultsAreSaved(){
        actionWithWebElements.waitForText(resultsAreSavesSuccessfullyMessage
                ,"Ввод результатов тиража выполнен успешно.");
    }

    @Step
    private void clickParametersMenuButton(){
        actionWithWebElements.clickOnElement(parametersMenuButton);
    }

    @Step
    private void waitUtilDrawStatusIsPostDrawing(){
        actionWithWebElements.waitForText(drawStatus, "Послетиражная обработка");
    }

    @Step
    private void clickWinTableCreationButton(){
        actionWithWebElements.clickOnElement(winTableCreationButton);
    }

    @Step
    private void waitUtilWinPaymentButtonIsActive(){
        actionWithWebElements.waitForClickableElement(winPayButton);
    }

    @Step
    private void clickWinPayButton(){
        actionWithWebElements.clickOnElement(winPayButton);
    }

    @Step
    private void waitUntilDrawStatusIsWinPay(){
        actionWithWebElements.waitForText(drawStatus, "Выплата выигрышей");
    }

    @Step
    private void clickParametersExportButton(){
        actionWithWebElements.clickOnElement(parametersExportButton);
    }

    @Step
    private void clickResultsExportButton(){
        actionWithWebElements.clickOnElement(resultsExportButton);
    }

    @Step
    private void clickNotifyBRS(){
        actionWithWebElements.clickOnElement(notifyBRS);
    }

    @Step
    private void waitUtilMessageIsVisible(){
        actionWithWebElements.waitVisibilityOfElement(successMessage);
    }

    @Step
    private String createDrawInDB (String drawId){
        int drawIdForCreation = Integer.valueOf(drawId) + 1;
        String script = configProperties.SCRIPT_FOR_CREATION_DRAW_IN_CREATED_STATUS_1()
                + drawIdForCreation
                + configProperties.SCRIPT_FOR_CREATION_DRAW_IN_CREATED_STATUS_2()
                + drawIdForCreation
                + configProperties.SCRIPT_FOR_CREATION_DRAW_IN_CREATED_STATUS_3();
        return script;
    }

    @Step
    private void setDrawForBetRegistration
        (String jackpotSum, String megaPrizeSum) throws ParseException {
            selectMegalotValueFromLotteryTypesDropDown();
            selectRegistrationBetDrawStatusFilter();
            clickSearchButton();
            selectDrawAndClickIt();
            waitUtilDrawDetailsAreVisible();
            enterJackpotSum(jackpotSum);
            enterMegaPrizeSum(megaPrizeSum);
            enterEndRegistrationEndDateForDrawing();
            enterStartDrawingDrawDateForDrawing();
            enterEndDrawingDrawDateForDrawing();
            enterStartWinPayDateForDrawing();
            clickSaveButton();
            clickParametersExportButton();
    }

    @Step
    public void createNewDraw(String drawId, String jackpotSum, String megaPrizeSum) throws ParseException {
        createDrawInDB(drawId);
        setDrawForBetRegistration(jackpotSum, megaPrizeSum);
    }

    @Step
    private void drawingRegistrationBetDraw(String jackpotSum, String megaPrizeSum
            , String ball1, String ball2, String ball3
            , String ball4, String ball5, String ball6
            , String ball7) throws ParseException {
        selectMegalotValueFromLotteryTypesDropDown();
        selectRegistrationBetDrawStatusFilter();
        clickSearchButton();
        selectDrawAndClickIt();
        waitUtilDrawDetailsAreVisible();
        enterJackpotSum(jackpotSum);
        enterMegaPrizeSum(megaPrizeSum);
        enterEndRegistrationEndDateForDrawing();
        enterStartDrawingDrawDateForDrawing();
        enterEndDrawingDrawDateForDrawing();
        enterStartWinPayDateForDrawing();
        clickSaveButton();
        clickCloseButton();
        waitUntilDrawStatusIsRegBetClosing();
        clickIndexCreationButton();
        waitUntilIndexIsCreated();
        clickDrawingDrawButton();
        waitUntilDrawIsDrawn();
        enterResults();
        enterFirstBallResult(ball1);
        enterSecondBallResult(ball2);
        enterThirdBallResult(ball3);
        enterFourthBallResult(ball4);
        enterFifthBallResult(ball5);
        enterSixthBallResult(ball6);
        enterAddBallResult(ball7);
        clickSaveResultsButton();
        waitUntilResultsAreSaved();
        clickParametersMenuButton();
        waitUtilDrawStatusIsPostDrawing();
        clickWinTableCreationButton();
        waitUtilWinPaymentButtonIsActive();
        clickWinPayButton();
        waitUntilDrawStatusIsWinPay();
        clickParametersExportButton();
        waitUtilMessageIsVisible();
        clickResultsExportButton();
        waitUtilMessageIsVisible();
        clickNotifyBRS();
        waitUtilMessageIsVisible();
    }

    @Step
    public void determineDrawForDrawing(String drawInRegistration, String drawIdForRegisatration
            , String drawInMultyRegistration, String drawIdForMultyRegistration
            , String drawInCreatedStat, String drawIdForCreated
            , String jackpotSum, String megaPrizeSum
            , String ball1, String ball2, String ball3
            , String ball4, String ball5, String ball6
            , String ball7, int changeStatus) throws ParseException {
        if (searchForDraw(drawInRegistration).equals("1")) {
            logger.info("Draw # " + drawIdForRegisatration + " is selected for drawing");
            drawingRegistrationBetDraw(jackpotSum, megaPrizeSum
                    , ball1, ball2, ball3
                    , ball4, ball5, ball6
                    , ball7);
        } else if (searchForDraw(drawInMultyRegistration).equals("1")) {
            logger.info("Draw # " + drawIdForMultyRegistration + " is selected for drawing");
            changeDrawStatusIntoRegistration(drawIdForMultyRegistration, changeStatus);
            drawingRegistrationBetDraw(jackpotSum, megaPrizeSum
                    , ball1, ball2, ball3
                    , ball4, ball5, ball6
                    , ball7);
        } else if (searchForDraw(drawInCreatedStat).equals("1")) {
            logger.info("Draw # " + drawIdForCreated + " is selected for drawing");
            changeDrawStatusIntoRegistration(drawIdForCreated, changeStatus);
            drawingRegistrationBetDraw(jackpotSum, megaPrizeSum
                    , ball1, ball2, ball3
                    , ball4, ball5, ball6
                    , ball7);
        } else {
            logger.info("There is no draw. It is necessary to create new one");
            createDrawInDB(searchForDrawId(drawInRegistration
                    , drawIdForRegisatration, drawInMultyRegistration, drawIdForMultyRegistration
                    , drawInCreatedStat, drawIdForCreated));
            setDrawForBetRegistration(jackpotSum, megaPrizeSum);
        }
    }
}

