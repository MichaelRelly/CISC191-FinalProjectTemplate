module com.example.server {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.sdccd.cisc191.template to javafx.fxml;
    exports edu.sdccd.cisc191.template;
}