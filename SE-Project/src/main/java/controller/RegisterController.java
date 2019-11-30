package controller;


import Server.DatabaseManager;
import dao.UserDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import util.SceneManager;


public class RegisterController {
    private JdbcTemplate jdbcTemplate = DatabaseManager.getInstance().getJdbcTemplate();
    private UserDao userDao = new UserDao(jdbcTemplate);


    @FXML
    Label alert;
    @FXML
    TextField name,username,email;
    @FXML
    PasswordField password,verifyPass;
    @FXML Hyperlink back;
    @FXML Button register;

    public void onHandleBack(ActionEvent actionEvent){
        SceneManager.changeScene(actionEvent,"login.fxml");
    }

    public void onRegister(ActionEvent actionEvent){
        if (password.getText().equals(verifyPass.getText())){
            userDao.register(new User(0,name.getText(),username.getText(),password.getText(),email.getText(),""));
            SceneManager.changeScene(actionEvent,"login.fxml");
        }else{
            alert.setText("Not correct Password");
            alert.setVisible(true);
            password.clear();
            verifyPass.clear();
        }

    }

    public void initialize(){
        alert.setVisible(false);
    }

}
