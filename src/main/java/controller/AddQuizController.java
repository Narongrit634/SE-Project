package controller;

import Server.DatabaseManager;
import dao.QuizDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Course;
import model.Quiz;
import org.springframework.jdbc.core.JdbcTemplate;
import store.UserStore;
import util.SceneManager;

import java.net.URL;
import java.util.ResourceBundle;

public class AddQuizController implements Initializable {

    private static JdbcTemplate jdbcTemplate = DatabaseManager.getInstance().getJdbcTemplate();
    private static QuizDao quizDao = new QuizDao(jdbcTemplate);
    public Course secCourse;



    @FXML
    Label name;

    @FXML
    TextField ans1 , ans2, ans3, ans4 ;

    @FXML
    TextArea quizText;

    @FXML
    ChoiceBox<Character> scoreChoiceBox , timeChoiceBox , correctChoiceBox ;



    @FXML
    private void OnSaveQuizButtonClick(ActionEvent event){
        quizDao.addQuiz(new Quiz(quizText.getText(),ans1.getText(),ans2.getText(),ans3.getText(),ans4.getText(),scoreChoiceBox.getValue().toString(),secCourse.getPIN(),Integer.parseInt(timeChoiceBox.getValue().toString()),Integer.parseInt(correctChoiceBox.getValue().toString())));

        QuizListController quizListController = (QuizListController) SceneManager.changeScene(event,"quizList.fxml");
        quizListController.setCourse(secCourse);

    }
    public void OnLogOutBunttonCLick (ActionEvent event) {
        SceneManager.changeScene(event,"login.fxml");
    }

    @FXML
    private void OnCancleButtonClick(ActionEvent actionEvent){
        SceneManager.changeScene(actionEvent,"quizList.fxml");
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        scoreChoiceBox.getItems().addAll('1','2','3');
        timeChoiceBox.getItems().addAll('1','2','3');
        correctChoiceBox.getItems().addAll('1','2','3','4');
        name.setText(UserStore.getUser().getName());
    }

    public void setCourse(Course course) {
        secCourse = course;
    }

}
