package controller;

import Server.DatabaseManager;
import dao.UserDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import store.UserStore;
import util.SceneManager;



public class LoginController {

    private JdbcTemplate jdbcTemplate = DatabaseManager.getInstance().getJdbcTemplate();
    private UserDao loginDao = new UserDao(jdbcTemplate);

    @FXML
    TextField username;
    @FXML
    PasswordField password;
    @FXML
    Hyperlink register;
    @FXML
    Button login;
    @FXML
    Label alert;

    public void onHandleLogin(ActionEvent actionEvent){
        User user = loginDao.isLogin(username.getText(), password.getText());
        if (user != null) {
            UserStore.setUser(user);
            SceneManager.changeScene(actionEvent,"home.fxml");
        } else {
            alert.setVisible(true);
            alert.setText("Wrong or can't register");
        }
    }

    public void onHandleRegister(ActionEvent actionEvent){
        SceneManager.changeScene(actionEvent,"register.fxml");
    }

    public void initialize(){
        alert.setVisible(false);

    }
}
