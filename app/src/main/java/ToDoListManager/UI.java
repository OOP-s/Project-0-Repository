package ToDoListManager;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.IOException;

import static ToDoListManager.Manager.*;
import static javafx.collections.FXCollections.*;

public class UI extends Application{
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Admin admin = new Admin();
        Stage registerStage = new Stage();
        Stage adminStage = new Stage();

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
        Text error1 = new Text("Incorrect email or password");

        //admin page items
        TableView<UserTemplate> userTable = new TableView<>();
        final ObservableList<UserTemplate> userArrayList = observableArrayList(users);
        final ObservableList<UserTemplate> adminArrayList = observableArrayList(admin);
        final ObservableList<UserTemplate> data = concat(userArrayList, adminArrayList);
        userTable.setEditable(true);

        TableColumn nameCol = new TableColumn("Name");
        nameCol.setMinWidth(120);
        nameCol.setCellValueFactory(
                new PropertyValueFactory<UserTemplate, String>("firstname+lastname"));

        TableColumn passwordCol = new TableColumn("Password");
        passwordCol.setMinWidth(100);
        passwordCol.setCellValueFactory(
                new PropertyValueFactory<User, String>("password"));

        TableColumn emailCol = new TableColumn("Email");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<User, String>("username"));

        userTable.setItems(data);
        userTable.getColumns().addAll(nameCol, emailCol, passwordCol);
        passwordCol.setCellFactory(TextFieldTableCell.forTableColumn());
        passwordCol.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<UserTemplate, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<UserTemplate, String> t) {
                        ((User) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setPassword(t.getNewValue());
                    }
                }
        );

        Button searchButton = new Button("Search");
        TextField searchBar = new TextField();
        searchBar.setPromptText("Search here");


        // log in pane
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(200,150);
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
        gridPane.add(error1,2,2);
        error1.setVisible(false);


        // register pane
        GridPane registerPane = new GridPane();
        registerPane.setMinSize(400,300);
        registerPane.setPadding(new Insets(10, 10, 10, 10));
        registerPane.setVgap(5);
        registerPane.setHgap(5);
        registerPane.setAlignment(Pos.CENTER);
        registerPane.add(newPassword, 0,1);
        registerPane.add(newPasswordField, 1, 1);
        registerPane.add(newUsername, 0, 0);
        registerPane.add(username, 1,0);
        registerPane.add(newFirstname,0,2);
        registerPane.add(firstName, 1,2);
        registerPane.add(newLastname,0,3);
        registerPane.add(lastName,1,3);
        registerPane.add(newBiography,0,4);
        registerPane.add(biography,1,4);
        registerPane.add(newProfilePic,0,5);
        registerPane.add(pic,1,5);
        registerPane.add(reg,0,6);

        // admin Pane
        GridPane adminPane = new GridPane();
        adminPane.setMinSize(400,500);
        adminPane.setPadding(new Insets(10, 10, 10, 10));
        adminPane.setVgap(5);
        adminPane.setHgap(5);
        adminPane.setAlignment(Pos.CENTER);
        adminPane.add(userTable,0 ,0,3,10);
        adminPane.add(searchButton,1,10);
        adminPane.add(searchBar,2,10);


        // Scenes
        Scene loginScreen = new Scene(gridPane);
        Scene registerScreen = new Scene(registerPane);
        Scene adminScreen = new Scene(adminPane);

        //button actions

        register.setOnAction(value -> {  // this button is on the login screen
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
            try {
                registerUser(username.getText(), newPasswordField.getText(), firstName.getText(), lastName.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
            registerStage.hide();
        });

        login.setOnAction(value -> { // this button is on the login screen
            System.out.println(loginUser(loginField1.getText(), loginField2.getText()));
            System.out.println(loginField1.getText());
            System.out.println(admin.getUsername());
            System.out.println(admin.getPassword());
            System.out.println(loginField2.getText());
            if(loginUser(loginField1.getText(), loginField2.getText()) == 2){
                error1.setVisible(false);
                stage.hide();
                // next screen
                // different for admin change later
                adminStage.setScene(adminScreen);
                adminStage.show();
            } else if(loginUser(loginField1.getText(), loginField2.getText()) == 1) {
                error1.setVisible(false);
                stage.hide();
                // next screen
            } else {
                error1.setVisible(true);
                loginField1.clear();
                loginField2.clear();
            }
        });

        stage.setTitle("To Do List Manager");
        registerStage.setTitle("Register new user");
        adminStage.setTitle("Users");


        stage.setScene(loginScreen);

        stage.show();
    }


}
