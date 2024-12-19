package controller;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import sourcecode.src.datastructure.Datastructure;
import sourcecode.src.datastructure.List;
import sourcecode.src.datastructure.Queue;
import sourcecode.src.utility.AlertUtils;

public class CreateMenuController {

	public static VBox createMenu(Datastructure datastructure, Runnable updateVisualization) {
		VBox createMenu = new VBox(10);

		Label sizeLabel = new Label("Enter the size: ");
		TextField sizeInput = new TextField();
		Button randomButton = new Button("Random");
		Button userDefinedButton = new Button("User Defined");

		createMenu.getChildren().addAll(sizeLabel, sizeInput, randomButton, userDefinedButton);
		createMenu.setAlignment(Pos.TOP_LEFT);
		createMenu.setPrefWidth(150);
		createMenu.setPrefHeight(200);

		randomButton.setOnAction(e -> {
			try {
				int size = Integer.parseInt(sizeInput.getText());
				if (datastructure instanceof List) {
					((List) datastructure).createRandom(size);
				} else if (datastructure instanceof Queue) {
					for (int i = 0; i < size; i++) {
						((Queue) datastructure).enqueue((int) (Math.random() * 100));
					}
				}
				updateVisualization.run();
			} catch (NumberFormatException ex) {
				AlertUtils.showAlert("Invalid Input", "Please enter a valid integer for the size.",
						Alert.AlertType.ERROR);
			}
		});

		final boolean[] userDefinedAdded = { false };
		userDefinedButton.setOnAction(e -> {
			if (!userDefinedAdded[0]) {
				Label userDefinedLabel = new Label("Enter the elements (comma-separated):");
				TextField userDefinedInput = new TextField();
				Button confirmButton = new Button("Create");

				createMenu.getChildren().addAll(userDefinedLabel, userDefinedInput, confirmButton);
				userDefinedAdded[0] = true;

				confirmButton.setOnAction(event -> {
					String input = userDefinedInput.getText();
					String[] elements = input.split(",");

					try {
						datastructure.setCapacity(elements.length);
						datastructure.create(); // Reset the structure

						for (String element : elements) {
							int value = Integer.parseInt(element.trim());
							if (datastructure instanceof List) {
								((List) datastructure).insert(value);
							} else if (datastructure instanceof Queue) {
								((Queue) datastructure).enqueue(value);
							}
						}

						updateVisualization.run();
						AlertUtils.showAlert("Success", "Structure created successfully.", Alert.AlertType.INFORMATION);
					} catch (NumberFormatException ex) {
						AlertUtils.showAlert("Invalid Input", "Please enter valid comma-separated integers.",
								Alert.AlertType.ERROR);
					}
				});
			}
		});

		return createMenu;
	}
}