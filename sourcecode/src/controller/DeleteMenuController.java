package controller;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class DeleteMenuController {

	public static VBox createMenu() {
		VBox deleteMenu = new VBox(10);

		Label instructionLabel = new Label("Delete an element from the list:");
		TextField elementInput = new TextField();
		elementInput.setPromptText("Enter the element to delete");

		Button confirmButton = new Button("Delete");

		deleteMenu.getChildren().addAll(instructionLabel, elementInput, confirmButton);
		deleteMenu.setAlignment(Pos.TOP_LEFT);

		confirmButton.setOnAction(e -> {
			// Placeholder for delete logic
		});

		return deleteMenu;
	}
}