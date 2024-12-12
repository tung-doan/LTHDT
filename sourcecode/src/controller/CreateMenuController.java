package controller;


import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class CreateMenuController {

    public static VBox createMenu() {
        VBox createMenu = new VBox(10);

        Label sizeLabel = new Label("Enter size of the list:");
        TextField sizeInput = new TextField();
        Button randomButton = new Button("Random");
        Button userDefinedButton = new Button("User Defined");
        
        createMenu.getChildren().addAll(sizeLabel, sizeInput, randomButton, userDefinedButton);
        createMenu.setAlignment(Pos.BOTTOM_CENTER);

        randomButton.setOnAction(e -> {
            
        });

        userDefinedButton.setOnAction(e -> {
            Label userDefinedLabel = new Label("Enter the list:");
            TextField userDefinedInput = new TextField();
            Button confirmButton = new Button("Confirm");
            createMenu.getChildren().addAll(userDefinedLabel, userDefinedInput, confirmButton);
        });

        return createMenu;
    }
}
