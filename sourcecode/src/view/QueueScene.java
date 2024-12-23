package view;

import controller.CreateMenuController;
import controller.SceneController;
import datastructure.Queue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import utility.AlertUtils;
import utility.ButtonUtils;

public class QueueScene extends BaseScene {

	private Queue queue; // Instance of the Queue data structure

	public Scene createQueueScene(SceneController sceneController) {
		this.queue = new Queue(5);
		queue.createRandom(5);
		Scene scene = createBaseScene(sceneController, "Queue Operations");
		updateVisualization();
		return scene;
	}

	@Override
	protected HBox createOperationButtons(SceneController sceneController) {
		VBox buttonLayout = new VBox(10);
		buttonLayout.setPadding(new Insets(10));
		buttonLayout.setPrefWidth(100);
		buttonLayout.setPrefHeight(400);
		buttonLayout.setAlignment(Pos.TOP_LEFT);

		Button createButton = ButtonUtils.createStyledButton("Create");
		Button enqueueButton = ButtonUtils.createStyledButton("Enqueue");
		Button dequeueButton = ButtonUtils.createStyledButton("Dequeue");
		Button frontButton = ButtonUtils.createStyledButton("Front");
		Button backButton = ButtonUtils.createStyledButton("Back");

		buttonLayout.getChildren().addAll(createButton, enqueueButton, dequeueButton, frontButton, backButton);

		HBox userInteractSpace = new HBox(10);
		userInteractSpace.setPadding(new Insets(10));
		userInteractSpace.setAlignment(Pos.TOP_LEFT);
		userInteractSpace.getChildren().add(buttonLayout);

		createButton.setOnAction(e -> {
			replaceCurrentVBox(userInteractSpace, CreateMenuController.createMenu(queue, this::updateVisualization));
		});

		enqueueButton.setOnAction(e -> {
			VBox enqueueMenu = new VBox(10);
			enqueueMenu.setPadding(new Insets(10));
			enqueueMenu.setAlignment(Pos.TOP_LEFT);
			enqueueMenu.setPrefWidth(300);
			enqueueMenu.setPrefHeight(300);

			Label titleLabel = new Label("Enqueue Element");

			TextField elementField = new TextField();
			elementField.setPromptText("Enter element");

			Button enqueueConfirmButton = ButtonUtils.createStyledButton("Enqueue");
			enqueueConfirmButton.setOnAction(event -> {
				try {
					String input = elementField.getText().trim();
					String[] elements = input.split(",");
					for (String element : elements) {

						int value = Integer.parseInt(element.trim());
						queue.insert(value);
					}
					updateVisualization();
					AlertUtils.showAlert("Enqueue Success", "Element enqueued successfully.", AlertType.INFORMATION);
				} catch (NumberFormatException ex) {
					AlertUtils.showAlert("Error", "Please enter a valid integer.", AlertType.ERROR);
				}
			});

			enqueueMenu.getChildren().addAll(titleLabel, elementField, enqueueConfirmButton);

			replaceCurrentVBox(userInteractSpace, enqueueMenu);
		});

		dequeueButton.setOnAction(e -> {
			try {
				queue.dequeue();
				updateVisualization();
			} catch (IllegalStateException ex) {
				AlertUtils.showAlert("Error", "Queue is empty. Cannot dequeue an element.", Alert.AlertType.ERROR);
			}
		});

		frontButton.setOnAction(e -> {
			try {
				int frontValue = queue.peek();
				AlertUtils.showAlert("Front Element", "The front element is: " + frontValue,
						Alert.AlertType.INFORMATION);
			} catch (IllegalStateException ex) {
				AlertUtils.showAlert("Error", "Queue is empty. No front element.", Alert.AlertType.ERROR);
			}
		});

		backButton.setOnAction(e -> sceneController.switchTo("Menu"));

		return userInteractSpace;
	}

	private void updateVisualization() {
		visualizationBox.getChildren().clear();

		int[] elements = queue.getElements();
		int size = queue.getSize();

		for (int i = 0; i < size; i++) {
			int element = elements[(queue.getFront() + i) % queue.getCapacity()];

			Circle circle = new Circle(25, Color.PINK);
			circle.setStroke(Color.BLACK);

			Text text = new Text(String.valueOf(element));

			String positionText = "";
			if (i == 0)
				positionText = "front/" + i;
			else if (i == size - 1)
				positionText = "bottom/" + i;
			Text positionLabel = new Text(positionText);
			positionLabel.setFill(Color.ORANGE);

			VBox node = new VBox(0);
			node.setPadding(new Insets(0));
			node.setAlignment(Pos.CENTER);

			StackPane stackPane = new StackPane(circle, text);
			node.getChildren().addAll(stackPane, positionLabel);

			visualizationBox.getChildren().add(node);

			if (i < size - 1) {
				Text arrowText = new Text("↑");
				arrowText.setStyle("-fx-font-size: 40px;");
				VBox arrow = new VBox(-10);
				arrow.setPadding(new Insets(-15));
				arrow.setAlignment(Pos.CENTER);
				arrow.getChildren().add(arrowText);
				visualizationBox.getChildren().add(arrow);
			}
		}
	}
}