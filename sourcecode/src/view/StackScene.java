package view;

<<<<<<< HEAD
import controller.CreateMenuController;
import controller.PushMenuController;
import controller.SceneController;
import datastructure.Stack;
=======
import controller.SceneController;
import datastructure.*;
>>>>>>> 2e15e541136f2910545ac10e9cdfe94a74ba17a4
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
<<<<<<< HEAD
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
=======
import javafx.scene.control.Button;
import javafx.scene.control.Label;
>>>>>>> 2e15e541136f2910545ac10e9cdfe94a74ba17a4
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
<<<<<<< HEAD
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import utility.ButtonUtils;
=======
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import utility.*;
>>>>>>> 2e15e541136f2910545ac10e9cdfe94a74ba17a4

public class StackScene {

	private Stack stack; // Instance of the Stack data structure
<<<<<<< HEAD
	private VBox currentVBox = null; // To track the current VBox displayed
	private VBox stackVisualization; // Visualization of the Stack

	public Scene createStackScene(SceneController sceneController) {
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(10));
		this.stack = new Stack(5);
		stack.createRandom(5);
=======
	private VBox stackVisualization; // Visualization of the Stack

	public StackScene() {
		// Initialize the Stack
		this.stack = new Stack(10); // Default size 10
	}

	public Scene createStackScene(SceneController sceneController) {
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(10));
>>>>>>> 2e15e541136f2910545ac10e9cdfe94a74ba17a4

		// Title
		Label title = new Label("Stack Operations");
		title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
		BorderPane.setAlignment(title, Pos.CENTER);
		root.setTop(title);

		// Operation Buttons
		HBox operationButtons = createOperationButtons(sceneController);
		root.setLeft(operationButtons);

<<<<<<< HEAD
		// Stack Visualization with ScrollPane
=======
		// Stack Visualization
>>>>>>> 2e15e541136f2910545ac10e9cdfe94a74ba17a4
		stackVisualization = new VBox(10);
		stackVisualization.setAlignment(Pos.BOTTOM_CENTER);
		stackVisualization.setPadding(new Insets(5));
		stackVisualization.setPrefWidth(300);
<<<<<<< HEAD

		// ScrollPane to add scrolling capability
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setContent(stackVisualization);
		scrollPane.setFitToWidth(true); // Đảm bảo vừa với chiều rộng
		scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS); // Luôn hiển thị thanh cuộn
		scrollPane.setPannable(true); // Cho phép kéo nội dung bằng chuột

		// Thêm ScrollPane vào phần phải (thay vì VBox trực tiếp)
		root.setRight(scrollPane);
		updateVisualization();
=======
		stackVisualization.setPrefHeight(400);
		root.setCenter(stackVisualization);

