package abstractParentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import libs.*;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.Parameterized;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.*;
import pages.lotteriesDrawing.DrawsLoginPage;
import pages.lotteriesDrawing.DrawsLotteryInfoPage;
import pages.lotteriesDrawing.DrawsMainMenuPage;

import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class AbstractParentTest {
    WebDriver webDriver;
    protected LoginFormPage loginPage;
    protected LotteriesPage lotteriesPage;
    protected EMLPurchaseMenuPage emlPurchaseMenuPage;
    protected PurchaseRegistrationPage purchaseRegistrationPage;
    protected LotoZabavaPurchaseMenuPage lotoZabavaPurchaseMenuPage;
    protected WinCheckPage winCheckPage;
    protected WinPayPage winPayPage;
    protected DrawsLoginPage drawsLoginPage;
    protected DrawsLotteryInfoPage drawsLotteryInfoPage;
    protected DrawsMainMenuPage drawsMainMenuPage;


    protected static ConfigProperties configProperties =
            ConfigFactory.create(ConfigProperties.class);
    protected Logger logger = Logger.getLogger(getClass());
    protected UtilsForMySQL utilsForMySQL = new UtilsForMySQL();
    protected UtilsForOracleSQL utilsForOracleSQL = new UtilsForOracleSQL();
//    protected Database database;

//    @Before
//    public void mySQLDBConnect() throws SQLException, ClassNotFoundException {
//        database = MySQL_Database.getDataBase();
//    }
//
//    @Step
//    public void oracleSQLDBConnect() throws SQLException, ClassNotFoundException {
//        database = Oracle_SQL_Database.getOracleDataBase();
//    }

    @Before
    public void SetUp() throws Exception {
        webDriver = driverInit();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LoginFormPage(webDriver);
        lotteriesPage = new LotteriesPage(webDriver);
        emlPurchaseMenuPage = new EMLPurchaseMenuPage(webDriver);
        purchaseRegistrationPage = new PurchaseRegistrationPage(webDriver);
        lotoZabavaPurchaseMenuPage = new LotoZabavaPurchaseMenuPage(webDriver);
        winCheckPage = new WinCheckPage(webDriver);
        winPayPage = new WinPayPage(webDriver);
        drawsLoginPage = new DrawsLoginPage(webDriver);
        drawsLotteryInfoPage = new DrawsLotteryInfoPage(webDriver);
        drawsMainMenuPage = new DrawsMainMenuPage(webDriver);
    }

    @Parameterized.Parameters
    private WebDriver driverInit() throws Exception {
        String hub = System.getProperty("tunnelHub");
        String browser = System.getProperty("browser");
        if ((browser == null) || ("chrome".equalsIgnoreCase(browser))) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if ("firefox".equalsIgnoreCase(browser)) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else if ("ie".equalsIgnoreCase(browser)) {
            WebDriverManager.iedriver().arch32().setup();
            return new InternetExplorerDriver();
        } else if ("remote".equals(browser)){
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("build", "NewTunnel");
            capabilities.setCapability("name", "05/01/2021");
            capabilities.setCapability("platform", "Windows 10");
            capabilities.setCapability("browserName", "Firefox");
            capabilities.setCapability("version","84.0");
            capabilities.setCapability("resolution","2560x1440");
            capabilities.setCapability("tunnel",true);
            return webDriver = new RemoteWebDriver(new URL(hub), capabilities);
        }else {
            throw new Exception("Check browser var ");
        }
    }

//    @After
//    public void tearDown() throws SQLException {
//        database.quit();
//    }

    @Rule
    public TestWatcher watchman = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            screenshot();
        }

        @Attachment(value = "Page screenshot", type = "image/png")
        public byte[] saveScreenshot(byte[] screenShot) {
            return screenShot;
        }

        public void screenshot() {
            if (webDriver == null) {
                logger.info("Driver for screenshot not found");
                return;
            }
            saveScreenshot(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES));
        }

        @Override
        protected void finished(Description description) {
            logger.info(String.format("Finished test: %s::%s", description.getClassName(), description.getMethodName()));
            try {
                webDriver.quit();
            } catch (Exception e) {
                logger.error(e);
            }
        }
    };

    @Step
    protected void checkExpectedResult(String message, boolean actualResult) {
        Assert.assertEquals(message, true, actualResult);
    }

    @Step
    protected void checkExpectedText(String message, String expectedResult, String actualResult) {
        Assert.assertEquals(message, expectedResult, actualResult);
    }

    @Step
    protected void checkExpectedText(String message, ArrayList<String> expectedResult, ArrayList<String> actualResult){
        Assert.assertEquals(message,expectedResult,actualResult);
    }
}
