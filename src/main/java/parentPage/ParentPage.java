package parentPage;

import io.qameta.allure.Step;
import libs.ActionWithWebElements;
import libs.ConfigProperties;
import libs.Database;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.pageElements.WebDriverAwareDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

/**
 * Created by Elena Dovhaliuk
 */

public class ParentPage {
    protected WebDriver webDriver;
    protected Logger logger = Logger.getLogger(getClass());
    protected ActionWithWebElements actionWithWebElements;
    public ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
    protected String baseUrl;
    String expectedUrl;
    protected String addUrl;
    String expectedAddUrl;
    protected Database database;

    public ParentPage(WebDriver webDriver, String partUrl){
        baseUrl = configProperties.base_url();
        addUrl = configProperties.addUrl();
        this.webDriver = webDriver;
        PageFactory.initElements(
                new WebDriverAwareDecorator(
                        new HtmlElementLocatorFactory(webDriver), webDriver), this);
        actionWithWebElements = new ActionWithWebElements(webDriver);
        expectedUrl = baseUrl + partUrl;
        expectedAddUrl = addUrl + partUrl;
    }

    /**
     * Such method opens page by selected url
     */
    @Step
    public void openPage() {
        try {
            webDriver.get(expectedUrl);
        } catch (Exception e) {
            Assert.fail("Can't work with page");
        }
    }

    @Step
    public void openAddPage() {
        try {
            webDriver.get(expectedAddUrl);
        } catch (Exception e) {
            Assert.fail("Can't work with page");
        }
    }

    /**
     * Such method checks if current url is correct according to expected one
     */
    @Step
    public void checkCurrentUrl(){
        try{
            Assert.assertEquals("Url is not correct", expectedUrl, webDriver.getCurrentUrl());
        }catch (Exception e){
            logger.error("Can't get url " + e);
            Assert.fail("Can't get url " + e);
        }
    }
}
