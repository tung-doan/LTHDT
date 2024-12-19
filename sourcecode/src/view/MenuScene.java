package view;

import controller.SceneController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import utility.ButtonUtils;

public class MenuScene {

    public Scene createMenuScene(SceneController sceneController) {
        // Tạo layout chính
        VBox menuLayout = new VBox(20);
        menuLayout.setAlignment(Pos.CENTER);

        // Tạo các nút chức năng
        Button listButton = ButtonUtils.createStyledButton("List Operations");
        Button stackButton = ButtonUtils.createStyledButton("Stack Operations");
        Button queueButton = ButtonUtils.createStyledButton("Queue Operations");
        Button backButton = ButtonUtils.createStyledButton("Back to Main Menu");

        // Set action cho các nút
        listButton.setOnAction(e -> sceneController.switchTo("List"));
        stackButton.setOnAction(e -> System.out.println("Stack"));
        queueButton.setOnAction(e -> System.out.println("Queue"));
        backButton.setOnAction(e -> sceneController.switchTo("Main"));

        // Thêm các nút vào layout
        menuLayout.getChildren().addAll(listButton, stackButton, queueButton, backButton);

        // Trả về Scene
        return new Scene(menuLayout, 800, 600);
    }
}
