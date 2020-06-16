package tests;

import Pages.CliquesPage;
import Pages.MenuPage;
import core.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CliquesTest extends BaseTest {
    private AndroidDriver<MobileElement> driver;
    MenuPage menuPage = new MenuPage(driver);
    CliquesPage cliquesPage = new CliquesPage(driver);


   @Test
    public void testeDeveRealizarCliqueLongo(){
       menuPage.acessarCliques();
       cliquesPage.cliqueLongo();
       assertEquals("Clique Longo",cliquesPage.obterTextoLongo());
  }
    @Test
    public void testeDeveRealizarCliqueDuplo(){
        menuPage.acessarCliques();
        cliquesPage.clickTexto("Clique duplo");
        cliquesPage.clickTexto("Clique duplo");
        assertEquals("Duplo Clique",cliquesPage.obterTextoDuplo());
    }
}
