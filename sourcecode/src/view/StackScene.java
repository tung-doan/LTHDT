package view;

import controller.CreateMenuController;
import controller.PushMenuController;
import controller.SceneController;
import datastructure.Stack;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import utility.AlertUtils;
import utility.ButtonUtils;

public class StackScene {

	private Stack stack; // Instance of the Stack data structure
	private VBox currentVBox = null; // To track the current VBox displayed
	private VBox stackVisualization; // Visualization of the Stack

	public Scene createStackScene(SceneController sceneController) {
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(10));
		this.stack = new Stack(5);
		stack.createRandom(5);

		// Title
		Label title = new Label("Stack Operations");
		title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
		BorderPane.setAlignment(title, Pos.CENTER);
		root.setTop(title);

		// Operation Buttons
		HBox operationButtons = createOperationButtons(sceneController);
		root.setLeft(operationButtons);

		// Stack Visualization with ScrollPane
		stackVisualization = new VBox(10);
		stackVisualization.setAlignment(Pos.BOTTOM_CENTER);
		stackVisualization.setPadding(new Insets(5));
		stackVisualization.setPrefWidth(300);

		// ScrollPane to add scrolling capability
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setContent(stackVisualization);
		scrollPane.setFitToWidth(true);
		scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
		scrollPane.setPannable(true);

		root.setRight(scrollPane);
		updateVisualization();
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

		createButton.setOnAction(e -> {
			replaceCurrentVBox(userInteractSpace, CreateMenuController.createMenu(stack, this::updateVisualization));
		});

		pushButton.setOnAction(e -> {
			replaceCurrentVBox(userInteractSpace, PushMenuController.createPushMenu(stack, this::updateVisualization));
		});

		popButton.setOnAction(e -> {
			try {
				stack.delete();
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

		backButton.setOnAction(e -> sceneController.switchTo("Menu"));

		return userInteractSpace;
	}

	private void replaceCurrentVBox(HBox container, VBox newVBox) {
		if (currentVBox != null) {
			container.getChildren().remove(currentVBox);
		}
		container.getChildren().add(newVBox);
		currentVBox = newVBox;
	}

	private void updateVisualization() {
		stackVisualization.getChildren().clear();

		int[] elements = stack.getElements();
		int size = stack.getsize();

		for (int i = 0; i < size; i++) {
			int element = elements[size - 1 - i];

			Circle circle = new Circle(25, Color.LIGHTGREEN);
			circle.setStroke(Color.BLACK);

			Text text = new Text(String.valueOf(element));

			String positionText = "";
			if (i == 0)
				positionText = "head/" + i;
			else if (i == size - 1)
				positionText = "tail/" + i;
			Text positionLabel = new Text(positionText);
			positionLabel.setFill(Color.RED);

			VBox node = new VBox(-5);
			node.setPadding(new Insets(0));
			node.setAlignment(Pos.CENTER);

			StackPane stackPane = new StackPane(circle, text);
			node.getChildren().addAll(stackPane, positionLabel);

			stackVisualization.getChildren().add(node);
			if (i < size - 1) {
				Text arrowText = new Text("↓");
				arrowText.setStyle("-fx-font-size: 30px;");
				VBox arrow = new VBox(-10);
				arrow.setPadding(new Insets(0));
				arrow.setAlignment(Pos.CENTER);
				arrow.getChildren().add(arrowText);
				stackVisualization.getChildren().add(arrow);
			}
		}
	}
}