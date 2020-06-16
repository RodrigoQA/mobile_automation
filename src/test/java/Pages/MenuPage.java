package Pages;

import core.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.By;

import static core.Conexao.getDriver;

public class MenuPage extends BasePage {
    private AndroidDriver<MobileElement> driver;

    private By formulario = By.xpath("//android.widget.TextView[@text='Formulário']");
    private By splash = By.xpath("//android.widget.TextView[@text='Splash']");
    private By alerta = By.xpath("//android.widget.TextView[@text='Alertas']");
    private By cliques = By.xpath("//android.widget.TextView[@text='Cliques']");
    private By swipe = By.xpath("//android.widget.TextView[@text='Swipe']");

    public MenuPage(AndroidDriver<MobileElement> driver) {
        super(driver);
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
    @Test
    public CliquesPage acessarCliques() {

        getDriver().findElement(cliques).click();
        return new CliquesPage(driver);
    }
    public SwipePage acessarSwipe() {

        getDriver().findElement(swipe).click();
        return new SwipePage(driver);
    }
    public boolean isMenuInicial(){
        String menu = getDriver().findElement(formulario).getText();
        return Boolean.parseBoolean(menu);
    }


}