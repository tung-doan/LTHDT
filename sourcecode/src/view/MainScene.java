package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import utility.ButtonUtils;
import controller.SceneController;

public class MainScene {

    public Scene createMainScene(SceneController sceneController) {
        // ĐÂY LÀ MAIN MENU. T CHƯA VIẾT NỐT NÚT, MỚI CHỈ CÓ NÚT ĐẾN LIST
        // Create the root layout
        VBox rootLayout = new VBox(20);
        rootLayout.setAlignment(Pos.CENTER);

        // Create the button and set its action
        Button goToListButton = ButtonUtils.createStyledButton("Go to List Operations");
        goToListButton.setOnAction(e -> sceneController.switchTo("List"));
        Button goToStackButton = ButtonUtils.createStyledButton("Go to Stack Operations");
		goToStackButton.setOnAction(e -> sceneController.switchTo("Stack"));

        // Add the button to the layout
        rootLayout.getChildren().addAll(goToListButton,goToStackButton);

        // Create and return the scene
        return new Scene(rootLayout, 800, 600);
    }
}
