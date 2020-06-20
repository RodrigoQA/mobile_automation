package Pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.List;

import static core.Conexao.getDriver;

public class DragDropPage {
    private AndroidDriver<MobileElement> driver;

    public DragDropPage(AndroidDriver<MobileElement> driver) {
    }

    public void arrastar(String origem, String destino) {
        MobileElement inicil = getDriver().findElement(By.xpath("//*[@text='" + origem + "']"));
        MobileElement fim = getDriver().findElement(By.xpath("//*[@text='" + destino + "']"));

        new TouchAction(getDriver())
                .longPress(inicil)
                .moveTo(fim)
                .release()
                .perform();
    }
    public String[] obterLista(){
        List<MobileElement> elements = getDriver().findElements(By.className("android.widget.TextView"));
        String[] retorno = new String[elements.size()];
        for (int i = 0; i < elements.size(); i++) {
            retorno[i] = elements.get(i).getText();
                    }
        return retorno;

    }
}
