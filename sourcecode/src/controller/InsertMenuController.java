package controller;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class InsertMenuController {

	public static VBox createMenu() {
		VBox insertMenu = new VBox(10);

		Label instructionLabel = new Label("Insert an element into the list:");
		TextField elementInput = new TextField();
		elementInput.setPromptText("Enter the element");
		TextField positionInput = new TextField();
		positionInput.setPromptText("Enter the position");

		Button confirmButton = new Button("Insert");

		insertMenu.getChildren().addAll(instructionLabel, elementInput, positionInput, confirmButton);
		insertMenu.setAlignment(Pos.TOP_LEFT);

		confirmButton.setOnAction(e -> {
			// Placeholder for insert logic
		});

		return insertMenu;
	}
}