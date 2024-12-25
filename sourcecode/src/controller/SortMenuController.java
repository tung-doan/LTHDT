package controller;

import datastructure.List;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import utility.AlertUtils;

public class SortMenuController {

	public static VBox createMenu(List list, Runnable updateVisualization) {
		VBox sortMenu = new VBox(10);

		Button ascendingButton = new Button("Sort Ascending");
		Button descendingButton = new Button("Sort Descending");

		sortMenu.getChildren().addAll(ascendingButton, descendingButton);
		sortMenu.setAlignment(Pos.TOP_LEFT);

		// Sort ascending logic
		ascendingButton.setOnAction(e -> {
			try {
				list.sort(true);
				updateVisualization.run();
				AlertUtils.showAlert("Success", "The list has been sorted in ascending order.",
						Alert.AlertType.INFORMATION);
			} catch (IllegalStateException ex) {
				AlertUtils.showAlert("Error", "The list is empty. Please add elements before sorting.",
						Alert.AlertType.ERROR);
			}
		});

		// Sort descending logic
		descendingButton.setOnAction(e -> {
			try {
				list.sort(false);
				updateVisualization.run();
				AlertUtils.showAlert("Success", "The list has been sorted in descending order.",
						Alert.AlertType.INFORMATION);
			} catch (IllegalStateException ex) {
				AlertUtils.showAlert("Error", "The list is empty. Please add elements before sorting.",
						Alert.AlertType.ERROR);
			}
		});

		return sortMenu;
	}
}