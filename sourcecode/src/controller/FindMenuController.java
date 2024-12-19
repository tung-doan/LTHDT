package controller;

import java.util.function.Consumer;

import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import sourcecode.src.datastructure.List;
import sourcecode.src.utility.AlertUtils;

public class FindMenuController {

	public static VBox createMenu(List list, Consumer<Integer> highlightElement) {
		VBox findMenu = new VBox(10);

		Label instructionLabel = new Label("Find an element in the list:");
		TextField elementInput = new TextField();
		Button findButton = new Button("Find");

		findMenu.getChildren().addAll(instructionLabel, elementInput, findButton);
		findMenu.setAlignment(Pos.TOP_LEFT);
		findMenu.setPrefWidth(150);
		findMenu.setPrefHeight(200);

		findButton.setOnAction(e -> {
			try {
				int element = Integer.parseInt(elementInput.getText());
				int index = list.find(element);

				if (index != -1) {
					highlightElement.accept(index);
					AlertUtils.showAlert("Success", "Element " + element + " found at index " + index,
							Alert.AlertType.INFORMATION);
				} else {
					AlertUtils.showAlert("Not Found", "Element " + element + " is not in the list.",
							Alert.AlertType.WARNING);
				}
			} catch (NumberFormatException ex) {
				AlertUtils.showAlert("Invalid Input", "Please enter a valid integer for the element.",
						Alert.AlertType.ERROR);
			}
		});

		return findMenu;
	}
}
