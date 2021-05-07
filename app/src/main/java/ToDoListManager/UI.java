package ToDoListManager;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import static ToDoListManager.Manager.*;
import static ToDoListManager.fileRead.projectsFileReader;

public class UI extends Application{
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        Image image1 = new Image(new FileInputStream("userInfo/oop-s-splashscreen.png"));
        Stage registerStage = new Stage();
        Stage adminStage = new Stage();
        Stage splashStage = new Stage();
        Stage mainStage = new Stage();

        // Login page items
        Text email = new Text("Username");
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
        TableView<User> userTable = new TableView<>();

        //for (User user:returnUsers()) {userList.add(user)

        //}
        ArrayList<String> userArrayList = returnUsers();

        userTable.setEditable(true);
        var nameCol = new TableColumn("Name");
        nameCol.setMinWidth(120);
        TableColumn passwordCol = new TableColumn("Password");
        passwordCol.setMinWidth(100);
        TableColumn emailCol = new TableColumn("Username");
        emailCol.setMinWidth(200);

        ArrayList<User> UserList = new ArrayList<>();

        for (String user: userArrayList) {
            //retrieving the username and password from each string.
            String savedUsername = user.substring(11, user.indexOf(" Password: "));

            String savedPassword = user.substring(user.indexOf("Password: ") + 10, user.indexOf(" Name:"));

            String savedName = user.substring(user.indexOf("Name: ") + 5, user.indexOf(" Biography:"));
            StringTokenizer newSavedName = new StringTokenizer(savedName);
            String savedFirstName = newSavedName.nextToken();
            String savedLastName = newSavedName.nextToken();
            UserList.add(new User(savedUsername, savedPassword, savedFirstName, savedLastName));
            System.out.println(savedFirstName);
            System.out.println(savedLastName);
        }
        final ObservableList<User> ObservableUserList = FXCollections.observableArrayList(UserList);

            nameCol.setCellValueFactory(
                    new PropertyValueFactory<ArrayList<User>, String>("Name"));
            passwordCol.setCellValueFactory(
                    new PropertyValueFactory<ArrayList<User>, String>("password"));
            emailCol.setCellValueFactory(
                    new PropertyValueFactory<ArrayList<User>, String>("username"));


        userTable.setItems(ObservableUserList);
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
        ); //changing the password in the field doesn't actually change the password

        Button logoutButton1 = new Button("Logout");
        Button searchButton = new Button("Search");
        TextField searchBar = new TextField();
        searchBar.setPromptText("Search here");

        //main page items
        TextField mainSearch = new TextField();
        mainSearch.setPromptText("Search here");
        Button search = new Button("Search");
        Button addListButton = new Button("Add List");
        Button addSublistButton = new Button("Add Sublist");
        Button addTaskButton = new Button("Add Button");
        Button addSubtask = new Button("Add Subtask");
        Button logoutButton2 = new Button("Logout");
        TabPane listTabs = new TabPane();
        TabPane sublistTab1 = new TabPane();
        Tab tab1 = new Tab("Completed", new Label("Show all completed tasks"));
        Tab tab2 = new Tab("Upcoming", new Label("Show all Upcoming tasks"));
        Tab tab3 = new Tab("Overdue", new Label("Show all overdue tasks"));
        Tab tab4 = new Tab("Today", sublistTab1);

        Tab tab5 = new Tab("Subproject 1", new Label("Here you would put some tasks"));
        Tab tab6 = new Tab("Subproject 2", new Label("Here are some more tasks"));

        //CheckBox taskCheck1 = new CheckBox(task.getTitle());
        //String labels = "";
        //for (String label:task.getLabelList()){
        //    labels.concat(label);
        //}
        //Label taskLabel1 = new Label(labels);
        //for (String subtask:task.getSubtaskList(){
        //    structure.add(new CheckBox(subtask.getTitle()));
        //}



        listTabs.getTabs().add(tab1);
        listTabs.getTabs().add(tab2);
        listTabs.getTabs().add(tab3);
        listTabs.getTabs().add(tab4);
        sublistTab1.getTabs().add(tab5);
        sublistTab1.getTabs().add(tab6);

        //for(String project:user.getLinkedList()){
        //    listTabs.getTabs().add(new Tab(project.getTitle(), new TabPane().getTabs().add(new Tab(project.getSubproject().getTitle(), "tasks"))));
        //}


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
        gridPane.add(error1,0,3);
        error1.setVisible(false);


        // register pane
        GridPane registerPane = new GridPane();
        registerPane.setMinSize(200,300);
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
        adminPane.add(userTable,0 ,0,4,10);
        adminPane.add(searchButton,1,10);
        adminPane.add(searchBar,2,10);
        adminPane.add(logoutButton1,3,10);

        //main Pane
        HBox hbox = new HBox(mainSearch, search, addListButton,addSublistButton,addTaskButton,addSubtask,logoutButton2);
        VBox vbox = new VBox(listTabs,hbox);


        // Scenes
        ImageView splashView = new ImageView(image1);
        splashView.setFitHeight(600);
        splashView.setFitWidth(650);
        splashView.setPreserveRatio(true);
        Group root = new Group(splashView);
        Scene splashScreen = new Scene(root);
        Scene loginScreen = new Scene(gridPane);
        Scene registerScreen = new Scene(registerPane);
        Scene adminScreen = new Scene(adminPane);
        Scene mainScreen = new Scene(vbox);

        //button actions

        register.setOnAction(value -> {  // this button is on the login screen
            registerStage.setScene(registerScreen);
            registerStage.show();
        });

        pic.setOnAction(value -> {  // this button is on the register screen
            //File file = fileChooser.showOpenDialog(stage);
            //if (file != null) {
            //    openFile(file);
            //}

            System.out.print("This feature will be replaced soon!");
        });

        reg.setOnAction(value -> { // this button is on the register screen
            try {
                Manager.registerUser(username.getText(), newPasswordField.getText(), firstName.getText(), lastName.getText(), biography.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
            username.clear();
            newPasswordField.clear();
            firstName.clear();
            lastName.clear();
            biography.clear();
            registerStage.hide();
        });

        login.setOnAction(value -> { // this button is on the login screen
            try {
                if(loginUser(loginField1.getText(), loginField2.getText()) == 2){
                    error1.setVisible(false);
                    stage.hide();
                    // next screen
                    // different for admin change later
                    adminStage.setScene(adminScreen);
                    adminStage.show();
                } else if(loginUser(loginField1.getText(), loginField2.getText()) == 1) {
                    error1.setVisible(false);
                    // next screen
                    //getUser(userArrayList, loginField1.getText());
                    //ArrayList<Project> currentUserProjects = new ArrayList<>();
                    //for (String project ) {

                    //}
                    stage.hide();
                    mainStage.setScene(mainScreen);
                    mainStage.show();
            } else {
                    error1.setVisible(true);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            loginField1.clear();
                loginField2.clear();
        });

        logoutButton1.setOnAction(value -> { // This button is for the admin page
            //save information somehow
            adminStage.hide();
            stage.show();
        });

        logoutButton2.setOnAction(value -> { // this button is for the main page
            //save information somehow
            mainStage.hide();
            stage.show();
        });

        stage.setTitle("To Do List Manager");
        registerStage.setTitle("Register new user");
        adminStage.setTitle("Users");
        mainStage.setTitle("To Do List Manager");


        stage.setScene(loginScreen);
        splashStage.setScene(splashScreen);
        splashStage.show();
        PauseTransition wait = new PauseTransition(Duration.seconds(2));
        wait.setOnFinished(value -> {
            splashStage.hide();
            stage.show();
        });
        wait.play();
    }
}
