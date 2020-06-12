package tests;

import base.BaseTest;
import core.Conexao;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FormularioPage;
import pages.MenuPage;
import pages.SplashPage;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class FormularioTest extends BaseTest {
    private AndroidDriver<MobileElement> driver;
    MenuPage menuPage = new MenuPage(driver);
    FormularioPage formularioPage = new FormularioPage(driver);
    SplashPage splashPage = new SplashPage(driver);




    @Test
    public void testDeveInstalarAPK_MobileFisico() throws MalformedURLException {
        //selecionar formularios
        formularioPage = menuPage.acessarFormulario();

    }
    @Test
    public void testDevePreencherCampoNome() throws MalformedURLException {
        System.out.println("Seu smartphone foi conectado! ");
//      List<MobileElement> elementosEncontrados =  driver.findElements(By.className("android.widget.TextView"));
//       elementosEncontrados.get(1).click();

        //selecionar formularios
        formularioPage = menuPage.acessarFormulario();

        //preencher nome
        formularioPage.setNome("rodrigo lima");
        assertEquals(formularioPage.getNome(),"rodrigo lima");

    }

    @Test
    public void testDeveInteragiCombo() throws MalformedURLException {

        System.out.println("Seu smartphone foi conectado! ");
        //selecionar formularios
        formularioPage = menuPage.acessarFormulario();

        //clicar no combo
        formularioPage.selecionarItem("PS4");
        // verificar opcao selecionada
        String item = formularioPage.getNomeProduto("PS4");
        assertEquals("PS4",item);
    }
    @Test
    public void testDeveInteragir_Switch_CheckBox() throws MalformedURLException {
        System.out.println("Seu smartphone foi conectado! ");

        //selecionar formularios
        formularioPage = menuPage.acessarFormulario();
        assertEquals(formularioPage.CheckEstaMarcado(),"false");
        assertEquals(formularioPage.SwitchEstaMarcado(),"true");
        //clicar nos elementos
        formularioPage.clickCheck();
        formularioPage.clickSwitch();
        //validar alteracoes
        assertEquals(formularioPage.CheckEstaMarcado(),"true");
        assertEquals(formularioPage.SwitchEstaMarcado(),"false");
    }
    @Test
    public void testRealizarCadastroComSucesso() throws MalformedURLException {
        System.out.println("Seu smartphone foi conectado! ");
        formularioPage = menuPage.acessarFormulario();
        formularioPage.setNome("rodrigo lima");
        formularioPage.selecionarItem("PS4");

        formularioPage.clickSwitch();
        formularioPage.clickCheck();

        formularioPage.salvar();

        assertThat("Nome: rodrigo lima", is(formularioPage.obterNomeSalvo()));
        assertEquals("Console: ps4",formularioPage.obterProdutoSalvo());
        assertEquals("Switch: Off",formularioPage.obterSwitchSalvo());




    }
    @Test
    public void testRealizarCadastroDemorado() throws InterruptedException {
// metodos de esperas
        System.out.println("Seu smartphone foi conectado! ");
        formularioPage = menuPage.acessarFormulario();
        formularioPage.setNome("rodrigo lima");
        Conexao.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);// espera implicita

        formularioPage.salvarDemorado();
       // formularioPage.esperar(3000);
        WebDriverWait wait = new WebDriverWait(Conexao.getDriver(),10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@text='Nome: rodrigo lima']")));

        assertThat("Nome: rodrigo lima", is(formularioPage.obterNomeSalvo()));


    }
}


