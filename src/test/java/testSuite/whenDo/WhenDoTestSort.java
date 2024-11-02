package testSuite.whenDo;

import activities.whenDo.WhenDoCreateForm;
import activities.whenDo.WhenDoListScreen;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import session.Session;

import java.util.Date;

public class WhenDoTestSort {

    WhenDoCreateForm whenDoCreateForm = new WhenDoCreateForm();
    WhenDoListScreen whenDoListScreen = new WhenDoListScreen();

    @Test
    public void createContactTest(){
        //t1
        String tittle1 = "A";
        whenDoListScreen.addTaskButton.click();
        whenDoCreateForm.tittleTxtBox.setText(tittle1);
        whenDoCreateForm.saveButton.click();
        //t2
        String tittle2 = "T";
        whenDoListScreen.addTaskButton.click();
        whenDoCreateForm.tittleTxtBox.setText(tittle2);
        whenDoCreateForm.saveButton.click();
        //sort t1 y t2
        whenDoListScreen.sortButton.click();
        whenDoListScreen.alphabeticButton.click();

        //check t1 arriba
        whenDoListScreen.firstTaskButton.click();
        Assertions.assertEquals(tittle1,whenDoCreateForm.tittleTxtBox.getText(),
                "ERROR no se ordenaron las tareas");
    }

    @AfterEach
    public void close(){
        Session.getInstance().closeApp();
    }
}
