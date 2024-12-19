package controller;

<<<<<<< HEAD
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
=======
import datastructure.List;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import utility.AlertUtils;

public class DeleteMenuController {

    public static VBox createMenu(List list, Runnable updateVisualization) {
        VBox deleteMenu = new VBox(10);

        Label instructionLabel = new Label("Delete by element or position:");
        TextField inputField = new TextField();

        // Radio Buttons to select mode
        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton deleteByElement = new RadioButton("Delete by Element");
        RadioButton deleteByPosition = new RadioButton("Delete by Position");
        deleteByElement.setToggleGroup(toggleGroup);
        deleteByPosition.setToggleGroup(toggleGroup);
        deleteByElement.setSelected(true); 

        Button confirmButton = new Button("Delete");

        deleteMenu.getChildren().addAll(instructionLabel, inputField, deleteByElement, deleteByPosition, confirmButton);
        deleteMenu.setAlignment(Pos.TOP_LEFT);

        confirmButton.setOnAction(e -> {
            String input = inputField.getText().trim();
            if (input.isEmpty()) {
                AlertUtils.showAlert("Invalid Input", "Please enter a value to delete.", Alert.AlertType.ERROR);
                return;
            }

            try {
                int value = Integer.parseInt(input);

                if (deleteByPosition.isSelected()) {
                    // Delete by position
                    list.deleteAt(value);
                    updateVisualization.run();

                    AlertUtils.showAlert("Success", "Element at position " + value + " deleted successfully.", Alert.AlertType.INFORMATION);
                } else {
                    // Delete by element
                    list.delete(value);
                    updateVisualization.run();
                    AlertUtils.showAlert("Success", "Element " + value + " deleted successfully.", Alert.AlertType.INFORMATION);
                }

            } catch (NumberFormatException ex) {
                AlertUtils.showAlert("Invalid Input", "Please enter a valid integer.", Alert.AlertType.ERROR);
            } catch (IndexOutOfBoundsException ex) {
                AlertUtils.showAlert("Invalid Position", ex.getMessage(), Alert.AlertType.ERROR);
            } catch (IllegalArgumentException ex) {
                AlertUtils.showAlert("Not Found", ex.getMessage(), Alert.AlertType.WARNING);
            }
        });

        return deleteMenu;
    }
}
>>>>>>> b1ba98c4060e38691dd0804b3951d324af7d0e3f
