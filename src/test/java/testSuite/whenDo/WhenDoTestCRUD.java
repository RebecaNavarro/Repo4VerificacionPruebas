package testSuite.whenDo;

import activities.whenDo.DeleteAlert;
import activities.whenDo.WhenDoCreateForm;
import activities.whenDo.WhenDoListScreen;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import session.Session;

import java.util.Date;

public class WhenDoTestCRUD {

    WhenDoCreateForm whenDoCreateForm = new WhenDoCreateForm();
    WhenDoListScreen whenDoListScreen = new WhenDoListScreen();
    DeleteAlert deleteAlert = new DeleteAlert();

    @Test
    public void crudTaskTest(){
        String tittle = "Tarea " + new Date().getTime();
        String note = "Nota A";
        whenDoListScreen.addTaskButton.click();
        whenDoCreateForm.tittleTxtBox.setText(tittle);
        whenDoCreateForm.noteTxtBox.setText(note);
        whenDoCreateForm.saveButton.click();
        Assertions.assertAll("ERROR la tarea no se pudo crear",
                () -> Assertions.assertEquals(tittle, whenDoListScreen.tittleLabel.getText(),
                        "El título no coincide"),
                () -> Assertions.assertEquals(note, whenDoListScreen.noteLabel.getText(),
                        "La nota no coincide")
        );

        String tittleUpdate = "Task " + new Date().getTime();
        String noteUpdate = "Note A";
        whenDoListScreen.taskButton.click();
        whenDoCreateForm.tittleTxtBox.setText(tittleUpdate);
        whenDoCreateForm.noteTxtBox.setText(noteUpdate);
        whenDoCreateForm.saveButton.click();
        Assertions.assertAll("ERROR la tarea no se pudo actualizar",
                () -> Assertions.assertEquals(tittleUpdate, whenDoListScreen.tittleLabel.getText(),
                        "El título no coincide"),
                () -> Assertions.assertEquals(noteUpdate, whenDoListScreen.noteLabel.getText(),
                        "La nota no coincide")
        );
//        Assertions.assertEquals(tittleUpdate,whenDoListScreen.tittleLabel.getText(),
//                "ERROR la tarea no se pudo actualizar");
//        Assertions.assertEquals(noteUpdate,whenDoListScreen.noteLabel.getText(),
//                "ERROR la tarea no se pudo actualizar");

        whenDoListScreen.taskButton.click();
        whenDoCreateForm.deleteButton.click();
        deleteAlert.chooseDeleteButton.click();
        Assertions.assertTrue(whenDoListScreen.noTasksLabel.isControlDisplayed(),
                "ERROR la tarea no se pudo eliminar");
    }

//    @Test
//    public void updateTaskTest(){
//        String tittle = "Task " + new Date().getTime();
//        String note = "Note A";
//        whenDoListScreen.taskButton.click();
//        whenDoCreateForm.tittleTxtBox.setText(tittle);
//        whenDoCreateForm.noteTxtBox.setText(note);
//        whenDoCreateForm.saveButton.click();
//        Assertions.assertEquals(tittle,whenDoListScreen.tittleLabel.getText(),
//                "ERROR la tarea no se pudo actualizar");
//        Assertions.assertEquals(note,whenDoListScreen.noteLabel.getText(),
//                "ERROR la tarea no se pudo actualizar");
//    }

//    @Test
//    public void deleteTaskTest(){
//        whenDoListScreen.taskButton.click();
//        whenDoCreateForm.deleteButton.click();
//        deleteAlert.chooseDeleteButton.click();
//        Assertions.assertTrue(whenDoListScreen.noTasksLabel.isControlDisplayed(),
//                "ERROR la tarea no se pudo eliminar");
//    }

    @AfterEach
    public void close(){
        Session.getInstance().closeApp();
    }
}
