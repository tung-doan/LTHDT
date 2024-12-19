package utility;

import java.awt.Button;

public class ButtonUtils {

<<<<<<< HEAD
	// Method to create a styled button with press/release color change
	public static Button createStyledButton(String text) {
		Button button = new Button(text);
		button.setPrefWidth(100);
=======
    // Method to create a styled button with press/release color change
    public static Button createStyledButton(String text) {
        Button button = new Button(text);
        button.setPrefWidth(100);
        button.setMaxWidth(150);
>>>>>>> 2e15e541136f2910545ac10e9cdfe94a74ba17a4

		// Set the default style for the button
		button.setStyle(
				"-fx-background-color: linear-gradient(to bottom, #4CAF50, #2E7D32); " + "-fx-text-fill: white; "
						+ "-fx-font-size: 14px; " + "-fx-border-radius: 5px; " + "-fx-background-radius: 5px;");

		// Change color when the button is pressed
		button.setOnMousePressed(e -> {
			button.setStyle(
					"-fx-background-color: linear-gradient(to bottom, #388E3C, #1B5E20); " + "-fx-text-fill: white; "
							+ "-fx-font-size: 14px; " + "-fx-border-radius: 5px; " + "-fx-background-radius: 5px;");
		});

		// Reset the button style when the mouse is released
		button.setOnMouseReleased(e -> {
			button.setStyle(
					"-fx-background-color: linear-gradient(to bottom, #4CAF50, #2E7D32); " + "-fx-text-fill: white; "
							+ "-fx-font-size: 14px; " + "-fx-border-radius: 5px; " + "-fx-background-radius: 5px;");
		});

<<<<<<< HEAD
		return button;
	}

	public static void highlightButton(Button button) {
		button.setStyle("-fx-background-color: linear-gradient(to bottom, rgb(51, 34, 201), rgb(16, 21, 90)); "
				+ "-fx-text-fill: white; " + "-fx-font-size: 14px; " + "-fx-border-radius: 5px; "
				+ "-fx-background-radius: 5px;");
	}
=======
        return button;
    }
>>>>>>> 2e15e541136f2910545ac10e9cdfe94a74ba17a4
}
