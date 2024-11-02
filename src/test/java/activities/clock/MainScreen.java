package activities.clock;

import controls.Button;
import controls.Label;
import org.openqa.selenium.By;

public class MainScreen {

    public Button goToAlarmButton = new Button(By
            .xpath("//android.widget.TextView[@text=\"ALARM\"]"));

    //pantalla alarma
    public Button addAlarmButton = new Button(By
            .id("com.google.android.deskclock:id/fab"));

    public Button collapseInfoButton = new Button(By
            .xpath("//android.widget.ImageButton[@content-desc=\"Collapse alarm\"]"));

    public Label alarmLabel = new Label(By
            .id("com.google.android.deskclock:id/snackbar_text"));

}
