package activities.demo;

import controls.Button;
import org.openqa.selenium.By;

public class SignInForm {

    public Button nameButton = new Button(By.xpath("//android.widget.Spinner[@content-desc=\"username-input\"]"));

    public Button nameOptionButton = new Button(By
            .xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"demouser\"]"));

    public Button pwdButton = new Button(By.xpath("//android.widget.Spinner[@content-desc=\"password-input\"]"));

    public Button pwdOptionButton = new Button(By
            .xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"testingisfun99\"]"));

    public Button signInButton = new Button(By
            .xpath("//android.view.ViewGroup[@content-desc=\"login-btn\"]"));


}
