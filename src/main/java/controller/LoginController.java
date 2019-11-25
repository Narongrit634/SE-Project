package controller;

import Server.Connection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
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
        if (username.getText().equals("") || password.getText().equals("")){
            alert.setVisible(true);
        }
        else{
            if(Connection.isLogin(username.getText(),password.getText())){
                login = (Button) actionEvent.getSource();
                Stage stage =(Stage)login.getScene().getWindow();
                FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("/home.fxml"));
                try{
                    Scene scene = new Scene((Parent) fxmlLoader.load(), 800, 600);
                    scene.getStylesheets().add("org/kordamp/bootstrapfx/bootstrapfx.css");
                    stage.setScene(scene);
                    stage.show();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            else{
                alert.setText("Wrong Username or Password");
                alert.setVisible(true);
            }
        }

    }

    public void onHandleRegister(ActionEvent actionEvent){
        register = (Hyperlink) actionEvent.getSource();
        Stage stage =(Stage)register.getScene().getWindow();
        FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("/register.fxml"));
        try{
            Scene scene = new Scene((Parent) fxmlLoader.load(), 800, 600);
            scene.getStylesheets().add("org/kordamp/bootstrapfx/bootstrapfx.css");
            stage.setScene(scene);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void initialize(){
        alert.setVisible(false);

    }
}
