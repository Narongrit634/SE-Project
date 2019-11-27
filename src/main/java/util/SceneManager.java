package util;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {
    public static Object changeScene(ActionEvent event, String fileName) {
        return changeScene((Node) event.getSource(), fileName);
    }

    public static Object changeScene(MouseEvent mouseEvent, String fileName) {
        return changeScene((Node) mouseEvent.getSource(), fileName);
    }

    public static Object changeScene(Node node, String fileName) {
        return changeScene((Stage) node.getScene().getWindow(), fileName);
    }

    private static Object changeScene(Stage stage, String fileName) {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/"+fileName));
            Scene page = new Scene(loader.load());
            stage.setScene(page);
            stage.show();
            return loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
