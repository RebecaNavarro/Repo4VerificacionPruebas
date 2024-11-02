package testSuite.demo;

import activities.demo.MainScreen;
import activities.demo.MenuSection;
import activities.demo.SignInForm;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import session.Session;


public class DemoLoginTest {

    MainScreen mainScreen = new MainScreen();
    MenuSection menuSection = new MenuSection();
    SignInForm signInForm = new SignInForm();

    @Test
    public void verifySignInLogOutDemo() throws InterruptedException {
        mainScreen.menuButton.click();
        menuSection.signInButton.click();
        signInForm.nameButton.click();
        signInForm.nameOptionButton.click();
        signInForm.pwdButton.click();
        signInForm.pwdOptionButton.click();
        signInForm.signInButton.click();

        mainScreen.menuButton.click();
        Assertions.assertTrue(menuSection.logOutButton.isControlDisplayed(),
                "ERROR no se pudo iniciar sesión");

        menuSection.logOutButton.click();

        Thread.sleep(2000);

        mainScreen.menuButton.click();
        Assertions.assertTrue(menuSection.signInButton.isControlDisplayed(),
                "ERROR no se pudo hacer logout");
    }

    @AfterEach
    public void close(){
        Session.getInstance().closeApp();
    }

}
