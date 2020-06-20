package tests;

import Pages.MenuPage;
import Pages.SwipeListPage;
import core.BasePage;
import core.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.junit.Test;

public class SwipeListTest extends BaseTest {
    private AndroidDriver<MobileElement> driver;
    MenuPage menuPage = new MenuPage(driver);
    BasePage basePage = new BasePage(driver);
    SwipeListPage swipeListPage = new SwipeListPage(driver);


    @Test
    public void testeDeveInteragirSwipeList() {

        //clicar swipe List
        menuPage.acessarSwipeList();
        //opcao 1 para direita
        swipeListPage.swipeListElementRigt("Opção 1");
        //click  (+)
        swipeListPage.clicarBtnMais();
        // verificar texto opcao 1 (+)
        Assert.assertTrue(basePage.elementoEstaVisivel("Opção 1 (+)"));
        //opcao 4 para esquerda
        swipeListPage.swipeListElementRigt("Opção 4");
        //click  (-)
        basePage.clickTexto("(-)");
        // verificar texto opcao 4 (-)
        Assert.assertTrue(basePage.elementoEstaVisivel("Opção 4 (-)"));
        //opcao 5 para direita
        swipeListPage.swipeListElementLeft("Opção 5 (-)");
        //verificar opcao 5
        Assert.assertTrue(basePage.elementoEstaVisivel("Opção 5"));


    }
}