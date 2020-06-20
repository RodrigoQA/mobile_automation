package Pages.ApplicationRealPages;

import core.BasePage;
import core.Conexao;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import static core.Conexao.*;

public class HomePage extends BasePage {
    public HomePage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }
    public String obteSaldoConta(String conta){                      // use /following-sibling::'nomedaclass' para descer 1 nivel
       return getDriver().findElement(By.xpath("//*[@text='"+conta+"']/following-sibling::android.widget.TextView")).getText();

    }
}
