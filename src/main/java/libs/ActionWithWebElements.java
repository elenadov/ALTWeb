package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

import java.math.BigDecimal;

public class ActionWithWebElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait webDriverWait_05, webDriverWait_10, webDriverWait_20, webDriverWait_30;
    Actions actions;
    private int triesCount = 1;

    public ActionWithWebElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait_05 = new WebDriverWait(webDriver, 5);
        webDriverWait_10 = new WebDriverWait(webDriver, 10);
        webDriverWait_20 = new WebDriverWait(webDriver, 20);
        webDriverWait_30 = new WebDriverWait(webDriver, 30);
        actions = new Actions(webDriver);
    }

    /**
     * This method enters text (String text) into text input
     * @param webElement
     * @param text
     */
    public void enterTextIntoInput(WebElement webElement, String text) {
        try {
            webDriverWait_10.until(ExpectedConditions.visibilityOf(webElement));
            webElement.clear();
            webElement.sendKeys(text);
            logger.info("'" + text + "'" + " was inputed into input");
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    /**
     * This method gets name of the element to be printed in logs
     * @param webElement
     * @return
     */
    private String getElementName(WebElement webElement) {
        String elementName = "";
        if (webElement instanceof TypifiedElement) {
            elementName = "'" + ((TypifiedElement) webElement).getName() + "'";
        }
        return elementName;
    }

    /**
     * This method clicks on selected element on the page
     * @param webElement
     */
    public void clickOnElement(WebElement webElement) {
        try {
            webDriverWait_10.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            logger.info("Element was clicked " + getElementName(webElement));
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

    /**
     * This method checks whether selected element is displayed on the page
     * @param webElement
     * @return
     */
    public boolean isElementDisplayed(WebElement webElement) {
        for (int i = 0; i <= triesCount; i++) {
            try {
                waitVisibilityOfElement(webElement);
                boolean state = webElement.isDisplayed();
                logger.info(getElementName(webElement) + " is displayed ->" + state);
                return state;
            } catch (Exception e) {
                logger.info(getElementName(webElement) + " is displayed -> False");
            }
        }
        return false;
    }

    /**
     * This method is used to stop test and print an appropriate message in case of failure
     */
    private void stopTestAndPrintMessage() {
        logger.error("Can't work with element ");
        Assert.fail("Can't work with element ");
    }

    /**
     * This method set necessary state to check box
     * @param checkBox
     * @param state
     */
    public void setStateToCheckBox(WebElement checkBox, String state) {
        boolean isStateCheck = state.toLowerCase().equals("uncheck");
        boolean isStateUncheck = state.toLowerCase().equals("check");
        boolean isCheckBoxSelected = checkBox.isSelected();
        if (isStateCheck || isStateUncheck) {
            if ((isStateCheck && isCheckBoxSelected) || (isStateUncheck && !isCheckBoxSelected)) {
                logger.info("CheckBox is already needed state");
            } else if ((isStateCheck && !isCheckBoxSelected) || (isStateUncheck && isCheckBoxSelected)) {
                clickOnElement(checkBox);
            } else {
                logger.error("State should be only 'check' or 'uncheck'");
                stopTestAndPrintMessage();
            }
        }
    }

    /**
     * This method waits until selected element is invisible
     * @param webElement
     */
    public void waitInvisibilityOfElement(WebElement webElement) {
        webDriverWait_10.until(ExpectedConditions.invisibilityOf(webElement));
        logger.info("Element was closed" + getElementName(webElement));
    }

    /**
     * This method waits until selected element is visible
     * @param webElement
     */
    public void waitVisibilityOfElement(WebElement webElement) {
        ExpectedConditions.visibilityOf(webElement);
    }

    /**
     * This method waits until selected element is visible
     * @param locator
     * @param webElement
     */
    public void waitForVisibilityOfElementLocated(By locator, WebElement webElement) {
        for (int i = 0; i <= triesCount; i++) {
            try {
                webDriverWait_10.until(ExpectedConditions.visibilityOfElementLocated(locator));
            } catch (Exception e) {
                logger.info(getElementName(webElement) + " is visible -> False");
            }
        }
    }

    /**
     * This method waits until selected elements are visible
     * @param webElement
     */
    public void waitForVisibilityOfAllElement(WebElement webElement) {
        for (int i = 0; i <= triesCount; i++) {
            try {
                webDriverWait_10.until(ExpectedConditions.visibilityOf(webElement));
            } catch (Exception e) {
                logger.info(getElementName(webElement) + " is visible -> False");
            }
        }
    }

    /**
     * This method waits until selected text is visible
     * @param webElement
     * @param text
     */
    public void waitForText(WebElement webElement, String text) {
        webDriverWait_10.until(ExpectedConditions.textToBePresentInElement(webElement, text));
    }

    /**
     * This method checks if selected element is clickable
     * @param webElement
     */
    public void waitForClickableElement(WebElement webElement) {
        webDriverWait_10.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    /**
     * This method gets text from selected element (without any spaces before and after the text)
     * @param webElement
     * @return
     */
    public String getTextFromElement(WebElement webElement) {
        String text = webElement.getText().trim();
        return text;
    }

    /**
     * Created by Elena Dovhaliuk
     * This method gets only text from selected element
     * @param webElement
     * @return
     */
    public String getTextFromElementNumInt(WebElement webElement) {
        String text = webElement.getText().trim();
        return text.replaceAll("[^0-9]", "");
    }

    /**
     * Created by Elena Dovhaliuk
     * This method gets text and dots in it from selected element
     * @param webElement
     * @return
     */
    public String getTextFromElementSum(WebElement webElement) {
        String text = webElement.getText().trim();
        return text.replaceAll("[^\\d.]", "");
    }

    /**
     * This method performs imitation of mouse over selected element
     * @param webElement
     */
    public void mouseOver(WebElement webElement) {
        actions.moveToElement(webElement).build().perform();
    }

    /**
     * This method is used to select selected value in drop down by visible text
     * @param dropDown
     * @param text
     */
    public void selectVisibleTextInDropDown(WebElement dropDown, String text) {
        try {
            Select select = new Select(dropDown);
            select.selectByVisibleText(text);
            logger.info(text + " was selected in Drop Down");
        }catch (Exception e){
            stopTestAndPrintMessage();
        }
    }

    /**
     * Created by Elena Dovhaliuk
     * This method rounds double value up to the desired rank
     * @param value
     * @param places
     * @return
     */
    public double roundDouble(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, BigDecimal.ROUND_HALF_UP);
        return bd.doubleValue();
    }
}
