import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/login.fxml"));
        primaryStage.setTitle("SE-Project");
        Scene scene = new Scene(root, 774, 490);
        scene.getStylesheets().add("org/kordamp/bootstrapfx/bootstrapfx.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
