package controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.HashMap;
// CÁI NÀY ĐỂ CHUYỂN CẢNH 
public class SceneController {
    private final Stage primaryStage;
    private final HashMap<String, Scene> scenes = new HashMap<>();

    public SceneController(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void addScene(String name, Scene scene) {
        scenes.put(name, scene);
    }

    public void switchTo(String name) {
        Scene scene = scenes.get(name);
        if (scene != null) {
            primaryStage.setScene(scene);
        } else {
            System.err.println("Scene " + name + " not found!");
        }
    }
}
