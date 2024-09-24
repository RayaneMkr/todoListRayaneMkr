package appli;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class StartApplication extends Application {
    private static Stage mainStage;
    @Override
    public void start(Stage stage) throws IOException {
        this.mainStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("accueil/loginView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        mainStage.setTitle("Hello!");
        mainStage.setScene(scene);
        mainStage.show();
    }
    public static void sceneConnexion(String NomDuFichier) {
        mainStage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource(NomDuFichier + ".fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
            mainStage.setTitle("Hello");
            mainStage.setScene(scene);
            mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        launch();
    }
}
