package ToDoListManager;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class UI extends Application{
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Login page items
        Text email = new Text("Email");
        Text password = new Text("Password");
        TextField loginField1 = new TextField();
        PasswordField loginField2 = new PasswordField();
        Button login = new Button("Log in");
        Button register = new Button("Register");

        // Register Page items
        TextField username = new TextField();
        TextField newPasswordField = new TextField();
        TextField firstName = new TextField();
        TextField lastName = new TextField();
        TextField biography = new TextField();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select a profile picture");
        Button pic = new Button("Upload");
        Button reg = new Button("Register");
        Text newUsername = new Text("Username");
        Text newPassword = new Text("Password");
        Text newFirstname = new Text ("First Name");
        Text newLastname = new Text("Last Name");
        Text newBiography = new Text("Biography");
        Text newProfilePic = new Text("Profile Picture");


        // log in pane
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


        // register pane
        GridPane registerPane = new GridPane();
        registerPane.setMinSize(400,600);
        registerPane.setPadding(new Insets(10, 10, 10, 10));
        registerPane.setVgap(5);
        registerPane.setHgap(5);
        registerPane.setAlignment(Pos.CENTER);
        registerPane.add(newPassword, 0,0);
        registerPane.add(newPasswordField, 1, 0);
        registerPane.add(newUsername, 0, 1);
        registerPane.add(username, 1,1);
        registerPane.add(newFirstname,0,2);
        registerPane.add(firstName, 1,2);
        registerPane.add(newLastname,0,3);
        registerPane.add(lastName,1,3);
        registerPane.add(newBiography,0,4);
        registerPane.add(biography,1,4);
        registerPane.add(newProfilePic,0,5);
        registerPane.add(pic,1,5);
        registerPane.add(reg,0,6);

        // Scenes
        Scene loginScreen = new Scene(gridPane);
        Scene registerScreen = new Scene(registerPane);

        //button actions

        register.setOnAction(value -> {  // this button is on the login screen
            Stage registerStage = new Stage();
            registerStage.setScene(registerScreen);
            registerStage.show();
        });

        pic.setOnAction(value -> {  // this button is on the register screen
            // File file = fileChooser.showOpenDialog(stage);
            // if (file != null) {
            //     openFile(file);
            // }

            System.out.print("This feature will be replaced soon!");
        });

        reg.setOnAction(value -> { // this button is on the register screen
            registerUser(username.getText(), newPasswordField.getText(), firstName.getText(), lastName.getText(), biography.getText());

        });

        stage.setTitle("To Do List Manager");

        stage.setScene(loginScreen);

        stage.show();
    }


}
