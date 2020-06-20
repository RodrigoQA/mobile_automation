package Pages;

import org.openqa.selenium.By;

import java.util.Set;

import static core.Conexao.getDriver;

public class WebViewPage {

    private By email = By.id("email");
    private By senha = By.id("senha");
    private By btnEntrar = By.xpath("//button[@type='submit']");
    private By messagem = By.cssSelector(".alert-success");

    public void entrarContextWeb(){
        Set<String> contextHandles = getDriver().getContextHandles();
       // for (String valor: contextHandles){ //capturar o contexto
        //    System.out.println(valor); }
        getDriver().context((String) contextHandles.toArray()[1]); // 0 para NATIVE_APP e 1 para WEBVIEW_com.ctappium
    }
    public void sairContextWeb(){
        Set<String> contextHandles = getDriver().getContextHandles();
        // for (String valor: contextHandles){ //capturar o contexto
        //    System.out.println(valor); }
        getDriver().context((String) contextHandles.toArray()[0]); // 0 para NATIVE_APP e 1 para WEBVIEW_com.ctappium
    }

    public void setEmail(String seuEmail){
        getDriver().findElement(email).sendKeys(seuEmail);
    }
    public void setSenha(String suaSenha){
        getDriver().findElement(senha).sendKeys(suaSenha);
    }
    public void Entrar(){
        getDriver().findElement(btnEntrar).click();
    }
    public String obterMensagem(){
        return getDriver().findElement(messagem).getText();
    }
}
