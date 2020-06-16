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
        desiredCapabilities.setCapability("deviceName", "RX8M9095P7F");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
      //  desiredCapabilities.setCapability("appActivity", "com.android.packageinstaller.permission.ui.GrantPermissionsActivity");
        desiredCapabilities.setCapability("autoGrantPermissions",true);
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\devOps\\Cursos\\automacao\\appium\\src\\main\\resources\\CTAppium.apk");
        System.out.println("Conectando Mobile...");
        try {
            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


    }
    public static void close(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }
}



