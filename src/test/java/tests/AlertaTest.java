package tests;

import base.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.hamcrest.Matchers;
import org.junit.Test;
import pages.AlertaPage;
import pages.MenuPage;

import static org.junit.Assert.*;

public class AlertaTest extends BaseTest {
    private AndroidDriver<MobileElement> driver;
    AlertaPage alertaPage = new AlertaPage(driver);
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
}
