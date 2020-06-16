package Pages;

import core.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import static core.Conexao.*;

public class FormularioPage extends BasePage {

    private AndroidDriver<MobileElement> driver;
    BasePage base = new BasePage(driver);

    private By formul = new MobileBy.ByAccessibilityId("nome");
    private By console = new MobileBy.ByAccessibilityId("console");
    private By checkBox = By.className("android.widget.CheckBox");
    private By Switch = new MobileBy.ByAccessibilityId("switch");
    private By clickSalvar = By.xpath("//android.widget.TextView[@text='SALVAR']");
    private By clickSalvarDemorado = By.xpath("//android.widget.TextView[@text='SALVAR DEMORADO']");
    private By nomeSalvo = By.xpath("//android.widget.TextView[starts-with(@text,'Nome:')]");
    private By produtoSalvo = By.xpath("//android.widget.TextView[@text='Console: ps4']");
    private By switchSalvo = By.xpath("//android.widget.TextView[starts-with(@text,   'Switch:')]");

    public FormularioPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }


    public void setNome(String text) {
        getDriver().findElement(formul).sendKeys(text);
    }

    public String getNome() {
        return getDriver().findElement(formul).getText();
    }

    public void clickProduto(String Produto) {
        getDriver().findElement(By.xpath("//*[@text='" + Produto + "']")).click();
    }

    public void selecionarItem(String Produto) {
        getDriver().findElement(console).click();
        clickProduto(Produto);
    }

    public String getNomeProduto(String Produto) {
        return getDriver().findElement(By.xpath("//*[@text='" + Produto + "']")).getText();
    }

    public String CheckEstaMarcado() {
        MobileElement check = getDriver().findElement(checkBox);
        return check.getAttribute("checked");
    }
    public String SwitchEstaMarcado() {
        MobileElement check = getDriver().findElement(Switch);
        return check.getAttribute("checked");
    }
    public void clickCheck(){
        getDriver().findElement(checkBox).click();
    }
    public void clickSwitch(){
        getDriver().findElement(Switch).click();
    }
    public void salvar(){
        getDriver().findElement(clickSalvar).click();
    }
    public void salvarDemorado(){
        getDriver().findElement(clickSalvarDemorado).click();
    }
    public String obterNomeSalvo(){
        return getDriver().findElement(nomeSalvo).getText();
    }
    public String obterProdutoSalvo(){
        return getDriver().findElement(produtoSalvo).getText();
    }
    public String obterSwitchSalvo(){
        return getDriver().findElement(switchSalvo).getText();
    }

    public void clickSeekBar(Double posicao){
        MobileElement seek = getDriver().findElement(MobileBy.AccessibilityId("slid"));
        int y = seek.getLocation().y + (seek.getSize().height/2);
        int x = (int) (seek.getLocation().x + (seek.getSize().width * posicao));
        base.tap(x,y);

    }
    public void clickSeekBarPresisao(Double posicao){
        int delta = 50;
        MobileElement seek = getDriver().findElement(MobileBy.AccessibilityId("slid"));
        int y = seek.getLocation().y + (seek.getSize().height/2);
        int xInicial = (int) (seek.getLocation().x +delta);
        int x = (int) (xInicial +((seek.getSize().width -2 * delta)* posicao));
        base.tap(x,y);


    }

}