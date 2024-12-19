package view;

import controller.SceneController;
import datastructure.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import utility.*;

public class StackScene {

	private Stack stack; // Instance of the Stack data structure
	private VBox stackVisualization; // Visualization of the Stack

	public StackScene() {
		// Initialize the Stack
		this.stack = new Stack(10); // Default size 10
	}

	public Scene createStackScene(SceneController sceneController) {
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(10));

		// Title
		Label title = new Label("Stack Operations");
		title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
		BorderPane.setAlignment(title, Pos.CENTER);
		root.setTop(title);

		// Operation Buttons
		HBox operationButtons = createOperationButtons(sceneController);
		root.setLeft(operationButtons);

		// Stack Visualization
		stackVisualization = new VBox(10);
		stackVisualization.setAlignment(Pos.BOTTOM_CENTER);
		stackVisualization.setPadding(new Insets(5));
		stackVisualization.setPrefWidth(300);
		stackVisualization.setPrefHeight(400);
		root.setCenter(stackVisualization);

		return new Scene(root, 1000, 600);
	}

	private HBox createOperationButtons(SceneController sceneController) {
		VBox buttonLayout = new VBox(10);
		buttonLayout.setPadding(new Insets(10));
		buttonLayout.setPrefWidth(100);
		buttonLayout.setPrefHeight(400);
		buttonLayout.setAlignment(Pos.TOP_LEFT);

		Button createButton = ButtonUtils.createStyledButton("Create");
		Button pushButton = ButtonUtils.createStyledButton("Push");
		Button popButton = ButtonUtils.createStyledButton("Pop");
		Button topButton = ButtonUtils.createStyledButton("Top");
		Button backButton = ButtonUtils.createStyledButton("Back");

		buttonLayout.getChildren().addAll(createButton, pushButton, popButton, topButton, backButton);

		HBox userInteractSpace = new HBox(10);
		userInteractSpace.setPadding(new Insets(10));
		userInteractSpace.setAlignment(Pos.TOP_LEFT);
		userInteractSpace.getChildren().add(buttonLayout);

		// Set up button actions
		createButton.setOnAction(e -> {
			stack.create(); // Reinitialize stack
			updateVisualization();
		});

		pushButton.setOnAction(e -> {
			int newValue = (int) (Math.random() * 100); // Generate random value
			stack.push(newValue);
			updateVisualization();
		});

		popButton.setOnAction(e -> {
			try {
				stack.pop();
				updateVisualization();
			} catch (IllegalStateException ex) {
				AlertUtils.showAlert("Error", "Stack is empty. Cannot pop an element.", Alert.AlertType.ERROR);
			}
		});

		topButton.setOnAction(e -> {
			try {
				int topValue = stack.peek();
				AlertUtils.showAlert("Top Element", "The top element is: " + topValue, Alert.AlertType.INFORMATION);
			} catch (IllegalStateException ex) {
				AlertUtils.showAlert("Error", "Stack is empty. No top element.", Alert.AlertType.ERROR);
			}
		});

		backButton.setOnAction(e -> sceneController.switchTo("Main"));

		return userInteractSpace;
	}

	// Method to update the visualization of the Stack
	private void updateVisualization() {
		stackVisualization.getChildren().clear();

		for (int i = stack.getsize() - 1; i >= 0; i--) {
			int element = stack.getElements()[i];
			Rectangle rectangle = new Rectangle(80, 40);
			rectangle.setFill(Color.LIGHTGREEN);
			rectangle.setStroke(Color.BLACK);

			Text text = new Text(String.valueOf(element));
			StackPane stackPane = new StackPane(rectangle, text);

			stackVisualization.getChildren().add(stackPane);
		}
	}	
}
