package view;

import java.util.ArrayList;

import controller.*;
import datastructure.List;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import utility.*;

public class ListScene {

    private List list; // Instance of the List data structure
    private VBox currentVBox = null; // To track the current VBox displayed
    private ArrayList<StackPane> rectanglePanes;
    private HBox listVisualization; // Visualization of the List

    public ListScene() {
        this.list = new List(10);
        this.rectanglePanes = new ArrayList<>();
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

        // List Visualization
        listVisualization = new HBox(10);
        listVisualization.setAlignment(Pos.TOP_LEFT);
        listVisualization.setPadding(new Insets(5));
        listVisualization.setPrefWidth(800);  
        listVisualization.setPrefHeight(400);
        root.setRight(listVisualization);

        return new Scene(root, 1000, 1000);
    }

    private HBox createOperationButtons(SceneController sceneController) {
        VBox buttonLayout = new VBox(10);
        buttonLayout.setPadding(new Insets(10));
        buttonLayout.setPrefWidth(100); 
        buttonLayout.setPrefHeight(400);
        buttonLayout.setAlignment(Pos.TOP_LEFT);

        Button createButton = ButtonUtils.createStyledButton("Create");
        Button insertButton = ButtonUtils.createStyledButton("Insert");
        Button deleteButton = ButtonUtils.createStyledButton("Delete");
        Button sortButton = ButtonUtils.createStyledButton("Sort");
        Button findButton = ButtonUtils.createStyledButton("Find");
        Button backButton = ButtonUtils.createStyledButton("Back");

        buttonLayout.getChildren().addAll(createButton, insertButton, deleteButton, sortButton, findButton, backButton);

        HBox userInteractSpace = new HBox(10);
        userInteractSpace.setPadding(new Insets(10));
        userInteractSpace.setAlignment(Pos.TOP_LEFT);
        userInteractSpace.getChildren().add(buttonLayout);

        // Set up button actions
        createButton.setOnAction(e -> {
            replaceCurrentVBox(userInteractSpace, CreateMenuController.createMenu(list, this::updateVisualization));
        });
        insertButton.setOnAction(e -> {
            replaceCurrentVBox(userInteractSpace, InsertMenuController.createMenu(list, this::updateVisualization, this::highlightRectangle));
        });
        deleteButton.setOnAction(e -> {
            replaceCurrentVBox(userInteractSpace, DeleteMenuController.createMenu(list, this::updateVisualization));        
        });
        sortButton.setOnAction(e -> {
            list.sort();
            updateVisualization();
        });
        findButton.setOnAction(e -> {
            replaceCurrentVBox(userInteractSpace, FindMenuController.createMenu(list, this::highlightRectangle));
        });
        backButton.setOnAction(e -> sceneController.switchTo("Main"));

        return userInteractSpace;
    }

    // Helper method to replace the current VBox
    private void replaceCurrentVBox(HBox container, VBox newVBox) {
        if (currentVBox != null) {
            container.getChildren().remove(currentVBox);
        }
        container.getChildren().add(newVBox);
        currentVBox = newVBox;
    }

    // Method to update the visualization of the List
    private void updateVisualization() {
        listVisualization.getChildren().clear();
        rectanglePanes.clear();

        int[] elements = list.getElements();
        for (int i = 0; i < list.getSize(); i++) {
            int element = elements[i];

            Rectangle rectangle = new Rectangle(50, 50);
            rectangle.setFill(Color.LIGHTBLUE);
            rectangle.setStroke(Color.BLACK);

            Text text = new Text(String.valueOf(element));
            StackPane stackPane = new StackPane(rectangle, text);
            rectanglePanes.add(stackPane);

            listVisualization.getChildren().add(stackPane);
        }
    }

    // Method to highlight a specific rectangle
    private void highlightRectangle(int index) {
        for (StackPane pane : rectanglePanes) {
            ((Rectangle) pane.getChildren().get(0)).setFill(Color.LIGHTBLUE);
        }

        if (index >= 0 && index < rectanglePanes.size()) {
            ((Rectangle) rectanglePanes.get(index).getChildren().get(0)).setFill(Color.YELLOW);
        }
    }
}