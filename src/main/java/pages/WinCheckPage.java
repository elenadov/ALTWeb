package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by Elena Dovhaliuk
 */

public class WinCheckPage extends ParentPage {
    public WinCheckPage(WebDriver webDriver) {
        super(webDriver, "/tickets/check");
    }

    @FindBy(xpath = "//label[@class='input-label']/input")
    private TextInput ticketBarcodeInput;

    @FindBy(xpath = "//app-ticket-check//div//button")
    private Button checkTicketWinButton;

    /**
     * Created by Elena Dovhaliuk
     * Such method clicks ticket barcode input
     */
    @Step
    public void clickTicketBarcodeInput(){
        actionWithWebElements.clickOnElement(ticketBarcodeInput);
    }

    /**
     * Created by Elena Dovhaliuk
     * This method clicks check ticket win button
     */
    @Step
    public void clickCheckTicketWinButton(){
        actionWithWebElements.clickOnElement(checkTicketWinButton);
    }

    /**
     * Created by Elena Dovhaliuk
     * Such method enters maccode of the ticket into input
     * @param maccode
     */
    @Step
    public void enterTicketMaccodeIntoInput(String maccode){
        actionWithWebElements.enterTextIntoInput(ticketBarcodeInput, maccode);
    }
}
