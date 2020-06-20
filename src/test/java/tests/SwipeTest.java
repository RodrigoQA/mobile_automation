package tests;

import Pages.MenuPage;
import Pages.SwipePage;
import core.BasePage;
import core.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.junit.Test;

public class SwipeTest extends BaseTest {
    private AndroidDriver<MobileElement> driver;
    MenuPage menuPage = new MenuPage(driver);
    SwipePage swipePage = new SwipePage(driver);
    BasePage basePage = new BasePage(driver);

    @Test
    public void testeDeveInteragirSwipe() throws InterruptedException {
        // rolar para baixo
        basePage.scrollDown();
        menuPage.acessarSwipe();
        basePage.waitExplicity("a esquerda");
        //swipe passar para tela direita
        basePage.swipeRigth();
        Assert.assertEquals("E veja se", swipePage.mensagemVejaSe());
        basePage.clickTexto("›");
        Assert.assertEquals("Chegar até o fim!", swipePage.mesagemChegouAoFim());
        basePage.clickTexto("‹");
        Assert.assertEquals("E veja se", swipePage.mensagemVejaSe());
        //swipe passar para tela esquerda
        basePage.swipeLeft();






    }

}
