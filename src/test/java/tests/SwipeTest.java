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
        basePage.scroll(0.9,0.1);
        menuPage.acessarSwipe();
        basePage.waitExplicity("a esquerda");
        basePage.swipe(0.9,0.1);
        System.out.println(swipePage.getMensagem());
        Assert.assertEquals("E veja se", swipePage.getMensagem());



    }

}
