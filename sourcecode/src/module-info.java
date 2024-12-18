module OOPProject {
	requires transitive javafx.controls;
	requires transitive javafx.fxml;
	requires transitive javafx.graphics;

	opens app to javafx.fxml;
	opens datastructure to javafx.fxml, javafx.graphics;

	exports app;
	exports controller;
	exports datastructure;
}