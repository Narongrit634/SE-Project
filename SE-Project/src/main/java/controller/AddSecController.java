package controller;

import Server.DatabaseManager;
import dao.CourseDao;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Course;
import model.SecureKeyProvider;
import org.springframework.jdbc.core.JdbcTemplate;
import store.UserStore;
import util.SceneManager;

import java.net.URL;
import java.util.ResourceBundle;


public class AddSecController implements Initializable {
    private JdbcTemplate jdbcTemplate = DatabaseManager.getInstance().getJdbcTemplate();
    private CourseDao courseDao = new CourseDao(jdbcTemplate);

    @FXML
    TextField sec,secId;

    @FXML
    Label name;

    @FXML
    public void OnCancleButtonClick (ActionEvent event){
        SceneManager.changeScene(event,"home.fxml");
    }

    public void OnSaveButtonClick (ActionEvent event){
        courseDao.addCourse(new Course(sec.getText(),secId.getText(),new SecureKeyProvider().getAlphaNumericString(),name.getText()));
        SceneManager.changeScene(event,"home.fxml");
    }

    public void OnLogOutBunttonCLick (ActionEvent event) {
        SceneManager.changeScene(event,"login.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        name.setText(UserStore.getUser().getName());
    }
}
