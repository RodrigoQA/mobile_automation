package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import tests.AlertaTest;

import static core.Conexao.getDriver;

public class MenuPage {
    private AndroidDriver<MobileElement> driver;

    private By formulario = By.xpath("//android.widget.TextView[@text='Formulário']");
    private By splash = By.xpath("//android.widget.TextView[@text='Splash']");
    private By alerta = By.xpath("//android.widget.TextView[@text='Alertas']");


    public MenuPage(AndroidDriver<MobileElement> driver) {
    }

    public FormularioPage acessarFormulario() {
        getDriver().findElement(formulario).click();
        return new FormularioPage(driver);
    }

    public SplashPage acessarSplash() {
        getDriver().findElement(splash).click();
        return new SplashPage(driver);
    }
    @Test
    public AlertaPage acessarAlerta(){

        getDriver().findElement(alerta).click();
        return new AlertaPage(driver);

    }
    public String isMenuInicial() {
        String menu = getDriver().findElement(formulario).getText();
        return menu;
    }

}