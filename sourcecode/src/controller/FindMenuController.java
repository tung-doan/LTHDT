package controller;

<<<<<<< HEAD
import javafx.geometry.Pos;
=======
import java.util.function.Consumer;

import datastructure.*;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
>>>>>>> b1ba98c4060e38691dd0804b3951d324af7d0e3f
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
<<<<<<< HEAD

public class FindMenuController {

	public static VBox createMenu() {
		VBox findMenu = new VBox(10);

		Label instructionLabel = new Label("Find an element in the list:");
		TextField elementInput = new TextField();
		elementInput.setPromptText("Enter the element to find");

		Button findButton = new Button("Find");

		findMenu.getChildren().addAll(instructionLabel, elementInput, findButton);
		findMenu.setAlignment(Pos.TOP_LEFT);

		findButton.setOnAction(e -> {
			// Placeholder for find logic
		});

		return findMenu;
	}
}
=======
import utility.AlertUtils;

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
                    AlertUtils.showAlert("Success", "Element " + element + " found at index " + index, Alert.AlertType.INFORMATION);
                } else {
                    AlertUtils.showAlert("Not Found", "Element " + element + " is not in the list.", Alert.AlertType.WARNING);
                }
            } catch (NumberFormatException ex) {
                AlertUtils.showAlert("Invalid Input", "Please enter a valid integer for the element.", Alert.AlertType.ERROR);
            }
        });

        return findMenu;
    }
}

>>>>>>> b1ba98c4060e38691dd0804b3951d324af7d0e3f
