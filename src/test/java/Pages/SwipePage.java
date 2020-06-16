package Pages;

import core.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import static core.Conexao.getDriver;

public class SwipePage extends BasePage {

    private By getMensagem = By.xpath("//*[@text='E veja se']");

    public SwipePage(AndroidDriver<MobileElement> driver) {
        super(driver);




    }
    public String getMensagem(){
        return getDriver().findElement(getMensagem).getText();
    }
}
