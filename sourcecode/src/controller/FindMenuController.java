package controller;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

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

