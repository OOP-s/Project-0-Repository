package ToDoListManager;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UI extends Application{
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Text email = new Text("Email");

        Text password = new Text("Password");

        TextField loginField1 = new TextField();

        PasswordField loginField2 = new PasswordField();

        Button register = new Button("Register");

        Button login = new Button("Log in");

        GridPane gridPane = new GridPane();

        gridPane.setMinSize(400,200);

        gridPane.setPadding(new Insets(10, 10, 10, 10));

        gridPane.setVgap(5);

        gridPane.setHgap(5);

        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(email,0,0);
        gridPane.add(loginField1,1,0);
        gridPane.add(password,0,1);
        gridPane.add(loginField2,1,1);
        gridPane.add(register,0,2);
        gridPane.add(login, 1,2);

        Scene scene = new Scene(gridPane);

        stage.setTitle("To Do List Manager");

        stage.setScene(scene);

        stage.show();
    }


}
