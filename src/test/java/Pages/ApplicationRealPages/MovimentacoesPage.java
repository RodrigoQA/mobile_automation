package Pages.ApplicationRealPages;

import core.BasePage;
import core.Conexao;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import static core.Conexao.*;

public class MovimentacoesPage extends BasePage {

    public MovimentacoesPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }
    public void selecionarConta(int opcao){
        getDriver().findElements(By.className("android.widget.Spinner")).get(1).click();
        MobileElement conta = getDriver().findElements(By.id("android:id/text1")).get(opcao);
        System.out.println(conta.getText());
        conta.click();

    }
    public void ativaSwitch(){
        getDriver().findElement(By.className("android.widget.Switch")).click();
    }
}
