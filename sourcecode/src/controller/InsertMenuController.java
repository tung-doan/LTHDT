package controller;

import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.util.function.Consumer;

import datastructure.List;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;
import utility.AlertUtils;

public class InsertMenuController {
	public static VBox createMenu(List list, Runnable updateVisualization, Consumer<Integer> highlightElement) {
		VBox insertMenu = new VBox(10);

		Label elementsLabel = new Label("Enter an element");
		TextField elementInput = new TextField();
		Label positionLabel = new Label("Enter the position");
		TextField positionInput = new TextField();

		Button confirmButton = new Button("Confirm");

		insertMenu.getChildren().addAll(elementsLabel, elementInput, positionLabel, positionInput, confirmButton);
		insertMenu.setAlignment(Pos.TOP_LEFT);
		insertMenu.setPrefWidth(150);
		insertMenu.setPrefHeight(200);

		confirmButton.setOnAction(e -> {
			try {
				int element = Integer.parseInt(elementInput.getText());
				int index = -1;

				if (!positionInput.getText().isEmpty()) {
					index = Integer.parseInt(positionInput.getText());
					list.insertAt(index, element);
					updateVisualization.run();
					AlertUtils.showAlert("Success", "Element inserted at position " + index,
							Alert.AlertType.INFORMATION);
				} else {
					index = list.getSize();
					list.insert(element);
					updateVisualization.run();
					AlertUtils.showAlert("Success", "Element inserted at the end.", Alert.AlertType.INFORMATION);
				}
				highlightElement.accept(index);
			} catch (NumberFormatException ex) {
				AlertUtils.showAlert("Invalid Input", "Please enter a valid integer for the element and position.",
						Alert.AlertType.ERROR);
			} catch (IndexOutOfBoundsException ex) {
				AlertUtils.showAlert("Invalid Position", ex.getMessage(), Alert.AlertType.ERROR);
			}
		});

		return insertMenu;
	}
}
