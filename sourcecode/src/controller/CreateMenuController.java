package controller;

import datastructure.List;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import utility.AlertUtils;

public class CreateMenuController {

    public static VBox createMenu(List list, Runnable updateVisualization) {
        VBox createMenu = new VBox(10);
        
        Label sizeLabel = new Label("Enter size of the list:");
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
                list.createRandom(size);  
                updateVisualization.run();  
            } catch (NumberFormatException ex) {
                AlertUtils.showAlert("Invalid Input", "Please enter a valid integer for the size of the list.", Alert.AlertType.ERROR);
            }
        });

        final boolean[] userDefinedAdded = {false};
        userDefinedButton.setOnAction(e -> {
            if (!userDefinedAdded[0]) {
                Label userDefinedLabel = new Label("Enter the list (comma-separated):");
                TextField userDefinedInput = new TextField();
                Button confirmButton = new Button("Create");

                createMenu.getChildren().addAll(userDefinedLabel, userDefinedInput, confirmButton);

                userDefinedAdded[0] = true;

                confirmButton.setOnAction(event -> {
                    String input = userDefinedInput.getText();
                    String[] elements = input.split(",");
                    list.setCapacity(elements.length);
                    list.create(); 
                    try {
                        for (String element : elements) {
                            list.insert(Integer.parseInt(element.trim()));
                        }
                        updateVisualization.run();
                    } catch (NumberFormatException ex) {
                        AlertUtils.showAlert("Invalid Input", "Please enter a valid comma-separated list of integers.", Alert.AlertType.ERROR);
                    }
                });
            } 
        });

        return createMenu;
    }
}
