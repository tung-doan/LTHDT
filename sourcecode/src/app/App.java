package app;

import controller.SceneController;
import javafx.application.Application;
import javafx.stage.Stage;
import view.ListScene;
import view.MainScene;
import view.StackScene;

public class App extends Application {
	private SceneController sceneController;

	@Override
	public void start(Stage primaryStage) {
		// Initialize SceneController
		sceneController = new SceneController(primaryStage);

		// Create scenes
		MainScene mainScene = new MainScene();
		ListScene listScene = new ListScene();
		StackScene stackScene = new StackScene();

		// Set up scene switching logic
		sceneController.addScene("Main", mainScene.createMainScene(sceneController));
		sceneController.addScene("List", listScene.createListScene(sceneController));
		sceneController.addScene("Stack", stackScene.createStackScene(sceneController));

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