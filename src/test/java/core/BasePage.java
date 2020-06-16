package core;


import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static core.Conexao.*;

public class BasePage {

    private AndroidDriver<MobileElement> driver;
    private By getMensagem = By.id("android:id/message");
    private By clickSalvar = By.xpath("//android.widget.TextView[@text='SALVAR']");

    public BasePage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void waitExplicity(String Bynome){
        WebDriverWait wait = new WebDriverWait(Conexao.getDriver(),10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@text='"+Bynome+"']")));
    }
    public static void clickTexto(String texto){
        getDriver().findElement(By.xpath("//*[@text='"+texto+"']")).click();
    }
    public String getMensagemAlerta(){
       return getDriver().findElement(getMensagem).getText();
    }
    public void tap(int x ,int y){
        new TouchAction(getDriver()).tap(x, y).perform();
    }
    public void esperar(long tempo) throws InterruptedException {
        Thread.sleep(tempo);
    }
    public void salvar(){
        getDriver().findElement(clickSalvar).click();
    }

    public void scroll(double inicio, double fim){
        Dimension size = getDriver().manage().window().getSize();
        int x = size.width / 2;

        int start_y = (int) (size.height * inicio);
        int end_y = (int) (size.height * fim);

        new TouchAction(getDriver())
                .press(x, start_y)
                .waitAction(Duration.ofMillis(500))
                .moveTo(x,end_y)
                .release()
                .perform();

    }
    public void swipe(double inicio, double fim){
        Dimension size = getDriver().manage().window().getSize();
        int y = size.height / 2;

        int start_x = (int) (size.width * inicio);
        int end_x = (int) (size.width * fim);

        new TouchAction(getDriver())
                .press(start_x, y)
                .waitAction(Duration.ofMillis(1000))
                .moveTo(end_x, y)
                .release()
                .perform();

    }

}
