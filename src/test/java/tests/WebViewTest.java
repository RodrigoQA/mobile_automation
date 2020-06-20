package tests;

import Pages.MenuPage;
import Pages.WebViewPage;
import core.BasePage;
import core.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class WebViewTest extends BaseTest {
    private AndroidDriver<MobileElement> driver;

    MenuPage menuPage = new MenuPage(driver);
    WebViewPage webViewPage = new WebViewPage();
    BasePage basePage = new BasePage(driver);


    @Test
    public void testeDeveFazerLogin() {
        menuPage.acessarSeuBarrigaHibrido();
        basePage.esperar(3000);
        webViewPage.entrarContextWeb();
        webViewPage.setEmail("rodrigolima.ads93@gmail.com");
        webViewPage.setSenha("123456");
        webViewPage.Entrar();
        Assert.assertEquals("Bem vindo, Rodrigo !", webViewPage.obterMensagem());


    }

    @After
    public void ExitContextWeb() {
        webViewPage.sairContextWeb();
    }
}