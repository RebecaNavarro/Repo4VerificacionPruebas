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

public class ContactTest {

    AppiumDriver driver;

    @BeforeEach
    public void openApp() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:deviceName","UPBv9");
        capabilities.setCapability("appium:platformVersion","9.0");
        capabilities.setCapability("appium:appPackage","com.android.contacts");
        capabilities.setCapability("appium:appActivity","com.android.contacts.activities.PeopleActivity");
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
        driver.findElement(By.id("com.android.contacts:id/floating_action_button")).click();

        //cancel
        driver.findElement(By.id("com.android.contacts:id/left_button")).click();

        String firstName = "Prueba1";
        String lastName = "2";
        //first name
        driver.findElement(By.xpath("//android.widget.EditText[@text=\"First name\"]")).sendKeys(firstName);
        //last name
        driver.findElement(By.xpath("//android.widget.EditText[@text=\"Last name\"]")).sendKeys(lastName);

        String number = "12345678";
        //number
        driver.findElement(By.xpath("//android.widget.EditText[@text=\"Phone\"]")).sendKeys(number);

        //options
        driver.findElement(By.xpath("//android.widget.Spinner[@content-desc=\"Phone\"]")).click();

        //put home
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Home\"]")).click();

        // save
        driver.findElement(By.id("com.android.contacts:id/editor_menu_save_button")).click();

        Thread.sleep(5000);

        String expected = firstName + " " + lastName;

        String actual = driver
                .findElement(By.id("com.android.contacts:id/large_title"))
                .getText();

        Assertions.assertEquals(expected,actual,"ERROR no se creo el contacto de manera correcta");

    }

}
/*
{
  "appium:deviceName": "UPBv9",
  "appium:platformVersion": "9.0",
  "appium:appPackage": "com.vrproductiveapps.whendo",
  "appium:appActivity": "com.vrproductiveapps.whendo.ui.HomeActivity",
  "platformName": "Android",
  "appium:automationName": "uiautomator2"
}
*/
