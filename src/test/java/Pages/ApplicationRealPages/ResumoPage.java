package Pages.ApplicationRealPages;

import core.BasePage;
import core.Conexao;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import static core.Conexao.*;

public class ResumoPage extends BasePage {
    public ResumoPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }
    public void excluirMovimentacao(String desc){                                               // use /following-sibling::'nomedaclass' para descer 1 nivel
        MobileElement el = getDriver().findElement(By.xpath("//*[@text='" + desc + "']/..")); // use "/.." para subir um nivel
        swipeElement(el,0.9,0.1);
        clickTexto("Del");
    }

}
