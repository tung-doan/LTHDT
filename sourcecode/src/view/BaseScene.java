package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import controller.SceneController;

public abstract class BaseScene {

	protected VBox currentVBox = null;
	protected VBox visualizationBox;

	public Scene createBaseScene(SceneController sceneController, String titleText) {
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(10));

		Label title = new Label(titleText);
		title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
		BorderPane.setAlignment(title, Pos.CENTER);
		root.setTop(title);

		HBox operationButtons = createOperationButtons(sceneController);
		root.setLeft(operationButtons);

		visualizationBox = new VBox(10);
		visualizationBox.setAlignment(Pos.BOTTOM_CENTER);
		visualizationBox.setPadding(new Insets(5));
		visualizationBox.setPrefWidth(300);

		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setContent(visualizationBox);
		scrollPane.setFitToWidth(true);
		scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
		scrollPane.setPannable(true);

		root.setRight(scrollPane);
		return new Scene(root, 1000, 600);
	}

	protected abstract HBox createOperationButtons(SceneController sceneController);

	protected void replaceCurrentVBox(HBox container, VBox newVBox) {
		if (currentVBox != null) {
			container.getChildren().remove(currentVBox);
		}
		container.getChildren().add(newVBox);
		currentVBox = newVBox;
	}
}