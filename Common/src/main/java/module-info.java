module com.example.common {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.annotation;


    opens edu.sdccd.cisc191.template to javafx.fxml;
    //exports edu.sdccd.cisc191.template;
}