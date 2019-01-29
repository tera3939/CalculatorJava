import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception{
        Path fxmlPath = Paths.get("src/main/resources/view/calculator.fxml");
        Parent root = FXMLLoader.load(fxmlPath.toUri().toURL());
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(new Scene(root, 338, 265));
        System.out.println(com.sun.javafx.runtime.VersionInfo.getRuntimeVersion());
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
