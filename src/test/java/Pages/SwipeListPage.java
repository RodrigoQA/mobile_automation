package Pages;

import core.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import static core.Conexao.getDriver;

public class SwipeListPage extends BasePage {
    public SwipeListPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public void swipeListElementLeft(String opcao){
        swipeElement(getDriver().findElement(By.xpath("//*[@text='"+opcao+"']/..")),0.1,0.9);
    }
    public void swipeListElementRigt(String opcao){
        swipeElement(getDriver().findElement(By.xpath("//*[@text='"+opcao+"']/..")),0.9,0.1);
    }
    public void clicarBtnMais(){
        MobileElement batao = getDriver().findElement(By.xpath("//*[@text='(+)']/.."));
        new TouchAction(getDriver())
                .tap(batao,-50,0)
                .perform();
    }
}
