package pages;

import core.Conexao;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static core.Conexao.getDriver;


public class SplashPage {
    private AndroidDriver<MobileElement> driver;

    private By splash = By.xpath("//*[@text='Splash!']");


    public SplashPage(AndroidDriver<MobileElement> driver) { this.driver = driver; }


    public String isNaTelaSplash(){
        return getDriver().findElement(splash).getText();

    }

    public void aguardaSplashFechar(){
        WebDriverWait wait = new WebDriverWait(Conexao.getDriver(),10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(splash));
    }
}