>>>>>>> 2e15e541136f2910545ac10e9cdfe94a74ba17a4
		return new Scene(root, 1000, 600);
	}

	private HBox createOperationButtons(SceneController sceneController) {
		VBox buttonLayout = new VBox(10);
		buttonLayout.setPadding(new Insets(10));
		buttonLayout.setPrefWidth(100);
		buttonLayout.setPrefHeight(400);
		buttonLayout.setAlignment(Pos.TOP_LEFT);

		Button createButton = ButtonUtils.createStyledButton("Create");
		Button pushButton = ButtonUtils.createStyledButton("Push");
		Button popButton = ButtonUtils.createStyledButton("Pop");
		Button topButton = ButtonUtils.createStyledButton("Top");
		Button backButton = ButtonUtils.createStyledButton("Back");

		buttonLayout.getChildren().addAll(createButton, pushButton, popButton, topButton, backButton);

		HBox userInteractSpace = new HBox(10);
		userInteractSpace.setPadding(new Insets(10));
		userInteractSpace.setAlignment(Pos.TOP_LEFT);
		userInteractSpace.getChildren().add(buttonLayout);

<<<<<<< HEAD
		createButton.setOnAction(e -> {
			replaceCurrentVBox(userInteractSpace, CreateMenuController.createMenu(stack, this::updateVisualization));
		});

		pushButton.setOnAction(e -> {
			replaceCurrentVBox(userInteractSpace, PushMenuController.createPushMenu(stack, this::updateVisualization));
=======
		// Set up button actions
		createButton.setOnAction(e -> {
			stack.create(); // Reinitialize stack
			updateVisualization();
		});

		pushButton.setOnAction(e -> {
			int newValue = (int) (Math.random() * 100); // Generate random value
			stack.push(newValue);
			updateVisualization();
>>>>>>> 2e15e541136f2910545ac10e9cdfe94a74ba17a4
		});

		popButton.setOnAction(e -> {
			try {
				stack.pop();
				updateVisualization();
			} catch (IllegalStateException ex) {
<<<<<<< HEAD
				showAlert("Error", "Stack is empty. Cannot pop an element.");
=======
				AlertUtils.showAlert("Error", "Stack is empty. Cannot pop an element.", Alert.AlertType.ERROR);
>>>>>>> 2e15e541136f2910545ac10e9cdfe94a74ba17a4
			}
		});

		topButton.setOnAction(e -> {
			try {
				int topValue = stack.peek();
<<<<<<< HEAD
				showAlert("Top Element", "The top element is: " + topValue);
			} catch (IllegalStateException ex) {
				showAlert("Error", "Stack is empty. No top element.");
			}
		});

		backButton.setOnAction(e -> sceneController.switchTo("Main"));
=======
				AlertUtils.showAlert("Top Element", "The top element is: " + topValue, Alert.AlertType.INFORMATION);
			} catch (IllegalStateException ex) {
				AlertUtils.showAlert("Error", "Stack is empty. No top element.", Alert.AlertType.ERROR);
			}
		});

		backButton.setOnAction(e -> sceneController.switchTo("Menu"));
>>>>>>> 2e15e541136f2910545ac10e9cdfe94a74ba17a4

		return userInteractSpace;
	}

<<<<<<< HEAD
	private void replaceCurrentVBox(HBox container, VBox newVBox) {
		if (currentVBox != null) {
			container.getChildren().remove(currentVBox);
		}
		container.getChildren().add(newVBox);
		currentVBox = newVBox;
	}

	private void updateVisualization() {
		stackVisualization.getChildren().clear();

		int[] elements = stack.getElements();
		stack.display();
		int size = stack.getsize();

		for (int i = 0; i < size; i++) {
			int element = elements[size - 1 - i];

			Circle circle = new Circle(25, Color.LIGHTGREEN);
			circle.setStroke(Color.BLACK);

			Text text = new Text(String.valueOf(element));

			String positionText = "";
			if (i == 0)
				positionText = "head/" + i;
			else if (i == size - 1)
				positionText = "tail/" + i;
			Text positionLabel = new Text(positionText);
			positionLabel.setFill(Color.RED);
			// Gộp node và label vào VBox
			VBox node = new VBox(-5);
			node.setPadding(new Insets(0));
			node.setAlignment(Pos.CENTER);
			// Tạo StackPane cho Circle và Text
			StackPane stackPane = new StackPane(circle, text);
			node.getChildren().addAll(stackPane, positionLabel);
			// Thêm arrow nếu không phải node cuối cùng
			stackVisualization.getChildren().add(node);
			if (i < size - 1) {
				Text arrowText = new Text("↓");
				arrowText.setStyle("-fx-font-size: 30px;");
				VBox arrow = new VBox(-10);
				arrow.setPadding(new Insets(0));
				arrow.setAlignment(Pos.CENTER);
				arrow.getChildren().add(arrowText);
				stackVisualization.getChildren().add(arrow);
			}
		}
	}

	// Method to show an alert dialog
	private void showAlert(String title, String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}
=======
	// Method to update the visualization of the Stack
	private void updateVisualization() {
		stackVisualization.getChildren().clear();

		for (int i = stack.getsize() - 1; i >= 0; i--) {
			int element = stack.getElements()[i];
			Rectangle rectangle = new Rectangle(80, 40);
			rectangle.setFill(Color.LIGHTGREEN);
			rectangle.setStroke(Color.BLACK);

			Text text = new Text(String.valueOf(element));
			StackPane stackPane = new StackPane(rectangle, text);

			stackVisualization.getChildren().add(stackPane);
		}
	}	
>>>>>>> 2e15e541136f2910545ac10e9cdfe94a74ba17a4
}
