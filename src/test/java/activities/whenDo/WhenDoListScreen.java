package activities.whenDo;

import controls.Button;
import controls.Label;
import org.openqa.selenium.By;

public class WhenDoListScreen {
    public Button addTaskButton = new Button(By.id("com.vrproductiveapps.whendo:id/fab"));
    public Label tittleLabel = new Label(By.id("com.vrproductiveapps.whendo:id/home_list_item_text"));
    public Label noteLabel = new Label(By.id("com.vrproductiveapps.whendo:id/home_list_item_text2"));
    public Button taskButton = new Button(By.xpath("//android.widget.ListView[@resource-id=\"com.vrproductiveapps.whendo:id/notesList\"]/android.view.ViewGroup/android.widget.LinearLayout"));

    public Label noTasksLabel = new Label(By.id("com.vrproductiveapps.whendo:id/noNotesText"));
}
