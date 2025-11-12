import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class StudentForm extends Application {
    @Override
    public void start(Stage stage) {
        Label nameLbl = new Label("Name:");
        TextField nameField = new TextField();

        Label genderLbl = new Label("Gender:");
        RadioButton male = new RadioButton("Male");
        RadioButton female = new RadioButton("Female");
        ToggleGroup genderGroup = new ToggleGroup();
        male.setToggleGroup(genderGroup);
        female.setToggleGroup(genderGroup);

        Label deptLbl = new Label("Department:");
        ComboBox<String> deptBox = new ComboBox<>();
        deptBox.getItems().addAll("IT", "CSE", "ECE", "EEE");

        Button submitBtn = new Button("Submit");
        TextArea output = new TextArea();
        output.setEditable(false);

        submitBtn.setOnAction(e -> {
            String name = nameField.getText();
            String gender = ((RadioButton) genderGroup.getSelectedToggle()).getText();
            String dept = deptBox.getValue();
            output.setText("Name: " + name + "\nGender: " + gender + "\nDepartment: " + dept);
        });

        VBox root = new VBox(10, nameLbl, nameField, genderLbl, male, female, deptLbl, deptBox, submitBtn, output);
        root.setPadding(new Insets(15));
        root.setStyle("-fx-alignment: top-center;");

        Scene scene = new Scene(root, 350, 400);
        stage.setTitle("Student Information Form");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
