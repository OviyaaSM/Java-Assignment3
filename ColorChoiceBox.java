import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ColorChoiceBox extends Application {
    @Override
    public void start(Stage stage) {
        Label label = new Label("Select a color:");
        ChoiceBox<String> colorBox = new ChoiceBox<>();
        colorBox.getItems().addAll("Red", "Green", "Blue", "Yellow");

        Label display = new Label("Your favorite color will appear here.");

        colorBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            display.setText("You selected: " + newVal);
        });

        VBox root = new VBox(10, label, colorBox, display);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Scene scene = new Scene(root, 300, 200);
        stage.setTitle("Color ChoiceBox");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
