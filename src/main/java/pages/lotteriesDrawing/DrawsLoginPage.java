package pages.lotteriesDrawing;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by Elena Dovhaliuk
 */

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

    /**
     * Created by Elena Dovhaliuk
     * This private method enters login into login input
     */
    @Step
    private void enterLoginIntoLoginInput(){
        actionWithWebElements.enterTextIntoInput(loginInput, configProperties.CS_OPERATOR_LOGIN());
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method enters password into password input
     */
    @Step
    private void enterPasswordIntoLoginInput(){
        actionWithWebElements.enterTextIntoInput(passwordInput, configProperties.CS_OPERATOR_PASSWORD());
    }

    /**
     * Created by Elena Dovhaliuk
     * This private method clicks OK button
     */
    @Step
    private void clickOKButton(){
        actionWithWebElements.clickOnElement(okBotton);
    }

    /**
     * Created by Elena Dovhaliuk
     * This method enters login, password and clicks OK button
     */
    @Step
    public void drawsAuth(){
        enterLoginIntoLoginInput();
        enterPasswordIntoLoginInput();
        clickOKButton();
    }
}
