package controller;

import Server.DatabaseManager;
import dao.CourseDao;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import model.Course;
import org.springframework.jdbc.core.JdbcTemplate;
import store.UserStore;
import util.SceneManager;


import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    private JdbcTemplate jdbcTemplate = DatabaseManager.getInstance().getJdbcTemplate();
    private CourseDao courseDao = new CourseDao(jdbcTemplate);

    @FXML
    Label name;

    @FXML
    private TableColumn<String, String> subjectColumn, PINColumn;

    @FXML
    private TableColumn<Course, String> infoColumn;

    @FXML
    private TableView<Course> tableView;

    @FXML
    public void OnAddSecButtonClick (ActionEvent event){
        SceneManager.changeScene(event,"addSec.fxml");
    }

    public void OnLogOutBunttonCLick (ActionEvent event) {
        SceneManager.changeScene(event,"login.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        name.setText(UserStore.getUser().getName());

        subjectColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        PINColumn.setCellValueFactory(new PropertyValueFactory<>("PIN"));


        Callback<TableColumn<Course, String>, TableCell<Course, String>> cellFactory = new Callback<TableColumn<Course, String>, TableCell<Course, String>>() {
            @Override
            public TableCell call(final TableColumn<Course, String> param) {
                return new TableCell<Course, String>() {

                    final Button btn = new Button("รายละเอียด");

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            btn.setOnAction(event -> {
                                SecInfoController controller = (SecInfoController) SceneManager.changeScene(tableView, "secInfo.fxml");
                                Course course= (Course) getTableRow().getItem();
                                controller.setCourse(course);
                            });
                            setGraphic(btn);
                            setText(null);
                        }
                    }
                };
            }
        };

        infoColumn.setCellFactory(cellFactory);

        tableView.getItems().addAll(courseDao.getCourseList());
    }

}
