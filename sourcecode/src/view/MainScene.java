package view;

import java.awt.Button;

import controller.SceneController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import utility.ButtonUtils;

public class MainScene {
	public Scene createMainScene(SceneController sceneController) {
		// Create the root layout
		VBox rootLayout = new VBox(20);
		rootLayout.setAlignment(Pos.CENTER);

		// Create buttons and set their actions
		Button goToListButton = ButtonUtils.createStyledButton("Go to List Operations");
		goToListButton.setOnAction(e -> sceneController.switchTo("List"));

		Button goToStackButton = ButtonUtils.createStyledButton("Go to Stack Operations");
		goToStackButton.setOnAction(e -> sceneController.switchTo("Stack"));

		// Add buttons to the layout
		rootLayout.getChildren().addAll(goToListButton, goToStackButton);

		// Create and return the scene
		return new Scene(rootLayout, 800, 600);
	}
}