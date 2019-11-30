package controller;

import Server.DatabaseManager;
import dao.CourseDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Course;
import model.StudentList;
import org.springframework.jdbc.core.JdbcTemplate;
import store.UserStore;
import util.SceneManager;

import java.net.URL;
import java.util.ResourceBundle;

public class SecInfoController implements Initializable {
    private JdbcTemplate jdbcTemplate = DatabaseManager.getInstance().getJdbcTemplate();
    private CourseDao courseDao = new CourseDao(jdbcTemplate);
    public Course secCourse;

    @FXML
    Label name,secName;

    @FXML
    private TableColumn<String, String> nameStu;

    @FXML
    private TableColumn<Integer, Integer> user_id,point;

    @FXML
    private TableView<StudentList> tableStudent;

    @FXML
    private void OnHomeLableClick(MouseEvent event){

        SceneManager.changeScene(event,"home.fxml");
    }

    @FXML
    private void OnQuizLableClick(MouseEvent event){
        QuizListController quizListController = (QuizListController) SceneManager.changeScene(event,"quizList.fxml");
        quizListController.setCourse(secCourse);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        name.setText(UserStore.getUser().getName());

    }

    public void OnLogOutBunttonCLick (ActionEvent event) {
        SceneManager.changeScene(event,"login.fxml");
    }


    public void setCourse(Course course) {
        secCourse = course;
        secName.setText(course.getName());
        user_id.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        nameStu.setCellValueFactory(new PropertyValueFactory<>("nameStudent"));
        point.setCellValueFactory(new PropertyValueFactory<>("point"));
        tableStudent.getItems().addAll(courseDao.getStudentList(course.getPIN()));
    }
}
