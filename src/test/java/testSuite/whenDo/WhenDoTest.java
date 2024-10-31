package testSuite.whenDo;

import activities.contacts.ContactCreateForm;
import activities.contacts.ContactDetailScreen;
import activities.contacts.ContactListScreen;
import activities.contacts.SyncAlert;
import activities.whenDo.WhenDoCreateForm;
import activities.whenDo.WhenDoDetailScreen;
import activities.whenDo.WhenDoListScreen;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import session.Session;

import java.util.Date;

public class WhenDoTest {

    WhenDoCreateForm whenDoCreateForm = new WhenDoCreateForm();
    WhenDoDetailScreen whenDoDetailScreen = new WhenDoDetailScreen();
    WhenDoListScreen whenDoListScreen = new WhenDoListScreen();

    @Test
    public void createContactTest(){
        String tittle = "Tarea "+new Date().getTime();
        whenDoListScreen.addTaskButton.click();
        whenDoCreateForm.tittleTxtBox.setText(tittle);
        whenDoCreateForm.saveButton.click();
        Assertions.assertEquals(tittle,whenDoDetailScreen.tittleLabel.getText(),
                "ERROR la tarea no se pudo crear");
    }

    @AfterEach
    public void close(){
        Session.getInstance().closeApp();
    }
}
