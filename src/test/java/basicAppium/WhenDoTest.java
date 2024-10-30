package basicAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class WhenDoTest {

    AppiumDriver driver;

    @BeforeEach
    public void openApp() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:deviceName","UPBv9");
        capabilities.setCapability("appium:platformVersion","9.0");
        capabilities.setCapability("appium:appPackage","com.vrproductiveapps.whendo");
        capabilities.setCapability("appium:appActivity","com.vrproductiveapps.whendo.ui.HomeActivity");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appium:automationName","uiautomator2");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"),capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterEach
    public void closeApp(){
        driver.quit();
    }

    @Test
    public void verifyAddition() throws InterruptedException {
        //add
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/fab")).click();
        Thread.sleep(2000);

        String tittle = "Tarea 1";
        //tittle
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys(tittle);

        //save
        driver.findElement(By.id("com.vrproductiveapps.whendo:id/saveItem")).click();

        Thread.sleep(5000);

        String expected = tittle;
        String actual = driver
                .findElement(By.id("com.vrproductiveapps.whendo:id/home_list_item_text"))
                .getText();

        Assertions.assertEquals(expected,actual,"ERROR la tarea no se pudo crear");

    }

}

