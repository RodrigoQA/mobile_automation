package tests.ApplicationRealTests;

import Pages.ApplicationRealPages.*;
import Pages.MenuPage;
import core.BasePage;
import core.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class AppNativoTest extends BaseTest {
    private AndroidDriver<MobileElement> driver;
    ResumoPage resumo = new ResumoPage(driver);
    MenuPage menuPage = new MenuPage(driver);
    ContaPage nativoPage = new ContaPage(driver);
    BasePage base = new BasePage(driver);
    ContaPage conta = new ContaPage(driver);
    MovimentacoesPage mov = new MovimentacoesPage(driver);
    HomePage home = new HomePage(driver);



    Utils utils = new Utils();
    String alt = utils.gerarLetras();




    @Before
    public void fazerLogin(){
        menuPage.acessarAppNativo();
        nativoPage.setEmail("ro@gmail.com");
        nativoPage.setSenha("1234");
        nativoPage.Entrar();
    }
    @Test
    public void testInserirConta_sucesso() {

        base.clickTexto("CONTAS");
        conta.setNomeConta("Contas" + alt + "");
        conta.salvar();
        assertTrue(conta.elementoEstaVisivel("Conta adicionada com sucesso"));
    }
    @Test
    public void testExcluirConta_sucesso() {
        base.clickTexto("CONTAS");
        conta.cliqueLongo("Conta mesmo nome");
        conta.clickTexto("EXCLUIR");
        assertTrue(conta.elementoEstaVisivel("Conta excluída com sucesso"));
    }
    @Test
    public void testValidarinclusaoMov(){

        base.clickTexto("MOV...");
        mov.ativaSwitch();
        mov.clickTexto("SALVAR");
        assertTrue(mov.elementoEstaVisivel("Descrição é um campo obrigatório"));
        mov.setTexto("Descrição","desc teste");
        mov.salvar();
        assertTrue(mov.elementoEstaVisivel("Interessado é um campo obrigatório"));
        mov.setTexto("Interessado","interessado teste");
        mov.salvar();
        assertTrue(mov.elementoEstaVisivel("Valor é um campo obrigatório"));
        mov.setTexto("Valor","120,00");
        mov.salvar();
        assertTrue(mov.elementoEstaVisivel("Conta é um campo obrigatório"));
        mov.selecionarConta(3);
        mov.salvar();
        assertTrue(mov.elementoEstaVisivel("Movimentação cadastrada com sucesso"));
    }
    @Test
    public void deveAtualizarSaldoAoExcluirMovimentacao(){
        //verificar saldo "Conta para saldo" = 534,00
        assertThat("534.00", is(home.obteSaldoConta("Conta para saldo")));
        //ir para resumo
        base.clickTexto("RESUMO");
        //excluir Movimentacao 3
           resumo.excluirMovimentacao("Movimentacao 3, calculo saldo");
        //validar a mensagem "Movimentacão removida com sucesso"
         base.esperar(2000);
           resumo.elementoEstaVisivel("Movimentação removida com sucesso!");
        //voltar home
          resumo.clickTexto("HOME");
       //atualizar saldos
        home.esperar(2000);
        home.scroll(0.2,0.9);
      //verificar saldo = -1000.00
        assertThat("-1000.00", is(home.obteSaldoConta("Conta para saldo")));

    }

    @After
    public void reset(){
        base.clickTexto("HOME");
        base.clickTexto("RESET");
    }
}


