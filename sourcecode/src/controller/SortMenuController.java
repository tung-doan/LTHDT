package controller;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class SortMenuController {

    public static VBox createMenu() {
        VBox sortMenu = new VBox(10);

        Label instructionLabel = new Label("Sort the list:");
        Button ascendingButton = new Button("Sort Ascending");
        Button descendingButton = new Button("Sort Descending");
        
        sortMenu.getChildren().addAll(instructionLabel, ascendingButton, descendingButton);
        sortMenu.setAlignment(Pos.BOTTOM_CENTER);

        ascendingButton.setOnAction(e -> {
            // Placeholder for sort ascending logic
        });

        descendingButton.setOnAction(e -> {
            // Placeholder for sort descending logic
        });

        return sortMenu;
    }
}
