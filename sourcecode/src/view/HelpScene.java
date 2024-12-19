package view;

import controller.SceneController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import utility.ButtonUtils;

public class HelpScene {

	public static Scene createHelpScene(SceneController sceneController) {
		// Tạo VBox cho nội dung chính
		VBox helpLayout = new VBox(20);
		helpLayout.setPadding(new Insets(20));
		helpLayout.setAlignment(Pos.CENTER);

		// Tiêu đề
		Label titleLabel = new Label("Help Menu");
		titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

		// Nội dung hướng dẫn
		Label descriptionLabel = new Label("""
				This project demonstrates various data structure operations.

				Basic Usage:
				• List Operations: Create, Insert, Delete, Sort, and Find elements in a list.
				• Stack Operations: Push, Pop, and view the top element of a stack.
				• Queue Operations: Enqueue, Dequeue, and view the front element of a queue.

				Use the buttons on the main menu to navigate to different operations.
				""");
		descriptionLabel.setStyle("-fx-font-size: 14px; -fx-line-spacing: 5px;");
		descriptionLabel.setWrapText(true); // Tự động xuống dòng

		// Thêm ScrollPane nếu nội dung dài
		ScrollPane scrollPane = new ScrollPane(descriptionLabel);
		scrollPane.setFitToWidth(true); // Đảm bảo vừa chiều rộng của giao diện
		scrollPane.setPrefHeight(400); // Giới hạn chiều cao nội dung

		// Nút quay lại
		Button backButton = ButtonUtils.createStyledButton("Back");
		backButton.setOnAction(e -> sceneController.switchTo("Menu"));

		// Thêm các thành phần vào bố cục chính
		helpLayout.getChildren().addAll(titleLabel, scrollPane, backButton);

		// Trả về giao diện
		return new Scene(helpLayout, 800, 600);
	}
}
