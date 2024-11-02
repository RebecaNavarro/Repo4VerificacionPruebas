package activities.demo;

import controls.Button;
import org.openqa.selenium.By;

public class MenuSection {

    public Button signInButton = new Button(By.xpath("//android.widget.TextView[@text=\"Sign In\"]"));

    public Button logOutButton = new Button(By.xpath("//android.widget.TextView[@text=\"Logout\"]"));

}
