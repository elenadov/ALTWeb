package pages.lotteriesDrawing;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class DrawsLoginPage extends ParentPage {
    public DrawsLoginPage(WebDriver webDriver) {
        super(webDriver, "/index.jsp");
    }

    @FindBy(name = "j_username")
    private TextInput loginInput;

    @FindBy (name = "j_password")
    private TextInput passwordInput;

    @FindBy (name = "submit")
    private Button okBotton;

    @Step
    private void enterLoginIntoInput(){
        actionWithWebElements.enterTextIntoInput(loginInput, configProperties.CS_OPERATOR_LOGIN());
    }

    @Step
    private void enterPasswordIntoInput(){
        actionWithWebElements.enterTextIntoInput(passwordInput, configProperties.CS_OPERATOR_PASSWORD());
    }

    @Step
    private void clickOKButton(){
        actionWithWebElements.clickOnElement(okBotton);
    }


    @Step
    public void drawsAuth(){
        enterLoginIntoInput();
        enterPasswordIntoInput();
        clickOKButton();
    }
}
