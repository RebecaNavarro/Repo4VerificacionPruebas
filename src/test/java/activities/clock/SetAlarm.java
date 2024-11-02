package activities.clock;

import controls.Button;
import org.openqa.selenium.By;

public class SetAlarm {

    public Button twelveButton = new Button(By
            .xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc=\"12\"]"));

    public Button thirtyButton = new Button(By
            .xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc=\"30\"]"));

    public Button pmButton = new Button(By
            .xpath("//android.widget.RadioButton[@resource-id=\"android:id/pm_label\"]"));

    public Button okButton = new Button(By.id("android:id/button1"));

}
