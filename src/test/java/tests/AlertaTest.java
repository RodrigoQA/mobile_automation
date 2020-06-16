package tests;

import core.BaseTest;
import core.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import Pages.AlertaPage;
import Pages.MenuPage;

import static org.junit.Assert.*;

public class AlertaTest extends BaseTest {
    private AndroidDriver<MobileElement> driver;
    AlertaPage alertaPage = new AlertaPage(driver);
    BasePage basePage = new BasePage(driver);
    MenuPage menuPage = new MenuPage(driver);

    @Test
    public void deveConfirmarAlertas(){
        // acessar menu alerta
        alertaPage = menuPage.acessarAlerta();
        //clicar em alerta confir
        alertaPage.clicarAlertConfirm();
        //validar informacoes no alerta
        assertNotNull(alertaPage.getInfo());
        assertEquals("Confirma a operação?",alertaPage.getMensagem());
        assertEquals("CONFIRMAR",alertaPage.getBtnConfirmar());
        assertNotNull(alertaPage.getBtnNegar());
        //clicar em confirmar
        alertaPage.clickBtnConfirmar();
        //validar novo alerta
        assertNotNull(alertaPage.getInfo2());
        assertEquals("Confirmado",alertaPage.getMsgConfirmado());
        //clicar em sair
        alertaPage.clickSair();

    }
    @Test
    public void testeDeveClicarForaDoAlerta() throws InterruptedException {
        alertaPage = menuPage.acessarAlerta();
        alertaPage.clicarAlertaSimples();
        Thread.sleep(2000);
        basePage.tap(100,150);
       assertEquals(alertaPage.isMenuAlerta(),"ALERTA SIMPLES");

    }
}
