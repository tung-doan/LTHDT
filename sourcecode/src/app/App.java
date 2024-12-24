package app;

import controller.SceneController;
import javafx.application.Application;
import javafx.stage.Stage;
import utility.AlertUtils;
import view.HelpScene;
import view.ListScene;
import view.MenuScene;
import view.QueueScene;
import view.StackScene;

public class App extends Application {

	private SceneController sceneController;

	@Override
	public void start(Stage primaryStage) {
		// Initialize SceneController
		sceneController = new SceneController(primaryStage);

		// Create scenes
		MenuScene menuScene = new MenuScene();
		ListScene listScene = new ListScene();
		StackScene stackScene = new StackScene();
		QueueScene queueScene = new QueueScene();

		// Set up scene switching logic
		sceneController.addScene("Menu", menuScene.createMenuScene(sceneController, primaryStage));
		sceneController.addScene("List", listScene.createListScene(sceneController));
		sceneController.addScene("Stack", stackScene.createStackScene(sceneController));
		sceneController.addScene("Queue", queueScene.createQueueScene(sceneController));
		sceneController.addScene("Help", HelpScene.createHelpScene(sceneController));

		// Close promt
		primaryStage.setOnCloseRequest(event -> {
			// Show confirmation dialog
			boolean confirmed = AlertUtils.showConfirmationDialog("Exit Confirmation",
					"Are you sure you want to exit?\n");

			if (!confirmed) {
				event.consume(); // Prevent the window from closing
			}
		});

		// Set initial scene and show stage
		sceneController.switchTo("Menu");
		primaryStage.setTitle("Data Structure Operations");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public SceneController getSceneController() {
		return sceneController;
	}
}
