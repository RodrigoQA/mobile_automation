package tests;

import core.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import Pages.MenuPage;
import Pages.SplashPage;

import static org.junit.Assert.assertEquals;

public class SplashTest extends BaseTest {
    private AndroidDriver<MobileElement> driver;
    MenuPage menuPage = new MenuPage(driver);
    SplashPage splashPage = new SplashPage(driver);
    @Test
    public void deveAguardarMenuSplashSumir(){
        //acessar menu splash
        splashPage = menuPage.acessarSplash();
        //verificar se o splash esta sendo apresenda
        assertEquals("Splash!", splashPage.isNaTelaSplash());
        //aguarda o splash sair
        splashPage.aguardaSplashFechar();
        //verificar que a pagina do menu esta sendo apresenda
        assertEquals("Formulário",menuPage.isMenuInicial());
    }
}
