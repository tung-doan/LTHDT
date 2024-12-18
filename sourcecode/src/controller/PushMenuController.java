package controller;

import datastructure.Stack;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import utility.AlertUtils;

public class PushMenuController {

	// Phương thức tạo giao diện Push và trả về VBox
	public static VBox createPushMenu(Stack stack, Runnable updateVisualization) {
		// Khởi tạo VBox cho giao diện
		VBox pushMenu = new VBox(10);

		// Nhãn và ô nhập giá trị
		Label promptLabel = new Label("Enter values to push (comma separated):");
		TextField valueField = new TextField();
		valueField.setPromptText("e.g., 42, 56, 100");

		// Nút "Go" để xác nhận
		Button goButton = new Button("Go");
		goButton.setOnAction(e -> {
			try {
				// Lấy chuỗi giá trị nhập vào và tách chúng bằng dấu phẩy
				String input = valueField.getText().trim();
				String[] elements = input.split(",");

				// Lặp qua các phần tử và thêm chúng vào stack
				for (String element : elements) {
					// Loại bỏ khoảng trắng xung quanh và chuyển đổi thành số nguyên
					int value = Integer.parseInt(element.trim());
					stack.push(value);
				}

				// Cập nhật giao diện Stack
				updateVisualization.run();
			} catch (NumberFormatException ex) {
				AlertUtils.showAlert("Invalid Input", "Please enter a valid comma-separated list of integers.",
						Alert.AlertType.ERROR);
			} catch (IllegalStateException ex) {
				AlertUtils.showAlert("Stack Overflow", "The stack is full. Cannot push more values.",
						Alert.AlertType.ERROR);
			}
		});

		// Layout cho nút và ô nhập giá trị
		HBox buttonBox = new HBox(10, goButton);
		buttonBox.setAlignment(Pos.CENTER);

		// Thêm các thành phần vào layout
		pushMenu.getChildren().addAll(promptLabel, valueField, buttonBox);

		// Trả về VBox chứa giao diện
		return pushMenu;
	}
}
