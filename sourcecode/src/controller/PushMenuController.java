package controller;

import datastructure.Stack;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import utility.AlertUtils;

public class PushMenuController {

	public static VBox createPushMenu(Stack stack, Runnable updateVisualization) {

		VBox pushMenu = new VBox(10);

		Label promptLabel = new Label("Enter values to push (comma separated):");
		TextField valueField = new TextField();
		valueField.setPromptText("e.g., 42, 56, 100");

		Button goButton = new Button("Go");
		goButton.setOnAction(e -> {
			try {

				String input = valueField.getText().trim();
				String[] elements = input.split(",");

				for (String element : elements) {

					int value = Integer.parseInt(element.trim());
					stack.insert(value);
				}

				updateVisualization.run();
			} catch (NumberFormatException ex) {
				AlertUtils.showAlert("Invalid Input", "Please enter a valid comma-separated list of integers.",
						Alert.AlertType.ERROR);
			} catch (IllegalStateException ex) {
				AlertUtils.showAlert("Stack Overflow", "The stack is full. Cannot push more values.",
						Alert.AlertType.ERROR);
			}
		});

		HBox buttonBox = new HBox(10, goButton);
		buttonBox.setAlignment(Pos.CENTER);

		pushMenu.getChildren().addAll(promptLabel, valueField, buttonBox);

		return pushMenu;
	}
}
