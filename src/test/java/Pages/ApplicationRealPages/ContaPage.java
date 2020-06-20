package Pages.ApplicationRealPages;

import core.BasePage;
import core.Conexao;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import static core.Conexao.*;

public class ContaPage extends BasePage {
    public ContaPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    private By getEmail = By.xpath("//*[@text='Nome']");
    private By getSenha = By.xpath("//*[@text='Senha']");
    private By btnEntrar = By.xpath("//*[@text='ENTRAR']");
    private By getConta = By.xpath("//*[@text='Conta']");

    public void setEmail(String email){
        getDriver().findElement(getEmail).sendKeys(email);
    }
    public void setSenha(String senha){
        getDriver().findElement(getSenha).sendKeys(senha);
    }
    public void Entrar(){
        getDriver().findElement(btnEntrar).click();
    }
    public void setNomeConta(String nome){
        getDriver().findElement(getConta).sendKeys(nome);
    }
}
