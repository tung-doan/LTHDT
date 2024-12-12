package view;

import controller.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import utility.ButtonUtils;

public class ListScene {
    
    public ListScene() {

    }

    public Scene createListScene(SceneController sceneController) {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));

        // Title
        Label title = new Label("List Operations");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        BorderPane.setAlignment(title, Pos.CENTER);
        root.setTop(title);

        // Operation Buttons
        HBox operationButtons = createOperationButtons(sceneController);
        root.setLeft(operationButtons);

        return new Scene(root, 800, 600);
    }
    private VBox currentVBox = null;
    private HBox createOperationButtons(SceneController sceneController) {
        VBox buttonLayout = new VBox(10);
        buttonLayout.setPadding(new Insets(10));
        buttonLayout.setAlignment(Pos.BOTTOM_LEFT);
    
        Button createButton = ButtonUtils.createStyledButton("Create");
        Button insertButton = ButtonUtils.createStyledButton("Insert");
        Button deleteButton = ButtonUtils.createStyledButton("Delete");
        Button sortButton = ButtonUtils.createStyledButton("Sort");
        Button findButton = ButtonUtils.createStyledButton("Find");
        Button backButton = ButtonUtils.createStyledButton("Back");
        buttonLayout.getChildren().addAll(createButton, insertButton, deleteButton, sortButton, findButton, backButton);
    
        HBox UserInteractSpace = new HBox(10);
        UserInteractSpace.setPadding(new Insets(10));
        UserInteractSpace.setAlignment(Pos.BOTTOM_CENTER);
        UserInteractSpace.getChildren().add(buttonLayout);
    
        // Track the currently displayed VBox
        
    
        // Set up button actions to open operation-specific menus
        createButton.setOnAction(e -> {
            ButtonUtils.highlightButton(createButton);
            replaceCurrentVBox(UserInteractSpace, CreateMenuController.createMenu());
        });
        insertButton.setOnAction(e -> {
            ButtonUtils.highlightButton(insertButton);
            replaceCurrentVBox(UserInteractSpace, InsertMenuController.createMenu());
        });
        deleteButton.setOnAction(e -> {
            ButtonUtils.highlightButton(deleteButton);
            replaceCurrentVBox(UserInteractSpace, DeleteMenuController.createMenu());
        });
        sortButton.setOnAction(e -> {
            ButtonUtils.highlightButton(sortButton);
            replaceCurrentVBox(UserInteractSpace, SortMenuController.createMenu());
        });
        findButton.setOnAction(e -> {
            ButtonUtils.highlightButton(findButton);
            replaceCurrentVBox(UserInteractSpace, FindMenuController.createMenu());
        });
        backButton.setOnAction(e -> sceneController.switchTo("Main"));
    
        return UserInteractSpace;
    }
    
    // Helper method to replace the current VBox
    private void replaceCurrentVBox(HBox container, VBox newVBox) {
        if (currentVBox != null) {
            container.getChildren().remove(currentVBox);
        }
        container.getChildren().add(newVBox);
        currentVBox = newVBox;
    }
    
}
