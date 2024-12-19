package view;

import controller.*;
import datastructure.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import utility.ButtonUtils;

public class QueueScene {

    private Queue queue; // Instance of the Queue data structure
    private VBox currentVBox = null; // To track the current VBox displayed
    private VBox queueVisualization; // Visualization of the Queue

    public Scene createQueueScene(SceneController sceneController) {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));
        this.queue = new Queue(5);
        queue.createRandom(5);

        // Title
        Label title = new Label("Queue Operations");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        BorderPane.setAlignment(title, Pos.CENTER);
        root.setTop(title);

        // Operation Buttons
        HBox operationButtons = createOperationButtons(sceneController);
        root.setLeft(operationButtons);

        // Queue Visualization with ScrollPane
        queueVisualization = new VBox(10);
        queueVisualization.setAlignment(Pos.BOTTOM_CENTER);
        queueVisualization.setPadding(new Insets(5));
        queueVisualization.setPrefWidth(300);

        // ScrollPane to add scrolling capability
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(queueVisualization);
        scrollPane.setFitToWidth(true);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setPannable(true);

        // Add ScrollPane to the right side
        root.setRight(scrollPane);
        updateVisualization();
        return new Scene(root, 1000, 600);
    }

    private HBox createOperationButtons(SceneController sceneController) {
        VBox buttonLayout = new VBox(10);
        buttonLayout.setPadding(new Insets(10));
        buttonLayout.setPrefWidth(100);
        buttonLayout.setPrefHeight(400);
        buttonLayout.setAlignment(Pos.TOP_LEFT);

        Button createButton = ButtonUtils.createStyledButton("Create");
        Button enqueueButton = ButtonUtils.createStyledButton("Enqueue");
        Button dequeueButton = ButtonUtils.createStyledButton("Dequeue");
        Button frontButton = ButtonUtils.createStyledButton("Front");
        Button backButton = ButtonUtils.createStyledButton("Back");

        buttonLayout.getChildren().addAll(createButton, enqueueButton, dequeueButton, frontButton, backButton);

        HBox userInteractSpace = new HBox(10);
        userInteractSpace.setPadding(new Insets(10));
        userInteractSpace.setAlignment(Pos.TOP_LEFT);
        userInteractSpace.getChildren().add(buttonLayout);

        createButton.setOnAction(e -> {
            replaceCurrentVBox(userInteractSpace, CreateMenuController.createMenu(queue, this::updateVisualization));
        });

        enqueueButton.setOnAction(e -> {
    VBox enqueueMenu = new VBox(10);
    enqueueMenu.setPadding(new Insets(10));
    enqueueMenu.setAlignment(Pos.CENTER);

    Label titleLabel = new Label("Enqueue Element");
    titleLabel.setStyle("-fx-font-weight: bold;");

    TextField elementField = new TextField();
    elementField.setPromptText("Enter element");

    Button enqueueConfirmButton = ButtonUtils.createStyledButton("Enqueue");
    enqueueConfirmButton.setOnAction(event -> {
        try {
            int element = Integer.parseInt(elementField.getText());
            queue.enqueue(element);
            updateVisualization();
            showAlert("Enqueue Success", "Element enqueued successfully.");
        } catch (NumberFormatException ex) {
            showAlert("Error", "Please enter a valid integer.");
        }
    });

    enqueueMenu.getChildren().addAll(titleLabel, elementField, enqueueConfirmButton);

    replaceCurrentVBox(userInteractSpace, enqueueMenu);
});

        dequeueButton.setOnAction(e -> {
            try {
                queue.dequeue();
                updateVisualization();
            } catch (IllegalStateException ex) {
                showAlert("Error", "Queue is empty. Cannot dequeue an element.");
            }
        });

        frontButton.setOnAction(e -> {
            try {
                int frontValue = queue.peek();
                showAlert("Front Element", "The front element is: " + frontValue);
            } catch (IllegalStateException ex) {
                showAlert("Error", "Queue is empty. No front element.");
            }
        });

        backButton.setOnAction(e -> sceneController.switchTo("Main"));

        return userInteractSpace;
    }

    private void replaceCurrentVBox(HBox container, VBox newVBox) {
        if (currentVBox != null) {
            container.getChildren().remove(currentVBox);
        }
        container.getChildren().add(newVBox);
        currentVBox = newVBox;
    }

    private void updateVisualization() {
        queueVisualization.getChildren().clear();

        int[] elements = queue.getElements();
        queue.display();
        int size = queue.getSize();

        for (int i = 0; i < size; i++) {
            int element = elements[(queue.getFront() + i) % queue.getCapacity()];

            Circle circle = new Circle(25, Color.LIGHTBLUE);
            circle.setStroke(Color.BLACK);

            Text text = new Text(String.valueOf(element));

            String positionText = "";
            if (i == 0)
                positionText = "front/" + i;
            else if (i == size - 1)
                positionText = "rear/" + i;
            Text positionLabel = new Text(positionText);
            positionLabel.setFill(Color.RED);

            VBox node = new VBox(-5);
            node.setPadding(new Insets(0));
            node.setAlignment(Pos.CENTER);

            StackPane stackPane = new StackPane(circle, text);
            node.getChildren().addAll(stackPane, positionLabel);

            queueVisualization.getChildren().add(node);

            if (i < size - 1) {
                Text arrowText = new Text("→");
                arrowText.setStyle("-fx-font-size: 30px;");
                VBox arrow = new VBox(-10);
                arrow.setPadding(new Insets(0));
                arrow.setAlignment(Pos.CENTER);
                arrow.getChildren().add(arrowText);
                queueVisualization.getChildren().add(arrow);
            }
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}