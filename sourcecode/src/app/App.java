package app;

import view.*;
import controller.*;
import javafx.application.Application;
import javafx.stage.Stage;

// ĐÂY LÀ CHO DE CHAY CHUONG TRINH
public class App extends Application {

    private SceneController sceneController;

    @Override
    public void start(Stage primaryStage) {
        // Initialize SceneController
        sceneController = new SceneController(primaryStage);

        // Create scenes
        MainScene mainScene = new MainScene();
        ListScene listScene = new ListScene();

        // Set up scene switching logic
        sceneController.addScene("Main", mainScene.createMainScene(sceneController));
        sceneController.addScene("List", listScene.createListScene(sceneController));

        // Set initial scene and show stage
        sceneController.switchTo("Main");
        primaryStage.setTitle("Main Application");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public SceneController getSceneController() {
        return sceneController;
    }
}