package view;

import controller.SceneController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utility.AlertUtils;
import utility.ButtonUtils;

public class MenuScene {

	public Scene createMenuScene(SceneController sceneController, Stage primaryStage) {
		// Tạo layout chính
		VBox menuLayout = new VBox(20);
		menuLayout.setAlignment(Pos.CENTER);

		Label title = new Label("Data Structure Operations");
		title.setStyle("-fx-font-size: 25px; -fx-font-weight: bold;");
		// Tạo các nút chức năng
		Button listButton = ButtonUtils.createStyledButton("List Operations");
		Button stackButton = ButtonUtils.createStyledButton("Stack Operations");
		Button queueButton = ButtonUtils.createStyledButton("Queue Operations");
		Button helpButton = ButtonUtils.createStyledButton("help");
		Button exitButton = ButtonUtils.createStyledButton("Exit");

		// Set action cho các nút
		listButton.setOnAction(e -> sceneController.switchTo("List"));
		stackButton.setOnAction(e -> sceneController.switchTo("Stack"));
		queueButton.setOnAction(e -> sceneController.switchTo("Queue"));
		helpButton.setOnAction(e -> sceneController.switchTo("Help"));
		exitButton.setOnAction(e -> {
			boolean confirmed = AlertUtils.showConfirmationDialog("Exit Confirmation",
					"Are you sure you want to exit?\n");

			if (confirmed) {
				primaryStage.close(); // đóng
			}
		});

		// Thêm các nút vào layout
		menuLayout.getChildren().addAll(title, listButton, stackButton, queueButton, helpButton, exitButton);

		// Trả về Scene
		return new Scene(menuLayout, 800, 600);
	}
}