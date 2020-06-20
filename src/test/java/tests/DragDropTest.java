package tests;

import Pages.DragDropPage;
import Pages.MenuPage;
import core.BasePage;
import core.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.junit.Test;

public class DragDropTest extends BaseTest {
    private AndroidDriver<MobileElement> driver;
    BasePage basePage = new BasePage(driver);
    MenuPage menuPage = new MenuPage(driver);
    DragDropPage dragDropPage = new DragDropPage(driver);

    private String[] estadoInicial = new String[]{"Esta", "é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "qualquer local desejado.",};
    private String[] estadoIntermediario = new String[]{ "é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "Esta","qualquer local desejado.",};
    private String[] estadoFinal = new String[]{ "Faça um clique longo,","é uma lista", "Drag em Drop!",  "e arraste para", "Esta","qualquer local desejado.",};


    @Test
    public void deveEfetuarDragDrop(){
        //acessar menu DragDropPage
        menuPage.acessarDragDrop();
        //verificar estado inicial
        basePage.esperar(1000);
        Assert.assertEquals(estadoInicial,dragDropPage.obterLista());
        //arrastar "Esta" para "e arraste para"
        dragDropPage.arrastar("Esta","e arraste para");

        //verificar estado intermediario
        Assert.assertEquals(estadoIntermediario,dragDropPage.obterLista());
        //arrastar "Faça um clique logo," para "é uma lista"
        dragDropPage.arrastar("Faça um clique longo,","é uma lista");
        //verificar estado final
        Assert.assertEquals(estadoFinal,dragDropPage.obterLista());

    }
}
