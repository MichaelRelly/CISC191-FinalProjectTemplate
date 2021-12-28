package edu.sdccd.cisc191.template;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    // @Override
    public void start(Stage primaryStage) {

        // Construct a new javaFX TableView
        TableView tableView = new TableView();

        // Construct a new javaFX TableColumn to eventually store title
        TableColumn<Media, String> column1 = new TableColumn<>("Title");
        column1.setCellValueFactory(new PropertyValueFactory<>("title"));

        // Construct a new javaFX TableColumn to eventually store duration
        TableColumn<Media, Integer> column2 = new TableColumn<>("Duration");
        column2.setCellValueFactory(new PropertyValueFactory<>("durationInMinutes"));

        // Construct a new javaFX TableColumn to eventually store type
        TableColumn<Media, String> column3 = new TableColumn<>("Type");
        column3.setCellValueFactory(new PropertyValueFactory<>("type"));

        // Construct a new javaFX TableColumn to eventually store director
        TableColumn<Media, String> column4 = new TableColumn<>("Producer");
        column4.setCellValueFactory(new PropertyValueFactory<>("producer"));

        // Add all the columns to the TableView
        tableView.getColumns().addAll(column1, column2, column3, column4);

        MediaCollection MediaCollection = new MediaCollection("media.txt");
        ArrayList<Media> medias = MediaCollection.displayTree();

        ConsoleDisplay consoleDisplay = new ConsoleDisplay("Console Display");
        consoleDisplay.start();


        tableView.getItems().addAll(medias);

        Button btn= new Button("Exit");

        btn.setOnAction(actionEvent -> {
            System.exit(0);
        });

        // Construct a new JavaFX VBox with tableView
        VBox vbox = new VBox(tableView);

        // Use to construct a javaFX scene
        Scene scene = new Scene(vbox);

        // Set the scene and finally show the JavaFX primary stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}