package Pages;

import core.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import tests.DragDropTest;

import static core.Conexao.getDriver;

public class MenuPage extends BasePage {
    private AndroidDriver<MobileElement> driver;

    private By formulario = By.xpath("//android.widget.TextView[@text='Formulário']");
    private By splash = By.xpath("//android.widget.TextView[@text='Splash']");
    private By alerta = By.xpath("//android.widget.TextView[@text='Alertas']");
    private By cliques = By.xpath("//android.widget.TextView[@text='Cliques']");
    private By swipe = By.xpath("//android.widget.TextView[@text='Swipe']");
    private By swipeList = By.xpath("//android.widget.TextView[@text='Swipe List']");
    private By dragDrop = By.xpath("//android.widget.TextView[@text='Drag and drop']");
    private By Hibrido = By.xpath("//android.widget.TextView[@text='SeuBarriga Híbrido']");
    private By Nativo = By.xpath("//android.widget.TextView[@text='SeuBarriga Nativo']");


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
    public SwipeListPage acessarSwipeList() {
        scrollDown();
        getDriver().findElement(swipeList).click();
        return new SwipeListPage(driver);
    }
    public DragDropPage acessarDragDrop() {
        scrollDown();
        getDriver().findElement(dragDrop).click();
        return new DragDropPage(driver);
    }
    public void acessarSeuBarrigaHibrido() {
        getDriver().findElement(Hibrido).click();

    }
    public void acessarAppNativo() {
        getDriver().findElement(Nativo).click();

    }


}