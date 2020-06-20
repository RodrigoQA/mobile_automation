package Pages;

import core.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import static core.Conexao.getDriver;

public class SwipePage extends BasePage {

    private By mensagemVeja = By.xpath("//*[@text='E veja se']");
    private By mensagemFim = By.xpath("//*[@text='Chegar até o fim!']");
    public SwipePage(AndroidDriver<MobileElement> driver) {
        super(driver);




    }
    public String mensagemVejaSe(){
        return getDriver().findElement(mensagemVeja).getText();
    }
    public String mesagemChegouAoFim(){
        return getDriver().findElement(mensagemFim).getText();
    }
}
