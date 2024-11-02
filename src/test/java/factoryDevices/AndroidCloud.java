package factoryDevices;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AndroidCloud implements  IDevice {


    String userName ="";
    String accessKey ="";


    @Override
    public AppiumDriver create() {
        DesiredCapabilities options = new DesiredCapabilities();
        options.setCapability("appium:app", "bs://sample.app");
        options.setCapability("appium:deviceName", "Samsung Galaxy S22 Ultra");
        options.setCapability("appium:platformVersion", "12.0");
        AppiumDriver driver = null;
        try {
            driver = new AndroidDriver(new URL(String.format("https://%s:%s@hub.browserstack.com/wd/hub", userName , accessKey)), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return driver;
    }
}

