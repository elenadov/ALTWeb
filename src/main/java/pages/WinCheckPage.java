package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class WinCheckPage extends ParentPage {
    public WinCheckPage(WebDriver webDriver) {
        super(webDriver, "/tickets/check");
    }

    @FindBy(xpath = "//label[@class='input-label']/input")
    private TextInput ticketBarcodeInput;

    @FindBy(xpath = "//app-ticket-check//div//button")
    private Button checkTicketWinButton;

    @Step
    public void clickTicketBarcodeInput(){
        actionWithWebElements.clickOnElement(ticketBarcodeInput);
    }

    @Step
    public void clickCheckTicketWinButton(){
        actionWithWebElements.clickOnElement(checkTicketWinButton);
    }

    @Step
    public void enterTicketMaccodeIntoInput(String maccode){
        actionWithWebElements.enterTextIntoInput(ticketBarcodeInput, maccode);
    }
}
