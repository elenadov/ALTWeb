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

/**
 * Created by Elena Dovhaliuk
 */

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

    @FindBy(xpath = "//p[contains(text(),'Регистрация ставок')]//..//..//td[6]")
    private Button registrationBetDrawSelection;

    @FindBy(xpath = "//tr[@class='list']/td[6]/p/a")
    private Button multyRegistrationBetDrawSelection;

    @FindBy(xpath = "//table[@class='form'][2]//td[6]")
    private Button continueWorkWithDraw;

    @FindBy(xpath = "//table[2]//tr[2]/td[2]")
    private TextBlock drawType;

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

    /**
     * Created by Elena Dovhaliuk
     * This private method selects Megalot from Lottery Type drop down
     */
    @Step
    private void selectMegalotValueFromLotteryTypesDropDown() {
        actionWithWebElements.selectVisibleTextInDropDown(lotteryTypesDropDown, "МЕГАЛОТ");
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method clicks search button
     */
    @Step
    private void clickSearchButton() {
        actionWithWebElements.clickOnElement(searchButton);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method filters draw of registration bet status
     */
    @Step
    private void selectRegistrationBetDrawStatusFilter() {
        actionWithWebElements.clickOnElement(selectRegistrationBetStatusButton);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method returns count of draw in specific input status
     * @param rowCount
     * @return
     */
    @Step
    private String searchForDraw(String rowCount) {
        String drawStatus = "0";
        int rowCountDraws = Integer.valueOf(rowCount);
        if (rowCountDraws >= 1) {
            drawStatus = "1";
        }
        return String.valueOf(drawStatus);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method clicks continue button of chosen draw
     */
    @Step
    private void selectDrawAndClickIt() {
        actionWithWebElements.clickOnElement(continueWorkWithDraw);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method waits until draw details are visible
     */
    @Step
    private void waitUtilDrawTypeIsVisible(){
        actionWithWebElements.waitForText(drawType, "Обычный");
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method enters date into end registration input for the drawing draw
     * @throws ParseException
     */
    @Step
    private void enterEndRegistrationEndDateForDrawing() throws ParseException {
        actionWithWebElements.enterTextIntoInput(endRegistrationBetDate, Utils.getDateAndTimeCurrectChangedMin(3));
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method enters date into start drawing input for the drawing draw
     * @throws ParseException
     */
    @Step
    private void enterStartDrawingDrawDateForDrawing() throws ParseException {
        actionWithWebElements.enterTextIntoInput(startDrawingDrawDate, Utils.getDateAndTimeCurrentChangedMinSec(3, 2));
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method enters date into end drawing input for the drawing draw
     * @throws ParseException
     */
    @Step
    private void enterEndDrawingDrawDateForDrawing() throws ParseException {
        actionWithWebElements.enterTextIntoInput(endDrawingDrawDate, Utils.getDateAndTimeCurrentChangedMinSec(3, 4));
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method enters date into stat win pay input for the drawing draw
     * @throws ParseException
     */
    @Step
    private void enterStartWinPayDateForDrawing() throws ParseException {
        actionWithWebElements.enterTextIntoInput(startWinPayDate, Utils.getDateAndTimeCurrentChangedMinSec(3, 6));
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method enters date into end registration input for the newly created draw
     * @throws ParseException
     */
    @Step
    private void enterEndRegistrationEndDateForNewDraw() throws ParseException {
        actionWithWebElements.enterTextIntoInput(endRegistrationBetDate
                , Utils.getDateAndTimeCurrentChangedDayHourMinSec(5, 5, 10, 20));
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method enters date into start drawing input for the newly created draw
     * @throws ParseException
     */
    @Step
    private void enterStartDrawingDrawDateForNewDraw() throws ParseException {
        actionWithWebElements.enterTextIntoInput(startDrawingDrawDate
                , Utils.getDateAndTimeCurrentChangedDayHourMinSec(5, 5, 20, 20));
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method enters date into end drawing input for the newly created draw
     * @throws ParseException
     */
    @Step
    private void enterEndDrawingDrawDateForNewDraw() throws ParseException {
        actionWithWebElements.enterTextIntoInput(endDrawingDrawDate
                , Utils.getDateAndTimeCurrentChangedDayHourMinSec(5, 5, 30, 20));
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method enters date into start win pay input for the newly created draw
     * @throws ParseException
     */
    @Step
    private void enterStartWinPayDateForNewDraw() throws ParseException {
        actionWithWebElements.enterTextIntoInput(startWinPayDate
                , Utils.getDateAndTimeCurrentChangedDayHourMinSec(5, 5, 40, 20));
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method enters date into end win pay input for the newly created draw
     * @throws ParseException
     */
    @Step
    private void enterEndWinPayDateForCreationNewDraw() throws ParseException {
        actionWithWebElements.enterTextIntoInput(endWinPayDate
                , Utils.getDateAndTimeCurrentChangedYear(1));
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method clicks save button
     */
    @Step
    private void clickSaveButton(){
        actionWithWebElements.clickOnElement(saveButton);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method clicks close button
     */
    @Step
    private void clickCloseButton(){
        actionWithWebElements.clickOnElement(closeButton);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method waits until draw is in registration bet closing status
     */
    @Step
    private void waitUntilDrawStatusIsRegBetClosing(){
        actionWithWebElements.waitForTextLonger(drawStatus, "Закрытие регистрации ставок");
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method clicks index creation button
     */
    @Step
    private void clickIndexCreationButton(){
        actionWithWebElements.clickOnElement(indexCreationButton);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method waits until index is created
     */
    @Step
    private void waitUntilIndexIsCreated(){
        actionWithWebElements.waitForTextLonger(drawStatus, "Подготовка к розыгрышу");
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method clicks drawing draw button
     */
    @Step
    private void clickDrawingDrawButton(){
        actionWithWebElements.clickOnElement(drawingDrawButton);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method waits until draw is drawn
     */
    @Step
    private void waitUntilDrawIsDrawn(){
        actionWithWebElements.waitForTextLonger(drawStatus, "Розыгрыш тиража");
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method enters jackpot sum
     * @param summa
     */
    @Step
    private void enterJackpotSum(String summa){
        actionWithWebElements.enterTextIntoInput(jackpot, summa);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method enters mega prize sum
     * @param summa
     */
    @Step
    private void enterMegaPrizeSum(String summa){
        actionWithWebElements.enterTextIntoInput(megaPrize, summa);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method enters drawing results
     */
    @Step
    private void enterResults(){
        actionWithWebElements.clickOnElement(enterResultsButton);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method enters first ball result into input
     * @param ballValue
     */
    @Step
    private void enterFirstBallResult(String ballValue){
        actionWithWebElements.enterTextIntoInput(ball1, ballValue);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method enters second ball result into input
     * @param ballValue
     */
    @Step
    private void enterSecondBallResult(String ballValue){
        actionWithWebElements.enterTextIntoInput(ball2, ballValue);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method enters third ball result into input
     * @param ballValue
     */
    @Step
    private void enterThirdBallResult(String ballValue){
        actionWithWebElements.enterTextIntoInput(ball3, ballValue);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method enters fourth ball result into input
     * @param ballValue
     */
    @Step
    private void enterFourthBallResult(String ballValue){
        actionWithWebElements.enterTextIntoInput(ball4, ballValue);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method enters fifth ball result into input
     * @param ballValue
     */
    @Step
    private void enterFifthBallResult(String ballValue){
        actionWithWebElements.enterTextIntoInput(ball5, ballValue);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method enters sixth ball result into input
     * @param ballValue
     */
    @Step
    private void enterSixthBallResult(String ballValue){
        actionWithWebElements.enterTextIntoInput(ball6, ballValue);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method enters mega ball result into input
     * @param ballValue
     */
    @Step
    private void enterAddBallResult(String ballValue){
        actionWithWebElements.enterTextIntoInput(ball7, ballValue);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method clicks save results button
     */
    @Step
    private void clickSaveResultsButton(){
        actionWithWebElements.clickOnElement(saveResultsButton);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method waits until results are saved
     */
    @Step
    private void waitUntilResultsAreSaved(){
        actionWithWebElements.waitForText(resultsAreSavesSuccessfullyMessage
                ,"Ввод результатов тиража выполнен успешно.");
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method clicks parameters menu button
     */
    @Step
    private void clickParametersMenuButton(){
        actionWithWebElements.clickOnElement(parametersMenuButton);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method waits until draw is in post drawing status
     */
    @Step
    private void waitUtilDrawStatusIsPostDrawing(){
        actionWithWebElements.waitForText(drawStatus, "Послетиражная обработка");
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method clicks win table creation button
     */
    @Step
    private void clickWinTableCreationButton(){
        actionWithWebElements.clickOnElement(winTableCreationButton);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method waits until win payment button is active
     */
    @Step
    private void waitUtilWinPaymentButtonIsActive(){
        actionWithWebElements.waitForClickableElement(winPayButton);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method clicks win pay button
     */
    @Step
    private void clickWinPayButton(){
        actionWithWebElements.clickOnElement(winPayButton);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method waits until draw is in win pay status
     */
    @Step
    private void waitUntilDrawStatusIsWinPay(){
        actionWithWebElements.waitForText(drawStatus, "Выплата выигрышей");
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method clicks parameters export button
     */
    @Step
    private void clickParametersExportButton(){
        actionWithWebElements.clickOnElement(parametersExportButton);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method clicks results export button
     */
    @Step
    private void clickResultsExportButton(){
        actionWithWebElements.clickOnElement(resultsExportButton);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method clicks notify BRS button
     */
    @Step
    private void clickNotifyBRS(){
        actionWithWebElements.clickOnElement(notifyBRS);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method waits until message is visible
     */
    @Step
    private void waitUtilMessageIsVisible(){
        actionWithWebElements.waitVisibilityOfElement(successMessage);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method sets selected params for the newly created draw
     * @param jackpotSum
     * @param megaPrizeSum
     * @throws ParseException
     */
    @Step
    private void setParamsForCreatedDrawExist(
            String jackpotSum, String megaPrizeSum) throws ParseException {
        selectMegalotValueFromLotteryTypesDropDown();
        selectRegistrationBetDrawStatusFilter();
        clickSearchButton();
        selectDrawAndClickIt();
        waitUtilDrawTypeIsVisible();
        enterJackpotSum(jackpotSum);
        enterMegaPrizeSum(megaPrizeSum);
        enterEndRegistrationEndDateForNewDraw();
        enterStartDrawingDrawDateForNewDraw();
        enterEndDrawingDrawDateForNewDraw();
        enterStartWinPayDateForNewDraw();
        enterEndWinPayDateForCreationNewDraw();
        clickSaveButton();
        clickParametersExportButton();
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method changes draw status into registration
     * @param drawId
     * @param change
     */
    @Step
    private void changeDrawStatusIntoRegistration(String drawId, int change){
        logger.info("Draw # " + drawId + " is changed into registration. Status = " + change);
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method changes draw status into registration
     * @param drawId
     * @return
     */
    @Step
    private String changeDrawIntoRegistration(String drawId){
        String script = configProperties.SCRIPT_FOR_CHANGING_DDRAW_STATUS_INTO_REGISTRATION_1()
                + drawId
                + configProperties.SCRIPT_FOR_CHANGING_DDRAW_STATUS_INTO_REGISTRATION_2();
        return script;
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method returns script for changing draw status into registration
     * @param drawId
     * @return
     */
    @Step
    private String changeDrawIntoMultyRegistration(String drawId){
        String script = configProperties.SCRIPT_FOR_CHANGING_DRAW_STATUS_INTO_MULTY_REGISTRATION_1()
                + drawId
                + configProperties.SCRIPT_FOR_CHANGING_DRAW_STATUS_INTO_MULTY_REGISTRATION_2();
        return script;
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method draws selected draw
     * @param jackpotSum
     * @param megaPrizeSum
     * @param ball1
     * @param ball2
     * @param ball3
     * @param ball4
     * @param ball5
     * @param ball6
     * @param ball7
     * @throws ParseException
     */
    @Step
    private void drawingDraw(String jackpotSum, String megaPrizeSum
            , String ball1, String ball2, String ball3
            , String ball4, String ball5, String ball6
            , String ball7) throws ParseException {
        selectMegalotValueFromLotteryTypesDropDown();
        selectRegistrationBetDrawStatusFilter();
        clickSearchButton();
        selectDrawAndClickIt();
        waitUtilDrawTypeIsVisible();
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
//        waitUntilResultsAreSaved();
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

    /**
     * Created by Elena Dovhaliuk
     * This method returns drawId
     * @param drawInRegistration
     * @param drawIdForRegisatration
     * @param drawInMultyRegistration
     * @param drawIdForMultyRegistration
     * @param drawInCreatedStat
     * @param drawIdForCreated
     * @return
     */
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

    /**
     * Created by Elena Dovhaliuk
     * This method returns script for changing draw status
     * @param drawId
     * @return
     */
    @Step
    public String getScriptForChangingDrawStatusInRegistrationBet(String drawId){
        String script = configProperties.SCRIPT_FOR_CHANGING_DDRAW_STATUS_INTO_REGISTRATION_1()
                + drawId + configProperties.SCRIPT_FOR_CHANGING_DDRAW_STATUS_INTO_REGISTRATION_2();
        return script;
    }

    /**
     * Created by Elena Dovhaliuk
     * This method returns draw code of the newly created draw
     * @param drawCode
     * @return
     */
    @Step
    public final String getDrawCodeForNewDrawForCreation(String drawCode){
        int drawIdForCreation = Integer.valueOf(drawCode) + 1;
        return String.valueOf(drawIdForCreation);
    }

    /**
     * Created by Elena Dovhaliuk
     * This method returns draw id of the newly created draw
     * @param drawCode
     * @return
     */
    @Step
    public String getDrawIdOfCreatedDraw(String drawCode){
        String script = configProperties.DRAW_ID_OF_CREATED_DRAW() + drawCode + "'";
        return script;
    }

    /**
     * Created by Elena Dovhaliuk
     * This method returns script for new draw creation
     * @param drawCode
     * @return
     */
    @Step
    public String createDrawInDBScript (String drawCode){
        String script = configProperties.SCRIPT_FOR_CREATION_DRAW_IN_CREATED_STATUS_1()
                + drawCode
                + configProperties.SCRIPT_FOR_CREATION_DRAW_IN_CREATED_STATUS_2()
                + drawCode
                + configProperties.SCRIPT_FOR_CREATION_DRAW_IN_CREATED_STATUS_3();
        logger.info("Draw # " + drawCode + " is created successfully");
        return script;
    }

    /**
     * Created by Elena Dovhaliuk
     * This method returns script for changing parameters for the newly created draw
     * @param drawId
     * @param drawCode
     * @param jackpotSum
     * @param megaPrizeSum
     * @return
     * @throws ParseException
     */
    @Step
    public String changeParamsForNewDraw(String drawId, String drawCode, String jackpotSum, String megaPrizeSum) throws ParseException {
        String script = configProperties.CHANGE_DRAW_PARAMS_SCRIPT_1()
                + drawId
                + configProperties.CHANGE_DRAW_PARAMS_SCRIPT_2()
                + drawCode
                + configProperties.CHANGE_DRAW_PARAMS_SCRIPT_3()
                + drawCode
                + configProperties.CHANGE_DRAW_PARAMS_SCRIPT_4()
                + Utils.getDateAndTimeCurrentChangedMinSec(0, 5)
                + configProperties.CHANGE_DRAW_PARAMS_SCRIPT_5()
                + Utils.getDateAndTimeCurrentChangedDayHourMinSec(135, 4, 4, 10)
                + configProperties.CHANGE_DRAW_PARAMS_SCRIPT_6()
                + Utils.getDateAndTimeCurrentChangedDayHourMinSec(135, 4, 5, 15)
                + configProperties.CHANGE_DRAW_PARAMS_SCRIPT_7()
                + Utils.getDateAndTimeCurrentChangedDayHourMinSec(135, 4, 6, 20)
                + configProperties.CHANGE_DRAW_PARAMS_SCRIPT_8()
                + Utils.getDateAndTimeCurrentChangedDayHourMinSec(135, 4, 7, 25)
                + configProperties.CHANGE_DRAW_PARAMS_SCRIPT_9()
                + Utils.getDateAndTimeCurrentChangedYear(1)
                + configProperties.CHANGE_DRAW_PARAMS_SCRIPT_10()
                + jackpotSum
                + configProperties.CHANGE_DRAW_PARAMS_SCRIPT_11()
                + megaPrizeSum
                + configProperties.CHANGE_DRAW_PARAMS_SCRIPT_12();
        return script;
    }

    /**
     * Created by Elena Dovhaliuk
     * This method returns script for changing status of the newly created draw
     * @param drawInRegistration
     * @param drawInMultyReg
     * @param drawInCreated
     * @param drawIdInCreated
     * @param drawId
     * @return
     */
    @Step
    public String changeCreatedDrawStatus(String drawInRegistration, String drawInMultyReg
            , String drawInCreated, String drawIdInCreated, String drawId){
        String res = "0";
        if (searchForDraw(drawInRegistration).equals("0")) {
            if (searchForDraw(drawInMultyReg).equals("0")) {
                if (searchForDraw(drawInCreated).equals("0") &&
                        !drawIdInCreated.equals(drawId)) {
                    res = changeDrawIntoRegistration(drawId);
                    logger.info("Draw # " + drawId + " is changed into registration status");
                }
            }
        }
        else{
            res = changeDrawIntoMultyRegistration(drawId);
            logger.info("Draw # " + drawId + " is changed into multy registration status");
        }
        return res;
    }

    /**
     * Created by Elena Dovhaliuk
     * This method returns script for blob of parameters reformation
     * @param drawId
     * @return
     */
    @Step
    public String reformBlob(String drawId){
        String script = configProperties.REFORM_BLOB_SCRIPT_1()
                + drawId
                + configProperties.REFORM_BLOB_SCRIPT_2();
        return script;
    }

    /**
     * Created by Elena Dovhaliuk
     * This method determines draw and actions for drawing
     * @param drawInRegistration
     * @param drawIdForRegisatration
     * @param drawInMultyRegistration
     * @param drawIdForMultyRegistration
     * @param drawInCreatedStat
     * @param drawIdForCreated
     * @param jackpotSum
     * @param megaPrizeSum
     * @param ball1
     * @param ball2
     * @param ball3
     * @param ball4
     * @param ball5
     * @param ball6
     * @param ball7
     * @param changeStatus
     * @throws ParseException
     */
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
            drawingDraw(jackpotSum, megaPrizeSum
                    , ball1, ball2, ball3
                    , ball4, ball5, ball6
                    , ball7);
        } else if (searchForDraw(drawInMultyRegistration).equals("1")) {
            logger.info("Draw # " + drawIdForMultyRegistration + " is selected for drawing");
            changeDrawStatusIntoRegistration(drawIdForMultyRegistration, changeStatus);
            drawingDraw(jackpotSum, megaPrizeSum
                    , ball1, ball2, ball3
                    , ball4, ball5, ball6
                    , ball7);
        } else if (searchForDraw(drawInCreatedStat).equals("1")) {
            changeDrawStatusIntoRegistration(drawIdForCreated, changeStatus);
            setParamsForCreatedDrawExist(jackpotSum, megaPrizeSum);
        } else {
            logger.info("There is no draw. It is necessary to create new one");
        }
    }
}

