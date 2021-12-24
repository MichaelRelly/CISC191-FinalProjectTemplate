package edu.sdccd.cisc191.template;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUI extends Application {

    public static void main(String[] args) {
        launch(args);
        System.out.println("hi");
    }

    // @Override
    public void start(Stage primaryStage) {

        // Construct a new javaFX TableView
        TableView tableView = new TableView();

        // Construct a new javaFX TableColumn to eventually store title
        TableColumn<Video, String> column1 = new TableColumn<>("Title");
        column1.setCellValueFactory(new PropertyValueFactory<>("title"));

        // Construct a new javaFX TableColumn to eventually store duration
        TableColumn<Video, Integer> column2 = new TableColumn<>("Duration");
        column2.setCellValueFactory(new PropertyValueFactory<>("playingTime"));

        // Construct a new javaFX TableColumn to eventually store type
        TableColumn<Video, String> column3 = new TableColumn<>("Type");
        column3.setCellValueFactory(new PropertyValueFactory<>("type"));

        // Construct a new javaFX TableColumn to eventually store director
        TableColumn<Video, String> column4 = new TableColumn<>("Director");
        column4.setCellValueFactory(new PropertyValueFactory<>("director"));

        // Add all the columns to the TableView
        tableView.getColumns().addAll(column1, column2, column3, column4);

        // Instantiate new types of media belonging to some of the co-packaged classes
        CD c = new CD("A Swingin' Affair", "Frank Sinatra", 16, 64);
        CD d = new CD("Big Bad World", "Plain White T's", 10, 35);
        Video x = new Video("O Brother, Where Art You?", "Joel & Ethon Coen",106, VideoType.HD);
        Video y = new Video("O Brother, Where Art You?", "Joel & Ethon Coen",106, VideoType.DVD);
        Video z = new Video("Infinity Wars", "Anthony & Joe Russo",149, VideoType.QHD);

        // Add all these items to the tableView set
        tableView.getItems().addAll(c, d, x,y,z);

        // Construct a new JavaFX VBox with tableView
        VBox vbox = new VBox(tableView);

        // Use to construct a javaFX scene
        Scene scene = new Scene(vbox);

        // Set the scene and finally show the JavaFX primary stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
