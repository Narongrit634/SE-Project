package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class RegisterController {
    @FXML
    Label alert;
    @FXML
    TextField fullname,username,email;
    @FXML
    PasswordField password,re_pass;
    @FXML Hyperlink back;
    @FXML Button register;

    public void onHandleBack(ActionEvent actionEvent){
        back = (Hyperlink) actionEvent.getSource();
        Stage stage =(Stage)back.getScene().getWindow();
        FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("/login.fxml"));
        try{
            Scene scene = new Scene((Parent) fxmlLoader.load(), 800, 600);
            scene.getStylesheets().add("stylesheet.css");
            stage.setScene(scene);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void onRegister(ActionEvent actionEvent){
        if (username.getText().equals("") || password.getText().equals("") || re_pass.getText().equals("") || email.getText().equals("") || fullname.getText().equals("")){
            alert.setVisible(true);
        }
        else{
            Alert dg = new Alert(Alert.AlertType.CONFIRMATION);
            dg.setTitle("Registration");
            dg.setHeaderText("Are you sure to register account?");
            dg.setContentText("OK to register");
            Optional<ButtonType> result = dg.showAndWait();
            ButtonType button = result.orElse(ButtonType.CANCEL);

            if (button == ButtonType.OK){
                register = (Button) actionEvent.getSource();
                Stage stage =(Stage)back.getScene().getWindow();
                FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("/login.fxml"));
                try{
                    stage.setScene(new Scene((Parent) fxmlLoader.load(),800,600));
                    stage.show();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void initialize(){
        alert.setVisible(false);
    }

}
