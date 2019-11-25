package controller;

import DesignPattern.Users;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HomeController {
    @FXML
    Label name;

    Users users = Users.getInstance();
    public void initialize(){
        name.setText(users.getName());
    }
}
