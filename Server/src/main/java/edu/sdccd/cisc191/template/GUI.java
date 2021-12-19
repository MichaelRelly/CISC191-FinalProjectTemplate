package edu.sdccd.cisc191.template;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.util.ArrayList;

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

        VideoCollection videoCollection = new VideoCollection("media.txt");
        ArrayList<Video> videos = videoCollection.displayTree();

        ConsoleDisplay consoleDisplay = new ConsoleDisplay("Console Display");
        consoleDisplay.start();

        tableView.getItems().addAll(videos);

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
