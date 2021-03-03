package pages.lotteriesDrawing;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;
import ru.yandex.qatools.htmlelements.element.Button;

public class DrawsMainMenuPage extends ParentPage {
    public DrawsMainMenuPage(WebDriver webDriver) {
        super(webDriver, "/indexMain.jsp");
    }

    @FindBy (xpath = "//a[@href='draws.do']")
    private Button drawInfoButton;

    @Step
    public void clickDrawInfoButton(){
        actionWithWebElements.clickOnElement(drawInfoButton);
    }
}
