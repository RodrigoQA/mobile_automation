package Pages;

import core.BasePage;
import core.Conexao;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import static core.Conexao.*;

public class CliquesPage extends BasePage {
    private AndroidDriver<MobileElement> driver;

    private By getTxtLongo = By.xpath("(//android.widget.TextView)[3]");
    private By getTxtDuplo = By.xpath("(//android.widget.TextView)[3]");


    public CliquesPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public void cliqueLongo(){
        new TouchAction(getDriver())
                .longPress(getDriver().findElement(By.xpath("//*[@text='Clique Longo']"))).perform();
    }
    public String obterTextoLongo(){
       return getDriver().findElement(getTxtLongo).getText();
    }
    public String obterTextoDuplo(){
        return getDriver().findElement(getTxtDuplo).getText();
    }
}
