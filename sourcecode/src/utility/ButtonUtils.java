package utility;

import javafx.scene.control.Button;
// TẠO MÀU, SIZE CHO CÁC NÚT ĐỂ ĐỒNG NHẤT
public class ButtonUtils {

    public static Button createStyledButton(String text) {
        Button button = new Button(text);
        button.setPrefWidth(200);
        button.setStyle("-fx-background-color: linear-gradient(to bottom, #4CAF50, #2E7D32); " +
                        "-fx-text-fill: white; " +
                        "-fx-font-size: 14px; " +
                        "-fx-border-radius: 5px; " +
                        "-fx-background-radius: 5px;");
        button.setOnMousePressed(e -> button.setStyle("-fx-background-color: linear-gradient(to bottom, #388E3C, #1B5E20); " +
                                                     "-fx-text-fill: white; " +
                                                     "-fx-font-size: 14px; " +
                                                     "-fx-border-radius: 5px; " +
                                                     "-fx-background-radius: 5px;"));
        button.setOnMouseReleased(e -> button.setStyle("-fx-background-color: linear-gradient(to bottom, #4CAF50, #2E7D32); " +
                                                     "-fx-text-fill: white; " +
                                                     "-fx-font-size: 14px; " +
                                                     "-fx-border-radius: 5px; " +
                                                     "-fx-background-radius: 5px;"));
        return button;
    }
    public static void highlightButton(Button button) {
        button.setStyle("-fx-background-color: linear-gradient(to bottom, #388E3C, #1B5E20); " +
                        "-fx-text-fill: white; " +
                        "-fx-font-size: 14px; " +
                        "-fx-border-radius: 5px; " +
                        "-fx-background-radius: 5px;");
    }
}
