package controller;

import Server.DatabaseManager;
import dao.QuizDao;
import dao.SkillDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Course;
import model.Quiz;
import model.Skill;
import org.springframework.jdbc.core.JdbcTemplate;
import store.UserStore;
import util.SceneManager;

import java.net.URL;
import java.util.ResourceBundle;

public class QuizListController implements Initializable {

    private JdbcTemplate jdbcTemplate = DatabaseManager.getInstance().getJdbcTemplate();
    private QuizDao quizDao = new QuizDao(jdbcTemplate);
    private SkillDao skillDao = new SkillDao(jdbcTemplate);
    public Course secCourse;

    @FXML
    private TableColumn<String, String> quizColumn, timeColumn,pointColumn,skillColumn,desSkillColumn,usePointColumn;

    @FXML
    Label name,secName;

    @FXML
    private TableView<Quiz> table1;

    @FXML
    private TableView<Skill> table2;

    @FXML
    private void OnHomeLableClick(MouseEvent event){

        SceneManager.changeScene(event,"home.fxml");
    }

    @FXML
    private void OnMemberLableClick(MouseEvent event){
        SecInfoController secInfoController = (SecInfoController) SceneManager.changeScene(event,"secInfo.fxml");
        secInfoController.setCourse(secCourse);
    }

    @FXML
    private void OnAddQuizButtonClick(ActionEvent event){

        AddQuizController addQuizController = (AddQuizController) SceneManager.changeScene(event,"addQuiz.fxml");
        addQuizController.setCourse(secCourse);
    }

    public void OnLogOutBunttonCLick (ActionEvent event) {
        SceneManager.changeScene(event,"login.fxml");
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        name.setText(UserStore.getUser().getName());

        quizColumn.setCellValueFactory(new PropertyValueFactory<>("question"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        pointColumn.setCellValueFactory(new PropertyValueFactory<>("point"));
        skillColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        desSkillColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        usePointColumn.setCellValueFactory(new PropertyValueFactory<>("point"));





    }

    public void setCourse(Course course) {
        secCourse = course;

        secName.setText(course.getName());

        table1.getItems().addAll(quizDao.getQuizList(course.getPIN()));
        table2.getItems().addAll(skillDao.getSkillList());

        System.out.println(course.getPIN());
    }
}
