package Pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import static core.Conexao.*;

public class AlertaPage {
    private AndroidDriver<MobileElement> driver;

    private By alertaConfirm = By.xpath("//*[@text='ALERTA CONFIRM']");
    private By alertaSimples = By.xpath("//*[@text='ALERTA SIMPLES']");
    private By inf = By.id("android:id/alertTitle");
    private By inf2 = By.id("android:id/alertTitle");
    private By mensagem = By.id("android:id/message");
    private By mensagem2 = By.xpath("//*[@text='Confirmado']");
    private By btnConfirmar = By.id("android:id/button2");
    private By btnNegar = By.id("android:id/button1");
    private By sair = By.id("android:id/button1");
    private By msgForaDaCaixa = By.id("android:id/message");


    public AlertaPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }


    public void clicarAlertConfirm(){
        getDriver().findElement(alertaConfirm).click();

    }
    public void clicarAlertaSimples(){
        getDriver().findElement(alertaSimples).click();

    }
    public String getInfo(){
        String text = getDriver().findElement(inf).getText();
        return text;
    }
    public String getMensagem(){
       return getDriver().findElement(mensagem).getText();
    }
    public String getBtnConfirmar(){
        return getDriver().findElement(btnConfirmar).getText();
    }
    public String getBtnNegar(){
        return getDriver().findElement(btnNegar).getText();
    }
    public void clickBtnNegar(){
         getDriver().findElement(btnNegar).click();
    }
    public void clickBtnConfirmar(){
        getDriver().findElement(btnConfirmar).click();
    }
    public void clickSair(){
        getDriver().findElement(sair).click();
    }
    public String getInfo2(){
        return getDriver().findElement(inf2).getText();
    }
    public String getMsgConfirmado(){
        return getDriver().findElement(mensagem2).getText();
    }
    public String isMenuAlerta(){
        String text = getDriver().findElement(alertaSimples).getText();
        return text;
    }

}
