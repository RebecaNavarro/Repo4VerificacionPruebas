package testSuite.clock;

import activities.clock.MainScreen;
import activities.clock.SetAlarm;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import session.Session;

public class AlarmTest {

    MainScreen mainScreen = new MainScreen();
    SetAlarm setAlarm = new SetAlarm();

    @Test
    public void createAlarmTest(){
        mainScreen.goToAlarmButton.click();
        mainScreen.addAlarmButton.click();
        setAlarm.twelveButton.click();
        setAlarm.thirtyButton.click();
        setAlarm.pmButton.click();
        setAlarm.okButton.click();

        Assertions.assertTrue(mainScreen.alarmLabel.isControlDisplayed(),
                "ERROR la alarma no se pudo crear");
    }

    @AfterEach
    public void close(){
        Session.getInstance().closeApp();
    }

}
