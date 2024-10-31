package activities.whenDo;

import controls.Button;
import controls.ComboBox;
import controls.TextBox;
import org.openqa.selenium.By;

public class WhenDoCreateForm {
    public TextBox tittleTxtBox = new TextBox(By.id("com.vrproductiveapps.whendo:id/noteTextTitle"));
    public Button saveButton = new Button(By.id("com.vrproductiveapps.whendo:id/saveItem"));

}
