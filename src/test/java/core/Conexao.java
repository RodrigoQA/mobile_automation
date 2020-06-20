package core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Conexao {
    public static AndroidDriver<MobileElement> driver;
    public static AndroidDriver<MobileElement> getDriver() {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }

    public static void createDriver(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "0032410262");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
      //desiredCapabilities.setCapability("autoGrantPermissions",true);
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\devOps\\Cursos\\automacao\\appium\\src\\main\\resources\\CTAppium_1_2.apk");
        System.out.println("Conectando Mobile...");
        try {
            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }
    public static void close(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }
}



